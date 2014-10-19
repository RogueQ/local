package com.rogue.frame.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**  
 *   
 * 类名称：HttpSessionFilter  
 * 类描述：过滤器(Filter)位于客户端和web应用程序之间，用于检查和修改两者之间流过的请求和响应。
 * 		在请求到达Servlet/JSP之前，过滤器截获请求。 在响应送给客户端之前，过滤器截获响应。  
 * 		多个过滤器形成一个过滤器链，过滤器链中不同过滤器的先后顺序由部署文件web.xml中过滤器映射<filter-mapping>的顺序决定。 
 * 		最先截获客户端请求的过滤器将最后截获Servlet/JSP的响应信息。
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月17日 下午8:07:26  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */

public class HttpSessionFilter implements Filter {
	ServletContext application = null;
	WebApplicationContext wac = null;
	
	
	/* (non-Javadoc)  
	 * @see javax.servlet.Filter#destroy()  
	 */
	@Override
	public void destroy() {
		
	}//destroy

	
	/* (non-Javadoc)  
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)  
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)res;
		String request_uri = request.getRequestURI();
		System.out.println("检测到请求地址：" + request_uri + "  来源于过滤器：HttpSessionFilter");
		filterChain.doFilter(request, response);
	}//doFilter

	
	/* (non-Javadoc)  
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)  
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		application = config.getServletContext();
		wac = WebApplicationContextUtils.getWebApplicationContext(application);//获取spring的context
	}
}
