/**
 * 项目相关的不可以移植到其他项目中的通用代码
 */
$(function(){
    //根据breadcrumbs三级页面内容定位焦点
    var leafPage=$("#breadcrumbs").find("li.active");
    if(leafPage.length) {
        $("#nav-list").find("li:contains(" + leafPage.text() + ")").addClass("active").parent().parent().addClass("active open");
    }
});
