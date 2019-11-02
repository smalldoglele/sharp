/**
 *jquery.switch.js插件
 * 对ace On/Off Switch的封装
 * <label class="control-label">
 *  <input class="ace ace-switch ace-switch-7" id="valid" name="valid" type="checkbox"  checked="true"/>
 *  <span class="lbl"></span>
 * </label>
 * switch 配置项:
 * - id input的id
 * - name 表单的id
 * - checked 表单的状态
 *
 * 样例：
 * <pre>
 *   <label class="control-label jquery-switch" data-id="that-id" data-name="that-name"></label>
 *   js:
 *   $(".jquery-switch").switch();
 * </pre>
 *
 *  @author walden
 */
(function ($) {
    /**
     * 辅助字符串方法
     * @param args
     * @returns {String}
     */
    String.prototype.format = function (args) {
        var result = this;
        if (arguments.length > 0) {
            if (arguments.length == 1 && typeof (args) == "object") {
                for (var key in args) {
                    if (args[key] != undefined) {
                        var reg = new RegExp("({" + key + "})", "g");
                        result = result.replace(reg, args[key]);
                    }
                }
            } else {
                for (var i = 0; i < arguments.length; i++) {
                    if (arguments[i] != undefined) {
                        var reg = new RegExp("({)" + i + "(})", "g");
                        result = result.replace(reg, arguments[i]);
                    }
                }
            }
        }
        return result;
    }

    $.fn.switch = function (options) {
        return this.each(function () {
            var $this = $(this);
            var opts = $.extend({}, $.fn.switch.defaults, options, $this.data());
            $this.append(opts.hiddenHtml.format(opts))
                .append(opts.checkHtml.format(opts.id ? opts.id : "_" + opts.name, "_" + opts.name, opts.checked?"checked":""))
                .append(opts.spanHtml);
            $this.on("click", ":checkbox", function () {
                $(this).prev().val($(this).prop("checked"));
            });
        });
    };

    $.fn.switch.defaults = {
        hiddenHtml: '<input type="hidden" name="{name}" value="{checked}">',
        checkHtml: '<input class="ace ace-switch ace-switch-7" id="{0}" name="{1}" type="checkbox" {2}/>',
        spanHtml: '<span class="lbl"></span>',
        checked:true
    }
    if($("label.jquery-switch").length){
        $("label.jquery-switch").switch();
    }
})(jQuery);