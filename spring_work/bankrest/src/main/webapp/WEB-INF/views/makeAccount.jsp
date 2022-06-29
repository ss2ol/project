<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0 auto;
	width: 330px;
}

.container {
	padding: 10px;
	border: 1px solid;
}

.header {
	height: 40px;
}

.row {
	height: 30px;
}

.title {
	width: 70px;
	float: left;
	font-weight: bold;
}

.input {
	float: left;
}

input[type='submit'] {
	font-weight: bold;
	width: 120px;
	background-color: lightgrey;
}
</style>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>

$(function(){
	$("#submit").click(function(){
		alert($("#form").serialize());
		/*var id =$("#id").val();
		var name =$("#name").val();
		var balance =$("#balance").val();*/
	
		$.ajax({
			type:"POST",
			url:"/makeAccount",
		//	contentType:"text/html; charset=utf-8",
			data:$("#form").serialize(),
			success:function(data, statusText){
				alert(data);
			},
			error:function(data, statusText){
				alert("에러 발생");
			}
		});
	});
	
	$("#exist").click(function(){
		
		$.ajax({
			type:"GET",
			url:"/idoverlap/" +$("#id").val(),
			success:function(data, statusText){
				alert(data);
			},
			error:function(data, statusText){
				alert("실패");
			}
		});
	});
});

</script>

</head>
<body>
	<center>
		<form action="makeAccount" method="POST">
			<div class="header">
				<h3>계좌개설</h3>
			</div>
			<div class="container">
				<div class="row">
					<div class="title">계좌번호</div>
					<div class="input">
						<input type="text" name="id" id='id'>
						<button id="exist" type="button">중복</button>
					</div>
				</div>
				<div class="row">
					<div class="title">이름</div>
					<div class="input">
						<input type="text" name="name" id='name'>
					</div>
				</div>
				<div class="row">
					<div class="title">입금액</div>
					<div class="input">
						<input type="text" name="balance" id='balance'>
					</div>

					<div class="button">
						<!-- <input type="submit" value = "개설"> -->

						<input type="button" id="submit" value="개설">
					</div>
				</div>
		</form>
	</center>
</body>
</html>