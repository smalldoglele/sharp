package cn.vagile.sharp.utils.web;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SessionUtils {
    /**
     * 获得请求
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }


    /**
     * 获取会话
     *
     * @return
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取管理员后台session容器
     *
     * @return
     */
    //todo

    /**
     * 获取客户端前台session容器
     *
     * @return
     */
    //todo

    /**
     * 从session获取管理员
     *
     * @return
     */
    //todo

    /**
     * 从session获取客户信息
     *
     * @return
     */
    //todo
}
