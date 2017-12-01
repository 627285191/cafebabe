package com.cafebabe.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * 基础拦截器
 * @author navia
 *
 */
@Component
public class UtilInterceptor extends HandlerInterceptorAdapter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final SimpleDateFormat SDF = new SimpleDateFormat("yyyy年M月d日 E");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) throws Exception {
		String path = request.getContextPath();
		String base = request.getScheme() +
				"://" + request.getServerName() +
				":" + request.getServerPort() +
				path + "/";
    	request.setAttribute("basePath", base);
    	request.setAttribute("basePathEncoded", URLEncoder.encode(base, "UTF-8"));
    	request.setAttribute("serverTime", SDF.format(Calendar.getInstance().getTime()));
		return true;
	}
}
