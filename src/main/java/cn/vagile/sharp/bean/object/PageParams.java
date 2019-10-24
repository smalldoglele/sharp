package cn.vagile.sharp.bean.object;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

@Data
public class PageParams extends SortParams {
    private Integer pageNumber = 1;
    private Integer pageSize = 20;

    /**
     * 获得分佣和排序参数
     *
     * @param <E>
     * @return
     */
    public <E> IPage<E> getPage() {
        Page<E> page = new Page<>(this.pageNumber, this.pageSize);
        if (StringUtils.isNotBlank(this.sort)) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn(sort);
            if (StringUtils.isNotBlank(order)) {
                orderItem.setAsc("asc".equalsIgnoreCase(order));
            }
            ArrayList<OrderItem> orderItems = new ArrayList<>(1);
            page.setOrders(orderItems);
        }
        return page;
    }
}
