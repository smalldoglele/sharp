package cn.vagile.sharp.controller;


import cn.vagile.sharp.bean.entity.User;
import cn.vagile.sharp.bean.object.ResultEntity;
import cn.vagile.sharp.bean.params.UserPageParams;
import cn.vagile.sharp.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @GetMapping("list")
    public ResultEntity<IPage<User>> list(UserPageParams pageParams) {
        IPage<User> page = userService.selectPage(pageParams);
        return ResultEntity.ok(page);
    }

    @GetMapping("edit")
    public String edit(Long id, Model model) {
        User user;
        if (id != null) {
            user = userService.getById(id);
        } else {
            user = new User();
        }
        model.addAttribute("user", user);
        return "user/edit";
    }

    @ResponseBody
    @PostMapping("saveOrUpdate")
    public ResultEntity saveOrUpdate(User user) {
        user.setCreateBy(1l);
        user.setUpdateBy(1l);
        userService.saveOrUpdate(user);
        return ResultEntity.ok().build();
    }

    @ResponseBody
    @RequestMapping("del")
    public ResultEntity del(Long id) {
        try {
            userService.removeById(id);
            return ResultEntity.ok().build();
        } catch (Exception e) {
            log.error("用户删除失败:", e);
            return ResultEntity.bad(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("userNameUnique")
    public boolean userNameUnique(String userName, Long selfId) {
        User user = userService.getUserByUserNameAndNotSelf(userName, selfId);
        return user == null;
    }

}

