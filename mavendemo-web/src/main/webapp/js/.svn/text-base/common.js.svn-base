/**
 * 是否为空
 * 
 */
function isEmpty(str){
	if(/^[\s]{0,}$/.test(str)){
		return true;
	}else if(null == str){
		return true;
	}else if(typeof(str) == 'undefined')
	{
		return true;
	}
	return false;
}
/**
 * 不为空
 */
function notEmpty(str){
	return !isEmpty(str);
}
/**
 * 去除首位空格空格
 */ 
function trim(s) {
    return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
}


/**
 * 邮政编码
 * @param str
 * @returns
 */
function isZipCode(str)
{
	
	var reg = /^[1-9][0-9]{5}$/;
	return reg.test(str);
}

/**
 * 手机号码
 * @param str
 * @returns
 */
function isMobile(str)
{
	
//	var reg = /^1[3|4|5|8][0-9]\d{4,8}$/ ;
	var reg = /1[3-9][0-9]\d{8}$/;
	return reg.test(str);
}

/**
 * 是否是数字
 * @param str
 * @returns
 */
function isNumber(str)
{
	var reg = new RegExp("^\\+?[0-9][0-9]*$");
	return reg.test(str);
}

/**
 * 判断输入的字符数
 */
function getLength(str) {
	var t = 0;
	for ( var i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) > 255) {
			t += 2;
		} else {
			t++;
		}
	}
	return t;
}

/**
 * 获取浮点数.00精度
 */
function getFloatStr(num){
	num += '';
    num = num.replace(/[^0-9|\.]/g, ''); //清除字符串中的非数字非.字符
    
    if(/^0+/) //清除字符串开头的0
        num = num.replace(/^0+/, '');
    if(!/\./.test(num)) //为整数字符串在末尾添加.00
        num += '.00';
    if(/^\./.test(num)) //字符以.开头时,在开头添加0
        num = '0' + num;
    num += '00';        //在字符串末尾补零
    num = num.match(/\d+\.\d{2}/)[0];
    return num;
}


/**
 * 清空form表单
 */
function clearForm(form) {
	  // iterate over all of the inputs for the form
	  // element that was passed in
	  $(':input', form).each(function() {
	    var type = this.type;
	    var tag = this.tagName.toLowerCase(); // normalize case
	    // it's ok to reset the value attr of text inputs,
	    // password inputs, and textareas
	    if (type == 'text' || type == 'password' || tag == 'textarea')
	      this.value = "";
	    // checkboxes and radios need to have their checked state cleared
	    // but should *not* have their 'value' changed
	    else if (type == 'checkbox' || type == 'radio')
	      this.checked = false;
	    // select elements need to have their 'selectedIndex' property set to -1
	    // (this works for both single and multiple select elements)aaaa
	    else if (tag == 'select')
	      this.selectedIndex = -1;
	  });
	};

	
	/**
	 * 清空表单2
	 */
	function clearForm2(form_id){
		$("#"+form_id).find(':input').not(':button, :submit, :reset').val('')
		.removeAttr('checked').removeAttr('selected');
	}
	  
	
	function aaaa(){
		alert("11111");
	}
	
	/**
	 * 用jsonObject加载表单数据
	 * @param jsonStr
	 */
	function loadData(obj,formid){
	    //var obj = eval("("+jsonStr+")");
	    var key,value,tagName,type,arr;
	    for(x in obj){
	        key = x;
	        value = obj[x];
	         
	        $("#"+formid+" [name='"+key+"'],#"+formid+" [name='"+key+"[]']").each(function(){
	            tagName = $(this)[0].tagName;
	            type = $(this).attr('type');
	            if(tagName=='INPUT'){
	                if(type=='radio'){
	                    $(this).attr('checked',$(this).val()==value);
	                }else if(type=='checkbox'){
	                    arr = value.split(',');
	                    for(var i =0;i<arr.length;i++){
	                        if($(this).val()==arr[i]){
	                            $(this).attr('checked',true);
	                            break;
	                        }
	                    }
	                }else{
	                    $(this).val(value);
	                }
	            }else if(tagName=='SELECT' || tagName=='TEXTAREA'){
	                $(this).val(value);
	            }
	             
	        });
	    }
	}
	
	/**
	 * 判断是否登录
	 */
	
	/*function checkLogin(){
		if(isEmpty(localStorage.getItem("wuserid_"+pid))){
			$.msgAlert(' ','请登录之后继续操作！',function(data){
				location.href = path+'/site/mlogin/pid/'+pid;
			})
		}
		else{
			return true;
		}
	}*/
	
	utils = {
		    setParam : function (name,value){
		        localStorage.setItem(name,value)
		    },
		    getParam : function(name){
		        return localStorage.getItem(name)
		    }
		}
	
	