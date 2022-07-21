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
			var member = {
					id:"park"
					,name:"박지성"
					,pwd:"1234"
					,email:"park@test.com"
			};
			$.ajax({
				type:"post"
				,url:"${contextPath}/test/info"
				,contentType:"application/json"
				,data:JSON.stringify(member)
				,success:function(data,textStatus){
				}
				,error:function(data,textStatus,error){
					alert("에러발생!!");
					console.log(error);
				}
				,complete:function(data,textStatus){
				}
			});
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson" value="회원정보 보내기"/></br>
	<div id="output"></div>
</body>
</html>