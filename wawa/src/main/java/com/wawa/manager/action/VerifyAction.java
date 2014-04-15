package com.wawa.manager.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wawa.basic.action.BasicAction;
import com.wawa.manager.service.ManagerService;

/** 
 * 表单校验类
 * @author: Yang Xiaodong
 * @since: 2013年12月13日 下午3:18:00 
 * @history:
 */
public class VerifyAction extends BasicAction {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/accountVerify.do")
    public void accoountVerify(HttpServletResponse response, @RequestParam(required = false) String account)
            throws Exception {
        String message = "success";
        if (null == account || account.isEmpty()) {
            message = "account is null";
        }
        int accCount = managerService.getUserCountByAccount(account);
        if (accCount > 0) {
            message = "account is used";
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(message);
        writer.flush();
    }
}
