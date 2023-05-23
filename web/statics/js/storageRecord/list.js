var StorageRecordObj;

//入库记录管理页面上点击删除按钮弹出删除框(StorageRecordlist.jsp)
function deleteStorageRecord(obj){
	$.ajax({
		type:"GET",
		url:path+"/jsp/storageRecord.do",
		data:{method:"deleteById",storageRecordId:obj.attr("storageRecordId")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除订单【"+obj.attr("StorageRecordcc")+"】失败");
				changeDLGContent("对不起，删除订单【"+obj.attr("storageRecordcc")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，订单【"+obj.attr("StorageRecordcc")+"】不存在");
				changeDLGContent("对不起，订单【"+obj.attr("storageRecordcc")+"】不存在");
			}
		},
		error:function(data){
			alert("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeBi').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeBi').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	$(".viewStorageRecord").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/jsp/storageRecord.do?method=view&storageRecordId="+ obj.attr("storageRecordId");
	});
	
	$(".modifyStorageRecord").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/jsp/storageRecord.do?method=toUpdate&storageRecordId="+ obj.attr("storageRecordId");
	});
	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteStorageRecord(StorageRecordObj);
	});

	$(".deleteStorageRecord").on("click",function(){
		StorageRecordObj = $(this);
		changeDLGContent("确定删除订单【"+StorageRecordObj.attr("storageRecordcc")+"】吗？");
		openYesOrNoDLG();
	});
	
	/*$(".deleteStorageRecord").on("click",function(){
		var obj = $(this);
		if(confirm("确定删除订单【"+obj.attr("StorageRecordcc")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/StorageRecord.do",
				data:{method:"delStorageRecord",StorageRecordid:obj.attr("StorageRecordid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除订单【"+obj.attr("StorageRecordcc")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，订单【"+obj.attr("StorageRecordcc")+"】不存在");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});*/
});