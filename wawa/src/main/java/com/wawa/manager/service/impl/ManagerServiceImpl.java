package com.wawa.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wawa.basic.service.impl.BasicServiceImpl;
import com.wawa.manager.bean.User;
import com.wawa.manager.dao.ManagerDao;
import com.wawa.manager.service.ManagerService;
import com.wawa.my.bean.Resource;

/**
 * @author: Yang Xiaodong
 * @since: 2013年7月29日 下午5:45:04
 * @history:
 */
public class ManagerServiceImpl extends BasicServiceImpl implements
		ManagerService {
	@Autowired
	private ManagerDao managerDao;

	public void addUser(String account, String password) throws Exception {
		String sql = "insert into t_user (account, password,createtime) values (:account,:password,now())";
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		managerDao.updateObject(sql, user);
	}

	public int getUserCountByAccount(String account) throws Exception {
		String sql = "select count(1) from  t_user where account=:account ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", account);
		int count = managerDao.getCount(sql, map);
		return count;
	}

	public User getUserByAccount(String account) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String sql = "select * from t_user where account =:account or email =:email or mobile =:mobile or qq =:qq ";
		paramMap.put("account", account);
		paramMap.put("email", account);
		paramMap.put("mobile", account);
		paramMap.put("qq", account);
		List<User> users = managerDao.getObjectList(sql, paramMap, User.class);
		if (users.size() != 1) {
			return null;
		} else {

		}
		return users.get(0);
	}

    public List<Resource> queryResourceOrderByTime(Resource rs) throws Exception {
        String sql = "select * from  t_resource where resourcetype=:resourcetype and ispublic=:ispublic and resourcest = 1 order by createtime desc limit 0,12";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ispublic", rs.getIspublic());
        paramMap.put("resourcetype", rs.getResourcetype());
        List<Resource> listResource = managerDao.getObjectList(sql, paramMap, Resource.class);
        return listResource;
    }

    /** 
     * @throws Exception 
     * @see com.wawa.manager.service.ManagerService#resourcePraise(java.lang.Integer)
     */
    public void addResourcePraise(Resource rs) throws Exception {
       String sql =  "update t_resource set praise =(select prs from (select praise+1 as prs from t_resource where id=:id) t1 )  where id=:id";
       managerDao.updateObject(sql, rs);
    }
}
