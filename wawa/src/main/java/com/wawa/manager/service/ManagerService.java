package com.wawa.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wawa.basic.service.BasicService;
import com.wawa.manager.bean.User;
import com.wawa.my.bean.Resource;

/**
 * @author Yang Xiaodong
 * 2013年12月3日 下午10:48:03
 */
@Service
public interface ManagerService extends BasicService {

    /** 
     * 添加用户
     * @param account
     * @param password 
     * @create: 2013年12月5日 下午3:18:16 
     * @author: Yang Xiaodong
     * @history: 
     */
    public void addUser(String account, String password) throws Exception;

    /** 
     * 更具帐号获取用户数
     * @param account
     * @return 
     * @create: 2013年12月5日 下午3:18:23 
     * @author: Yang Xiaodong
     * @history: 
     */
    public int getUserCountByAccount(String account) throws Exception;

	/**
	 * 根据用户帐号获取用户信息
	 * @param account
	 * @return
	 */
	public User getUserByAccount(String account)throws Exception;

    /** 
     * 根据时间倒序查询图片/视频
     * @param rs
     * @return
     * @throws Exception 
     * @create: 2014年4月15日 下午2:08:53 
     * @author: Yang Xiaodong
     * @history: 
     */
    public List<Resource> queryResourceOrderByTime(Resource rs)throws Exception;

    /** 图片/视频点赞
     * @param id 
     * @create: 2014年4月15日 下午2:31:08 
     * @author: Yang Xiaodong
     * @history: 
     */
    public void addResourcePraise(Resource rs)  throws Exception;

}
