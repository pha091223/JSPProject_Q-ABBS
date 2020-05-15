<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q/A Join</title>
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
			margin-left: 250px;
			padding-left: 50px;
		}
        table {
            margin-top: 15px;
            text-align: center;
            width: 500px;
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
			text-align: left;
		}
		th, td {
			padding: 10px 10px 10px 50px;
		}
		p {
			margin: 5% 50% 0 0;
			float: right;
		}
		.btn_area {
			margin: 1% 0 0 0;
			padding-left: 160px;
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
		input[type=text], [type=password] {
        	width : 200px;
        	height : 18px;
        }
        #chk {
        	margin-left: 20px;
        	width: 50px;
        	border:1px solid gray;
        }
    </style>
</head>
<body>
	<c:if test="${chk==1 }">
		<script>
    		if(!alert("중복된 아이디입니다.")){
    			window.close();
    		}
		</script>
	</c:if>
	<c:if test="${chk==0 }">
		<script>
			if(!alert("사용가능한 아이디입니다.")){
				window.close();
			}
		</script>
	</c:if>
	<script type="text/javascript" src="alert.js"></script>
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
	        <form action="join" method=post name="joinForm">
	            <div>
	                <span id="head">JOIN</span>
	            </div>
	            <table border=0 align=center width='1024' class="txt" align=center>
	            	<tr>
	            		<td>
	            		</td>
	            	</tr>
	                <tr>
	                    <td><span>ID</span></td>
	                    <td class="formEle" colspan=1><input type="text" size="15" name="iid" maxlength="8">
	                    <input type="button" value="Check" id="chk" onclick="return idCheck()"></td>
	                </tr>
	                <tr>
	                    <td><span>PASSWORD</span></td>
	                    <td class="formEle" colspan=1><input type="password" size="15" name="ipwd" maxlength="15"></td>
	                </tr>
	                <tr>
	                    <td><span>NAME</span></td>
	                    <td class="formEle" colspan=1><input type="text" size="15" name="iname" maxlength="5"></td>
	                </tr>
	                <tr>
	            		<td>
	            		</td>
	            	</tr>
	            </table>
	            <br>
	            <div class="btn_area">
	                <span class="btn1"><input type="submit" value="JOIN" onclick="return joinCheck()"></span>
	                <span class="btn2"><a href="list"><input type="button" value="Cancle"></a></span>
	            </div>
	        </form>
		</div>
    </section>
    <script type="text/javascript" src="alert.js"></script>
</body>
</html>