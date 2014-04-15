package com.wawa.my.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wawa.basic.service.BasicService;
import com.wawa.my.bean.Diary;
import com.wawa.my.bean.Resource;

/**
 * @author Yang Xiaodong
 * 2013年12月3日 下午10:48:03
 */
@Service
public interface MyService extends BasicService {

    /** 
     * 获取用户图片路径集合
     * @param userId
     * @return 
     * @create: 2013年12月24日 下午3:13:11 
     * @author: Yang Xiaodong
     * @history: 
     */
    public List<Resource> getMyResource(int userId, int resourceType) throws Exception;

    /** 
     * 上传图片
     * @param userId
     * @param fileName
     * @throws Exception 
     * @create: 2013年12月24日 下午3:14:25 
     * @author: Yang Xiaodong
     * @history: 
     */
    public void saveResource(Resource resource) throws Exception;

    /** 
     * 获取用户日志
     * @param id
     * @return 
     * @create: 2014年1月9日 下午2:46:20 
     * @author: Yang Xiaodong
     * @history: 
     */
    public List<Diary> getMyDiary(int userId) throws Exception;
}
