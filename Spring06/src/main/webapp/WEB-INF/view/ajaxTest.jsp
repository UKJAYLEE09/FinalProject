<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 방식의 통신 테스트</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div id ="content"></div>
<p><button id="btn">[클릭gogo]</button></p>

<script type="text/javascript">
	$("#btn").click(function () {
		//alert("버튼클릭~!");
		$.ajax({
			type : "POST",
			url :"${pageContext.request.contextPath}/ajaxTest",
			dataType: "json",
			data: "{ name :aaa}",
			success : function (result) {
				alert(result.msg);
				$("#content").text(result.msg);
			},
			
			error : function () {
				alert("ajax 통신에러 발생");
			}
		});
	});
</script>

</body>
</html>