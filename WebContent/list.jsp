<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q/A List</title>
    <style>
        *
        {
            margin: 0px;
            padding: 0px;
            font-family: Arial, Helvetica, sans-serif;
        }
        header
        {
            height: 100px;
            line-height: 100px;
            padding: 20px 150px;
            font-family: Arial, Helvetica, sans-serif;
            color: black;
        }
        nav
        {
        	padding-right: 50px;
            text-align: right;
            background-color: rgb(238, 236, 225);;
        }
        .menu > span
        {
            display: inline-block;
            height: 25px;
            width: 80px;
            color : black;
            text-align: center;
            line-height: 25px;
            font-size: 14px;
        }
        
        a:link{color:black; text-decoration:none;}
        a:visited{color:gray; text-decoration:none;}
        a:hover{color:crimson; text-decoration:none;}

        #list
        {
            width: 700px;
            height: 500px;
            float: left;
            padding-left: 100px;
        }
		.mainP {
			width: 1024px;
			height: 768px;
			margin-left: 40px;
			padding-left: 20px;
		}
		table {
			border-collapse: collapse;
			font-size: 12px;
			font-family: arial, Arimo;
			letter-spacing: 1px;
			margin-top: 15px;
			text-align: center;
			border-spacing: 1px;
			padding: 0px;
		}
		.sub {
			font-size: 11px;
			background-color: rgb(238, 236, 225);
		}
		#head {
			display: inline-block;
			margin: 10% 0 0 2%;
			font-size: 15px;
			font-family: arial, Arimo;
			letter-spacing: 1px;
		}
		td {
			text-align: center;
		}
		th, td {
			padding: 10px;
		}
		p {
			margin: 5% 50% 0 0;
			float: right;
		}
		.btn_area {
			margin: 1% 0 0 0;
			float: right;
		}
		input[type=button]
		{
			width: 95px;
			height: 25px;
			margin: 0;
		    border: 0;
		    font-size: 12px;
		    text-align: center;
		    box-sizing: border-box;
		    -webkit-box-sizing: border-box;
		    -moz-box-sizing: border-box;
		    -webkit-user-select: none;
		    cursor: default;
		    background-color: rgb(238, 236, 225);
		    border:1px solid black;
		}
		#titleN {
			font-align: left;
		}
    </style>
</head>
<body>
	<c:choose>
		<c:when test="${userChk==0 }">
			<script>
				alert("로그인 해 주세요.")
				location.href = "list";
			</script>
		</c:when>
		<c:when test="${userChk==1 }">
			<script>
				alert("권한이 없습니다.")
				location.href = "list";
			</script>
		</c:when>
	</c:choose>
    <header>
        <h1>　</h1>
    </header>
    <nav>
    	<div class="menu">
    		<c:if test="${sessionScope.name==null }">
    			<span>GUEST&emsp;</span>
    			<span><a href="./login_form.jsp">LOGIN</a></span>
    			<span><a href="./join_form.jsp">JOIN</a></span>
    			<span><a href="list">LIST</a></span>
    		</c:if>
    		<c:if test="${sessionScope.name!=null }">
    			<span>${sessionScope.name }&emsp;</span>
    			<span><a href="logout">LOGOUT</a></span>
    			<span><a href="#">MYPAGE</a></span>
    			<span><a href="list">LIST</a></span>
	    	</c:if>
	    </div>
    </nav>
    <section id="list">
    	<div class="mainP">
			<div>
				<span id="head">Q/A</span>
			</div>
			<table border=1 width=1024 align=center>
				<tr class="sub">
					<td width=70>NO</td>
					<td width=auto>TITLE</td>
					<td width=100>WRITER</td>
					<td width=90>DATE</td>
					<td width=80>HITS</td>
				</tr>
				<c:forEach items="${ulist }" var="i">
					<tr>
						<td>${i.no }</td>
						<td><a href="identification?no=${i.no }&id=${i.id }">${i.title }</a></td>
						<td>${i.name }
						<td>${i.day }</td>
						<td>　</td>
					</tr>
				</c:forEach>
			</table>
			<div class="btn_area">
				<span class="btn">
					<a href="identification"><input type="button" value="WRITE"></a>
				</span>
			</div>
		</div>
    </section>
    <script type="text.javascript" src="alert.js"></script>
</body>
</html>