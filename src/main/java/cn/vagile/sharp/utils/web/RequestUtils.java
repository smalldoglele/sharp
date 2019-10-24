package cn.vagile.sharp.utils.web;


import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


public class RequestUtils {
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
     * 获取int参数
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public int getParamToInt(String key, int defaultValue) {
        String parameter = getRequest().getParameter(key);
        if (StringUtils.isBlank(parameter)) {
            return defaultValue;
        }
        return Integer.parseInt(parameter);
    }

    /**
     * <pre>
     * 自动获取分页参数，返回分页对象page
     * </pre>
     *
     * <small> 2018年4月15日 | Aron</small>
     *
     * @param e
     * @return
     */
    public <E> Page<E> getPage(Class<E> e) {
        int pageNumber = getParamToInt("pageNumber", 1);
        int pageSize = getParamToInt("pageSize", 10);
        Page<E> page = new Page<>(pageNumber, pageSize);
        //支持sort/order参数
        HttpServletRequest request = getRequest();
        String sort = request.getParameter("sort");
        if (StringUtils.isNotBlank(sort)) {
            String order = request.getParameter("order");
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn(order);
            boolean asc = false;
            if (StringUtils.isNotBlank(order)) {
                asc = "asc".equalsIgnoreCase(order);
            }
            orderItem.setAsc(asc);
            ArrayList<OrderItem> orderItems = new ArrayList<>(1);
            page.setOrders(orderItems);
        }
        return page;
    }

}
