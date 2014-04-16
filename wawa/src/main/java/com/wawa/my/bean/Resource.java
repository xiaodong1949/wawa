package com.wawa.my.bean;

import java.sql.Date;

import com.wawa.basic.bean.BasicBean;

public class Resource extends BasicBean {
    /** 
     * @Fields serialVersionUID  
     */
    private static final long serialVersionUID = 3900378527331598314L;

    private int userid;

    private String resourcename;

    private int resourcetype;

    private Date createtime;

    private String description;
    
    private int praise;
    
    private int ispublic;
    
    private int resourcest;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public int getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(int resourcetype) {
        this.resourcetype = resourcetype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getIspublic() {
        return ispublic;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    public int getResourcest() {
        return resourcest;
    }

    public void setResourcest(int resourcest) {
        this.resourcest = resourcest;
    }

}
