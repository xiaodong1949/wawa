package com.wawa.basic.helper;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;


/**
 * @author Yang Xiaodong
 * 2013年12月3日 下午11:47:36
 */
public class MessageSourceHelper {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    public String getMessage(String code, Object[] args) {
        String msg = messageSource.getMessage(code, args, new Locale("zh"));
        return msg != null ? msg.trim() : msg;
    }

    public void setMessageSource(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
