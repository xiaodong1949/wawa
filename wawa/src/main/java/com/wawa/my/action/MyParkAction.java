package com.wawa.my.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.wawa.basic.action.BasicAction;
import com.wawa.basic.helper.ConstantHelper;
import com.wawa.basic.helper.ConvertVideo;
import com.wawa.manager.bean.User;
import com.wawa.my.bean.Resource;
import com.wawa.my.service.MyService;

/**
 * 我的
 * 
 * @author: Yang Xiaodong
 * @since: 2013年12月24日 下午2:59:35
 * @history:
 */
@Controller
public class MyParkAction extends BasicAction {

	@Autowired
	private MyService myService;

	@RequestMapping("/initMyImage.do")
	public ModelAndView initMyImage() throws Exception {
		User user = this.getUser();
		ModelAndView mav = new ModelAndView();

		List<Resource> resourceList = myService.getMyResource(user.getId(),
				ConstantHelper.RESOURCE_TYPE_IMAGE);
		mav.addObject("imageList", resourceList);
		mav.setViewName("myImage");
		return mav;
	}

	@RequestMapping("/initMyVideo.do")
	public ModelAndView initMyVideo() throws Exception {
		User user = this.getUser();
		ModelAndView mav = new ModelAndView();

		List<Resource> resourceList = myService.getMyResource(user.getId(),
				ConstantHelper.RESOURCE_TYPE_VIDEO);
		mav.addObject("videoList", resourceList);
		mav.setViewName("myVideo");
		return mav;
	}

	@RequestMapping("/uploadMyResource.do")
	public ModelAndView uploadMyResource(
			@RequestParam(required = false) String desc, int resourcetype,
			boolean ispublic, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = this.getUser();
		ModelAndView mav = new ModelAndView();
		 String myappPath = request.getSession().getServletContext()
		 .getRealPath("/");
//		String myappPath = "D:\";
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFiles("myResourceFile").get(0);
			long size = file.getSize();
			byte[] data = new byte[(int) size];
			InputStream input = file.getInputStream();
			input.read(data);
			String filePath = "";
			if (resourcetype == ConstantHelper.RESOURCE_TYPE_IMAGE) {
				filePath = "production" + File.separator + "image"
						+ File.separator + user.getId() + File.separator;
			} else {
				filePath = "production" + File.separator + "video"
						+ File.separator + user.getId() + File.separator;
			}
			File fileDir = new File(myappPath + filePath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			String sname = file.getOriginalFilename().substring(
					file.getOriginalFilename().lastIndexOf("."));
			String newFilename = String.valueOf(Calendar.getInstance()
					.getTimeInMillis()) + sname;
			File outFile = new File(myappPath + filePath + newFilename);
			if (!outFile.exists()) {
				outFile.createNewFile();
			}
			FileOutputStream outStream = new FileOutputStream(outFile);
			outStream.write(data);
			outStream.close();
			input.close();
			Resource rs = new Resource();
			if (resourcetype == ConstantHelper.RESOURCE_TYPE_VIDEO
					&& !sname.toLowerCase().equals("oog")) {
				String videoFileName = "";
				videoFileName = ConvertVideo.processOGG(filePath
						+ newFilename,myappPath);
				if (StringUtils.isBlank(videoFileName)) {
					throw new Exception("no support " + sname);
				}
				rs.setResourcename(videoFileName);
			} else {
				rs.setResourcename(filePath + newFilename);
			}
			rs.setUserid(user.getId());
			rs.setDescription(desc);
			rs.setIspublic(ispublic ? 1 : 0);
			rs.setResourcetype(resourcetype);
			myService.saveResource(rs);
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}
		if (resourcetype == ConstantHelper.RESOURCE_TYPE_IMAGE) {
			mav.setViewName("redirect:/initMyImage.do");
		} else {
			mav.setViewName("redirect:/initMyVideo.do");
		}
		return mav;
	}

	@RequestMapping("/deleteMyResource.do")
	public ModelAndView deleteMyResource(
			@RequestParam(required = false) int id, int resourcetype,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = this.getUser();
		ModelAndView mav = new ModelAndView();
		Resource rs = new Resource();
		rs.setId(id);
		rs.setUserid(user.getId());
		myService.delResource(rs);
		if (resourcetype == ConstantHelper.RESOURCE_TYPE_IMAGE) {
			mav.setViewName("redirect:/initMyImage.do");
		} else {
			mav.setViewName("redirect:/initMyVideo.do");
		}
		return mav;
	}

}
