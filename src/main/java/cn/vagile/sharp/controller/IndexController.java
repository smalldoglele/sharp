package cn.vagile.sharp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("index.html")
    public String index() {
        return "index";
    }

    /**
     * 空白页
     *
     * @return
     */
    @RequestMapping("blank.html")
    public String blank() {
        return "blank";
    }


    /**
     * 通用导航
     *
     * @return
     */
    @RequestMapping("{page}.html")
    public String page(@PathVariable("page") String page) {
        return page;
    }

    /**
     * 带目录的通用导航
     *
     * @return
     */
    @RequestMapping("{dir}/{page}.html")
    public String dirAndPage(@PathVariable("dir") String dir, @PathVariable("page") String page) {
        return String.format("%s/%s", dir, page);
    }
}
