package com.wawa.my.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.wawa.basic.action.BasicAction;
import com.wawa.basic.helper.ConstantHelper;
import com.wawa.manager.bean.User;
import com.wawa.my.bean.Resource;
import com.wawa.my.service.MyService;

/** 
 * 我的
 * @author: Yang Xiaodong
 * @since: 2013年12月24日 下午2:59:35 
 * @history:
 */
@Controller
public class MyParkAction extends BasicAction {

    @Autowired
    private MyService myService;

    @RequestMapping("/initMyImage.do")
    public ModelAndView initMyAlbum() throws Exception {
        User user = this.getUser();
        ModelAndView mav = new ModelAndView();

        List<Resource> resourceList = myService.getMyResource(user.getId(),
                ConstantHelper.RESOURCE_TYPE_PHOTO);
        mav.addObject("resources", resourceList);
        mav.setViewName("myImage");
        return mav;
    }

    @RequestMapping("/uploadMyResource.do")
    public ModelAndView uploadMyAlbum(@RequestParam(required = false) String desc,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = this.getUser();
        ModelAndView mav = new ModelAndView();
        String myappPath = request.getSession().getServletContext().getRealPath("/");
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
            MultipartFile file = multipartRequest.getFiles("myPicFile").get(0);
            long size = file.getSize();
            byte[] data = new byte[(int)size];
            InputStream input = file.getInputStream();
            input.read(data);
            String filePath = "album" + File.separator + user.getId() + File.separator;
            File fileDir = new File(myappPath + filePath);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            File outFile = new File(myappPath + filePath + file.getOriginalFilename());
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(outFile);
            outStream.write(data);
            outStream.close();
            input.close();
//            myService.savePhoto(user.getId(), filePath + file.getOriginalFilename(), desc);
        } catch(Exception e) {
            logger.error(e);
            throw new Exception(e);
        }
        mav.setViewName("redirect:/initMyAlbum.do");
        return mav;
    }
}
