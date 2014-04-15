package com.wawa.my.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wawa.basic.action.BasicAction;
import com.wawa.manager.bean.User;
import com.wawa.my.bean.Diary;
import com.wawa.my.service.MyService;

/** 
 * 日记
 * @author: Yang Xiaodong
 * @since: 2014年1月9日 下午2:06:43 
 * @history:
 */
@Controller
public class DiaryAction extends BasicAction {

    @Autowired
    private MyService myService;

    @RequestMapping("/initMyDiary.do")
    public ModelAndView initMyDiary() throws Exception {
        User user = this.getUser();
        ModelAndView mav = new ModelAndView();
        List<Diary> diaryList = myService.getMyDiary(user.getId());
        mav.addObject("diaries", diaryList);
        mav.setViewName("myDiary");
        return mav;
    }

    @RequestMapping("/addMyDiary.do")
    public ModelAndView uploadMyDiary(@RequestParam(required = false) String desc,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unused")
		User user = this.getUser();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/initMyDiary.do");
        return mav;
    }
}
