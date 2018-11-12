<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>

</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/member/regist" method="post">
	<p>
	id : <input type="text" name="id" id="member_id">
	<button type="button" id="idCheckBtn">ID중복체크	</button>
	<span id="idCheckMsg"></span>
	</p>
	 <p>
	pw : <input type="password" name="pw">
	</p>
	<p>
	name : <input type="text" name="name">
	</p>
	
</form>


<script type="text/javascript">
	$("#idCheckBtn").click(function () {
		var member_id = $("#member_id").val();
		
		$.ajax({
			type : "POST",
			url :"${pageContext.request.contextPath}/member/checkId/"+ member_id,
			dataType: "json",
			success:function (result) {
				$("#idCheckMsg").text(result.value);
			},
			error:function () {
				$("#idCheckMsg").text("ID중복체크실패");
			}
		});
	});
</script>

</body>
</html>