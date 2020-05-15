<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q/A Login</title>
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
			width: 500px;
			height: 768px;
			margin-top: 100px;
			margin-left: 300px;
			padding-left: 50px;
		}
        table {
            margin-top: 15px;
            text-align: center;
            width: 400px;
            background-color: rgb(238, 236, 225);
            border-spacing: 1px;
            padding: 0px;
            font-size: 12px;
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
			padding-left: 110px;
		}
		input[type=submit], [type=button]
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
		    border:1px solid lightgray;
		}
    </style>
</head>
<body>
	<script type="text/javascript" src="alert.js"></script>
	<c:if test="${loginChk==0 }">
		<script>
			alert("아이디나 비밀번호가 틀렸습니다.");
		</script>
	</c:if>
    <header>
        <h1>　</h1>
    </header>
    <nav>
    	<div class="menu">
    		<span>GUEST&emsp;</span>
    		<span><a href="./login_form.jsp">LOGIN</a></span>
	        <span><a href="./join_form.jsp">JOIN</a></span>
	        <span><a href="list">LIST</a></span>
	    </div>
    </nav>
    <section id="list">
    	<div class="mainP">
	        <form action="login" method=post name="loginForm">
	            <div>
	                <span id="head">LOGIN</span>
	            </div>
	            <table border=0 align=center width='1024' class="txt" align=center>
	            	<tr>
	            		<td>
	            		</td>
	            	</tr>
	                <tr>
	                    <td><span>ID</span></td>
	                    <td class="formEle" colspan=1><input type="text" size="15" name="iid" maxlength="8"></td>
	                </tr>
	                <tr>
	                    <td><span>PASSWORD</span></td>
	                    <td class="formEle" colspan=1><input type="password" size="15" name="ipwd" maxlength="15"></td>
	                </tr>
	                <tr>
	            		<td>
	            		</td>
	            	</tr>
	            </table>
	            <br>
	            <div class="btn_area">
	                <span class="btn1"><input type="submit" value="IN" onclick="return loginCheck()"></span>
	                <span class="btn2"><a href="list"><input type="button" value="Cancle"></a></span>
	            </div>
	        </form>
		</div>
    </section>
</body>
</html>