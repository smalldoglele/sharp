package cn.vagile.sharp.controller;


import cn.vagile.sharp.bean.entity.User;
import cn.vagile.sharp.bean.object.ResultEntity;
import cn.vagile.sharp.bean.params.UserPageParams;
import cn.vagile.sharp.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author walden
 * @since 2019-10-17
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("list")
    @ResponseBody
    public ResultEntity<IPage<User>> list(UserPageParams pageParams) {
        IPage<User> page = userService.selectPage(pageParams);
        return ResultEntity.ok(page);
    }
}

