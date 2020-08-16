package com.linging.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器
public class HandlerInterceptorDemo implements HandlerInterceptor {

    /**
     * 在到达controller之前执行
     * @param request
     * @param response
     * @param handler
     * @return true: 放行  false：拒绝访问
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle.....前");
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return true;
    }

    /**
     * 在业务处理器处理完请求后，但是 DispatcherServlet 向客户端返回响应前被调用，
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle.....后");
        //此方法在控制器执行后，还没有进行视图跳转之前执行，所以在这里跳转后，就不会跳转控制器中的视图了。
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }

    /**
     * 在 DispatcherServlet 完全处理完请求后被调用，即向客户端响应后执行，可以做一些资源释放工作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion....最后");
        //这个方法已经响应结果给客户端了，如果再跳转就会报错。
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }
}