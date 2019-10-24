package cn.vagile.sharp.service;

import cn.vagile.sharp.bean.entity.User;
import cn.vagile.sharp.bean.params.UserPageParams;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author walden
 * @since 2019-10-17
 */
public interface IUserService extends IService<User> {

    IPage<User> selectPage(UserPageParams pageParams);
}
