package com.wawa.basic.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 系统拦截器
 * @author yxd
 *
 */
public class BasicInterceptor extends HandlerInterceptorAdapter {
	private Log log = LogFactory.getLog(BasicInterceptor.class);
	/**
	 * 最后执行，可用于释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * 显示视图前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		log.debug(request.getContentType()+"-----"+request.getCharacterEncoding()+"------"+request.getContextPath());
		log.debug("MyInterceptor.postHandle()---viewName:"+modelAndView.getViewName());
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * Controller之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String url = request.getRequestURI();
		
		log.debug("MyInterceptor.preHandle()"+url);
		
		return super.preHandle(request, response, handler);
	}
}
