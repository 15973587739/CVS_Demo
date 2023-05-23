var account = null;
var birthday = null;
var phone = null;
var roleList = null;
var saveBtn = null;
var backBtn = null;

$(function(){
	account = $("#account");
	birthday = $("#birthday");
	phone = $("#phone");
	roleList = $("#roleList");
	saveBtn = $("#save");
	backBtn = $("#back");
	
	account.next().html("*");
	birthday.next().html("*");
	phone.next().html("*");
	roleList.next().html("*");
	
	
	$.ajax({
		type:"GET",//请求类型
		url:path+"/jsp/user.do",//请求的url
		data:{method:"getRoleList"},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data != null){
				var rid = $("#rid").val();
				roleList.html("");
				var options = "<option value=\"0\">请选择</option>";
				for(var i = 0; i < data.length; i++){
					//alert(data[i].id);
					//alert(data[i].roleName);
					if(rid != null && rid != undefined && data[i].id == rid ){
						options += "<option selected=\"selected\" value=\""+data[i].id+"\" >"+data[i].roleName+"</option>";
					}else{
						options += "<option value=\""+data[i].id+"\" >"+data[i].roleName+"</option>";
					}
					
				}
				roleList.html(options);
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			validateTip(roleList.next(),{"color":"red"},imgNo+" 获取角色列表error",false);
		}
	});
	
	
	account.on("focus",function(){
		validateTip(account.next(),{"color":"#666666"},"* 用户名长度必须是大于1小于10的字符",false);
	}).on("blur",function(){
		if(account.val() != null && account.val().length > 1
				&& account.val().length < 10){
			validateTip(account.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(account.next(),{"color":"red"},imgNo+" 用户名输入的不符合规范，请重新输入",false);
		}
		
	});
	
	birthday.on("focus",function(){
		validateTip(birthday.next(),{"color":"#666666"},"* 点击输入框，选择日期",false);
	}).on("blur",function(){
		if(birthday.val() != null && birthday.val() != ""){
			validateTip(birthday.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(birthday.next(),{"color":"red"},imgNo + " 选择的日期不正确,请重新输入",false);
		}
	});
	
	phone.on("focus",function(){
		validateTip(phone.next(),{"color":"#666666"},"* 请输入手机号",false);
	}).on("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(phone.val().match(patrn)){
			validateTip(phone.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(phone.next(),{"color":"red"},imgNo + " 您输入的手机号格式不正确",false);
		}
	});
	
	roleList.on("focus",function(){
		validateTip(roleList.next(),{"color":"#666666"},"* 请选择角色",false);
	}).on("blur",function(){
		if(roleList.val() != null && roleList.val() > 0){
			validateTip(roleList.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(roleList.next(),{"color":"red"},imgNo+" 请重新选择角色",false);
		}
		
	});
	
	saveBtn.on("click",function(){
		account.blur();
		phone.blur();
		birthday.blur();
		roleList.blur();
		if(account.attr("validateStatus") == "true" 
			&& phone.attr("validateStatus") == "true"
			&& birthday.attr("validateStatus") == "true"
			&& roleList.attr("validateStatus") == "true"){
			if(confirm("是否确认要提交数据？")){
				$("#userForm").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		//alert("modify: "+referer);
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
});