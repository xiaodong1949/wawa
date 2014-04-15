package com.wawa.manager.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wawa.basic.action.BasicAction;
import com.wawa.manager.bean.User;
import com.wawa.manager.service.ManagerService;
import com.wawa.my.bean.Resource;

/**
 * 管理类Action父类
 * @author Yang Xiaodong
 * 2013年12月3日 下午10:35:36
 */
@Controller
public class ManagerAction extends BasicAction {
    @Autowired
    private ManagerService managerService;

    /** 
     * 登录
     * @param request
     * @param account
     * @param password
     * @return
     * @throws Exception 
     * @create: 2013年12月5日 下午3:10:03 
     * @author: Yang Xiaodong
     * @history: 
     */
    @RequestMapping("/login.do")
    public ModelAndView login(@RequestParam(required = false) String account, String password)
            throws Exception {
        ModelAndView mav = new ModelAndView();
        User user = managerService.getUserByAccount(account);
        if (null != user) {
            if (user.getPassword().equals(password.trim())) {
                mav.setViewName("home");
                mav.addObject("account", user.getAccount());
            } else {
                mav.setViewName("login");
                mav.addObject("account", user.getAccount());
                mav.addObject("message", "username or password error!");
            }
        } else {
            mav.setViewName("login");
            mav.addObject("message", "User no exist!");
        }
        return mav;
    }

    /** 注册
     * @param request
     * @param account
     * @param password
     * @return
     * @throws Exception 
     * @create: 2013年12月5日 下午3:10:09 
     * @author: Yang Xiaodong
     * @history: 
     */
    @RequestMapping("/register.do")
    public ModelAndView register(@RequestParam(required = false) String account, String password,
            String password1) throws Exception {
        ModelAndView mav = new ModelAndView();
        int count = managerService.getUserCountByAccount(account);
        if (count > 0) {
            // 异常处理
            mav.setViewName("error");
            mav.addObject("ex", account + "  has be used");
            return mav;
        }
        if (!password.equals(password1)) {
            // 异常处理
            mav.setViewName("error");
            mav.addObject("ex", account + "  has be used");
            return mav;
        }
        managerService.addUser(account, password);
        mav.setViewName("home");
        mav.addObject("account", account);
        return mav;
    }

    /** 
     * 首页加载
     * @return
     * @throws Exception 
     * @create: 2014年4月15日 下午2:01:17 
     * @author: Yang Xiaodong
     * @history: 
     */
    @RequestMapping("/initHome.do")
    public ModelAndView initHome() throws Exception {
        ModelAndView mav = new ModelAndView();
        Resource rs = new Resource();
        rs.setIspublic(1);
        rs.setResourcetype(1);
        List<Resource> imageList = managerService.queryResourceOrderByTime(rs);
        rs.setResourcetype(2);
        List<Resource> videoList = managerService.queryResourceOrderByTime(rs);
        mav.addObject("imageList", imageList);
        mav.addObject("videoList", videoList);
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping("/praise.do")
    public ModelAndView praise(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Resource rs = new Resource();
        rs.setId(id);
        managerService.addResourcePraise(rs);
        mav.setViewName("redirect:/initHome.do");
        return mav;
    }
}
