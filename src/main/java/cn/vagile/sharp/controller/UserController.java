package cn.vagile.sharp.controller;


import cn.vagile.sharp.bean.entity.User;
import cn.vagile.sharp.bean.object.ResultEntity;
import cn.vagile.sharp.bean.params.UserPageParams;
import cn.vagile.sharp.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author walden
 * @since 2019-10-17
 */
@Controller
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

    @GetMapping("edit")
    public String edit(Long id, Model model) {
        if (id != null) {
            User user = userService.getById(id);
            model.addAttribute("user", user);
        }
        return "user/edit";
    }

    @PostMapping("saveOrUpdate")
    @ResponseBody
    public ResultEntity saveOrUpdate(User user) {
        userService.saveOrUpdate(user);
        return ResultEntity.ok().build();
    }
}

