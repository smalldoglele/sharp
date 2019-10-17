package cn.vagile.sharp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import cn.vagile.sharp.bean.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author walden
 * @since 2019-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
public class User extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 是否禁用
     */
    private Boolean blocked;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实姓名
     */
    private String trueName;

    /**
     * 盐
     */
    private String salt;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别 0-未知;1-男;2-女
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private LocalDateTime birthDate;


}