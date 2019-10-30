$('#form').validate({
    errorElement: 'div',
    errorClass: 'help-block',
    focusInvalid: false,
    ignore: "",
    debug: true,
    rules: {},

    messages: {},


    highlight: function (e) {
        $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
    },

    success: function (e) {
        $(e).closest('.form-group').removeClass('has-error');
        $(e).remove();
    },

    errorPlacement: function (error, element) {
        if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
            var controls = element.closest('div[class*="col-"]');
            if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
            else error.insertAfter(element.parent().parent());
        } else if (element.is('.select2')) {
            error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
        } else if (element.is('.chosen-select')) {
            error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
        } else error.insertAfter(element.parent());
    },
    submitHandler: function (form) {
        $(form).ajaxSubmit({
            success: function(data) {
                if(data.status){
                    layer.alert("保存成功",function(){
                       parent.layer.closeAll();
                       parent.reLoad();
                    });
                }
            }
        });
    }
});
$('.date-picker').datepicker({
    language:  'zh-CN',
    autoclose: true,
    todayHighlight: true,
    orientation:'auto'
}).next().on(ace.click_event, function () {
    $(this).prev().focus();
});

