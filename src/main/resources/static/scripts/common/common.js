/*!
 * 可以移植到其他项目中的通用代码
 */
/**
 * 如果有jquery存在
 *  将form序列化Json对象
 * {key1:"value1",key2:"value2"}
 * @example
 * <script>
 * var formParams = $("#formId").serializeObject();
 * </script>
 */
if (jQuery || $) {
    $.fn.serializeObject = function () {
        var a, o, h, i, e;
        a = this.serializeArray();
        o = {};
        h = o.hasOwnProperty;
        for (i = 0; i < a.length; i++) {
            e = a[i];
            if (!h.call(o, e.name)) {
                o[e.name] = e.value;
            }
        }
        return o;
    };
}