package com.wawa.my.bean;

import java.sql.Date;

import com.wawa.basic.bean.BasicBean;

/** 
 * @author: Yang Xiaodong
 * @since: 2014年1月9日 下午2:43:08 
 * @history:
 */
public class Diary extends BasicBean {

    /** 
     * @Fields serialVersionUID  
     */
    private static final long serialVersionUID = -1038015077414585939L;

    private int userid;

    private String title;

    private String tag;

    private String content;

    private Date createtime;

    private int open;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

}
