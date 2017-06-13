/**
 * @author hecm@asiainfo.com (Mia)
 * -------------------------------------------------------------------
 * @fileoverview
 * 功能名称 dailog弹出框
 * 
 */
;(function($) {
    /*
        @buttons 自定义按扭
             [{
                 text : '关闭',   //按钮文字
                 elCls : 'btn-primary',  //按钮样式
                 handler : function(){  //单击该按钮执行事件
           }]
        @bootstrapModalOption   默认的bootstrap模态对话框参数
         {
           backdrop:true, //指定一个静态的背景，当用户点击模态框外部时不会关闭模态框。
            show:true, //当按下 escape 键时关闭模态框，设置为 false 时则按键无效。
            keyboard:true, //当初始化时显示模态框。
         }
    */
    $.fn.mdialog = function(options) {
        var defaults = {
            width : '',  //宽度  例：500
            height : '',  //高度 例：300
            title : '标题', //标题
            content : '',  //主体内容
            contentId : '', //主体内容ID
            buttons : [], //自定义按钮
            hasButtons : true,
            bootstrapModalOption: {}, //默认的bootstrap模态对话框参数
            success:function () {}, //默认回调方法
            dialogShow: function() {}, //对话框即将显示事件
            dialogShown: function() {}, //对话框已经显示事件
            dialogHide: function() {}, //对话框即将关闭
            dialogHidden: function() {} ,//对话框已经关闭事件
            close:function(){    //关闭事件
                $('#' + modalID).modal('hide');
            }
        };
        var options = $.extend(defaults, options);
        var modalID = '';
        //生成一个惟一的ID
        function getModalID() {
            var d = new Date();
            var vYear = d.getFullYear();
            var vMon = d.getMonth() + 1;
            var vDay = d.getDate();
            var h = d.getHours();
            var m = d.getMinutes();
            var se = d.getSeconds();
            var sse = d.getMilliseconds();
            return 't_' + vYear + vMon + vDay + h + m + se + sse;
        }
        $.fn.extend({
            closeDialog: function(modal) {
                var modalObj = modal;
                modalObj.modal('hide');
            }
        });
        return this.each(function() {
            var obj = $(this);
            modalID = getModalID();
            $(this).attr("data-target", modalID);

            //自定弹窗宽高
            var dWidth,dHeight;
            if(options.width != ''){
                dWidth = options.width +'px';
            }else{
                dWidth = '600px' ;
            }
            if(options.height != ''){
                dHeight = options.height +'px';
            }else{
                dHeight = 'auto' ;
            }
            //自定义按钮
            var buttonHtml = '';
            if (options.buttons.length > 0) {
                var btnClass = 'cls-' + modalID;
                for (var i = 0; i < options.buttons.length; i++) {
                    // data-dismiss="modal"
                    buttonHtml += '<button type="button" buttonIndex="' + i + '" class="'+ btnClass +' btn ' + options.buttons[i].elCls+'">' + options.buttons[i].text +'</button>';
                }
            }
            //自定义主体内容
            var bodyHtml ='';
            bodyHtml = options.content;
            
            var tmpHtml = '<div class="modal fade dialogModal" id="{ID}"   tabindex="-1"  data-backdrop="static" role="dialog" aria-labelledby="myModalLabel_{ID}" aria-hidden="true">' +
                '<div class="modal-dialog " style="width:'+dWidth+'; height:'+dHeight+'">' +
                '<div class="modal-content" >' +
                '<div class="modal-header">' +
                '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
                '<h4 class="modal-title" id="myModalLabel_{ID}">{title}</h4>' +
                '</div>' +
                '<div class="modal-body" id="body_{ID}">{body}</div>' +
                '<div class="modal-footer">{button}</div></div></div></div>';
            if(!buttonHtml && options.hasButtons){
                buttonHtml = '<button type="button"  class="btn btn-success cls_success" >确定</button>' +
                    '<button type="button" class="btn btn-success btn-outline" data-dismiss="modal">取消</button>';
            }

            //替换模板标记
            tmpHtml = tmpHtml.replace(/{ID}/g, modalID).replace(/{title}/g, options.title).replace(/{body}/g, bodyHtml).replace(/{button}/g, buttonHtml);
			$(obj).append(tmpHtml);
			
			if(options.contentId != ''){
                bodyHtml = $('#' + options.contentId);
                bodyHtml.css('display', 'block');
                bodyHtml.after($('<span style="display:none" id="_tmp_' + modalID + '" ></span>'));
                $('#body_' + modalID).empty();
                $('#body_' + modalID).append(bodyHtml);
            }
			
            var modalObj = $('#' + modalID);
            //绑定按钮事件
            $('.cls_success').click(function() {
                if(options.success() !== false){
                    modalObj.modal('hide');
                }
            });

            $('.' + btnClass).click(function() {
                var index = $(this).attr('buttonIndex');
                if(options.buttons[index].handler() !== false){
                    modalObj.modal('hide');
                }
            });
            //绑定本身的事件
            modalObj.on('show.bs.modal', function() {
                options.dialogShow();
            });
            modalObj.on('shown.bs.modal', function() {
                options.dialogShown();
            });
            modalObj.on('hide.bs.modal', function() {
                options.dialogHide();
            });
            modalObj.on('hidden.bs.modal', function() {
                if(options.contentId != ''){
                    bodyHtml.css('display', 'none');
                    $('#_tmp_' + modalID).before(bodyHtml);
                    $('#_tmp_' + modalID).remove();
                }
                options.dialogHidden();
                obj.removeAttr("data-target");
                modalObj.remove();
            });
            modalObj.modal(options.bootstrapModalOption);
        });
    };
    $.extend({
        mdialog: function(options) {
            $("body").mdialog(options);
        }
    });
})(jQuery);