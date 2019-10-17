package cn.vagile.sharp.bean.core;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 是否删除
     */
    private Boolean deleted;

}
