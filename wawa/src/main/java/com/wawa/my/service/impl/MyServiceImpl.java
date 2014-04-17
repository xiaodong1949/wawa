package com.wawa.my.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wawa.basic.service.impl.BasicServiceImpl;
import com.wawa.my.bean.Diary;
import com.wawa.my.bean.Resource;
import com.wawa.my.dao.MyDao;
import com.wawa.my.service.MyService;

/**
 * @author: Yang Xiaodong
 * @since: 2013年7月29日 下午5:45:04
 * @history:
 */
public class MyServiceImpl extends BasicServiceImpl implements MyService {
	@Autowired
	private MyDao myDao;

	public List<Resource> getMyResource(int userId, int resourceType)
			throws Exception {
		String sql = "select * from  t_resource where userid=:userid and resourcetype=:resourcetype and resourcest = 1 order by createtime desc";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userId);
		paramMap.put("resourcetype", resourceType);
		List<Resource> listResource = myDao.getObjectList(sql, paramMap,
				Resource.class);
		return listResource;
	}

	public void saveResource(Resource resource) throws Exception {
		String sql = "insert into t_resource (userid, resourcename,resourcetype,ispublic,description,createtime) values (:userid,:resourcename,:resourcetype,:ispublic,:description,now())";
		myDao.updateObject(sql, resource);
	}

	public List<Diary> getMyDiary(int userId) throws Exception {
		String sql = "select * from  t_diary where userid=:userid order by createtime asc ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userId);
		List<Diary> listDiary = myDao.getObjectList(sql, paramMap, Diary.class);
		return listDiary;
	}

	public void delResource(Resource rs) throws Exception {
		String sql = "update t_resource set resourcest =0 where id=:id and userid=:userid ";
		myDao.updateObject(sql, rs);
	}
}
