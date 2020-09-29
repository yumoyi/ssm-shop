/**
 * 函数对象
 * @constructor
 */
var Validate = function () {
    /**
     * 初始化 jQuery validation
     */
    var handlerInitValidate = function () {
        //出错后:字体变红和增加提醒栏
        $("#inputForm").validate({
            errorElement: 'span',
            errorClass: 'help-block',

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });
        
    }
    /**
     * 增加自定义验证规则
     */
    var handlerInitCustomValidate = function () {
        $.validator.addMethod("mobile", function(value, element) {
            var length = value.length;
            var mobile =  /^((13[0-9])|(15[^4,\D])|(18[0,5-9]))\d{8}$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");
    };

    return{
        init:function(){
            handlerInitValidate();
            handlerInitCustomValidate();
        }

    }
}();

$(document).ready(function () {
   Validate.init();
});