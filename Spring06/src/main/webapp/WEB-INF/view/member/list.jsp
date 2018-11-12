<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원목록보기</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<table border="1" id="memberListTable">
	<tr>
		<th>아이디</th>
		<th>패스워드</th>
		<th>이름</th>
	</tr>


</table>

<p><button id="memberListBtn">[회원목록불러오기]</button></p>

<script type="text/javascript">
	$("#memberListBtn").click(function () {
		//alert("버튼클릭~!");
		$.ajax({
			type : "POST",
			url :"${pageContext.request.contextPath}/member/list",
			dataType: "json",
			success : function (result) {
				//alert(result.msg);
				
				$.each(result,function(index ,member){
					alert(index +  "," + member.id + "," + member.pw + "," + member.name);
				
					var contents = "<tr class='memberContents'>" ;
					contents += "<td>" + member.id + "</td>";
					contents += "<td>" + member.pw + "</td>";
					contents += "<td>" + member.name + "</td>";
					contents += "/<tr>"
					$("#memberListTable").append(contents);
				})
				
				
				
			},
			error : function () {
				alert("ajax 통신에러 발생");
			}
		});
	});
</script>
<p><button></button>
</body>
</html>