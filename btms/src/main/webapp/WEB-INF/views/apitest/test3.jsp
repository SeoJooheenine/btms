<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$(function(){
		$("#checkJson").click(function(){
			var article = {
					articleNO:"114"
					,writer:"박지성"
					,title:"안녕1!~!!"
					,content:"상품소개글!!"
			};
			$.ajax({
				/*
				type:"POST"
				,url:"${contextPath}/btms/apitest/boards"
				*/
				type:"PUT"
				,url:"${contextPath}/btms/apitest/boards/114"
				,contentType:"application/json"
				,data:JSON.stringify(article)
				,success:function(data,textStatus){
					alert(data);
				}
				,error:function(data,textStatus){
					alert("에러발생!!");
				}
				,complete:function(data,textStatus){
				}
			});
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson" value="새 글 쓰기"/></br>
	<div id="output"></div>
</body>
</html>