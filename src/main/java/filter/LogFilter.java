package filter;

import util.MDCIdUtil;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName: LogFilter
 * @Description:
 * @Author: ice
 * @Date: 2023/7/4 18:13
 *
 * Filter添加依赖
 *      <dependency>
 *             <groupId>javax.servlet</groupId>
 *             <artifactId>servlet-api</artifactId>
 *             <version>2.3</version>
 *         </dependency>
 */
public class LogFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //生成trace id放入MDC中
        MDCIdUtil.putIfAbsent();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            //移除MDC中的trace id
            MDCIdUtil.remove();
        }
    }

    public void destroy() {

    }
}
