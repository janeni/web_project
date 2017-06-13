/**
 * @author luoc@asiainfo.com 
 * -------------------------------------------------------------------
 * @DatePicker
 * 功能名称 日期控件
 *@params type 默认为当天日期如：2014-1-16（不传）{type：1}当前绝对时间如（年月日时分秒）{type:2}当前小时时间（时分秒）
 * 
 */

var Web = Web || {};
Web.DatePicker = function(el,param){
	var tmp = undefined;
	var type = undefined;
	var dateParams = {};
	if(param && param.type ){
		type = param.type;
	}
	tmp = WdatePicker;
	switch(type){
		case 1:
			dateParams = {dateFmt:"yyyy-MM-dd HH:mm:ss"};
		break;
		case 2:
			dateParams = {dateFmt:"HH:mm:ss"};
		break;
		default:
		break;
	}
	$(el).bind('click',function(){
		tmp(dateParams);
	});
};

