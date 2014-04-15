package com.wawa.basic.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.wawa.manager.bean.User;

/**
 * @author Yang Xiaodong
 * 2013年12月3日 下午10:09:40
 * 系统父类
 */
@Controller
public class BasicAction {
    public Log logger = LogFactory.getLog(this.getClass());

    public User getUser() {
        User user = new User();
        user.setId(1);
        return user;
    }

    @InitBinder
    protected void ininBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
