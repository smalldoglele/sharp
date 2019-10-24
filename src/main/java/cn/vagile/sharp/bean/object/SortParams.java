package cn.vagile.sharp.bean.object;

import lombok.Data;

@Data
public class SortParams {
    //排序列
    protected String sort;
    //排序方向 asc/desc
    protected String order;
}
