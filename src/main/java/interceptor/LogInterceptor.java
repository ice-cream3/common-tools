package interceptor;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import util.MDCIdUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LogInterceptor
 * @Description:
 * @Author: ice
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果有上层调用就用上层的ID
        String traceId = request.getHeader(MDCIdUtil.CID);
        if (traceId == null) {
            MDCIdUtil.putIfAbsent();
            traceId = MDCIdUtil.get();
        }

        MDC.put(MDCIdUtil.CID, traceId);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //调用结束后删除
        MDC.remove(MDCIdUtil.CID);
    }
}
