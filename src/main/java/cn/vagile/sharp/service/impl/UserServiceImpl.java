package cn.vagile.sharp.service.impl;

import cn.vagile.sharp.bean.entity.User;
import cn.vagile.sharp.bean.params.UserPageParams;
import cn.vagile.sharp.mapper.UserMapper;
import cn.vagile.sharp.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author walden
 * @since 2019-10-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public IPage<User> selectPage(UserPageParams params) {
        IPage<User> page = params.getPage();
        LambdaQueryWrapper wrapper = new QueryWrapper().lambda();
        wrapper.like(StringUtils.isNotEmpty(params.getName()), "userName", params.getName());
        return this.page(page, wrapper);
    }
}
