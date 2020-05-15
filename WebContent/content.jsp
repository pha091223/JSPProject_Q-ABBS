<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q/A Content</title>
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
			width: 600px;
			height: 768px;
			margin-left: 250px;
			padding-left: 20px;
		}
        table {
            margin-top: 15px;
            text-align: center;
            width: 600px;
            background-color: rgb(238, 236, 225);
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
		span {
            font-size: 11px;
            font-family: arial, Arimo;
            letter-spacing: 1px;
        }
		th, td {
			padding: 10px;
		}
		p {
			margin: 5% 50% 0 0;
			float: right;
		}
		.btn_area {
			margin: 2% 0 0 0;
			float: right;
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
		.formEle {
            padding-left: 10px;
            text-align: left;
        }
        select {
        	width : 200px;
        	height : 25px;
        }
        input[type=text], [type=password] {
        	width : 200px;
        	height : 18px;
        }
        textArea {
        	resize:none
        }
        .btn3 {
        	display: inline-block;
        	margin: 2% 0 0 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>　</h1>
    </header>
    <nav>
    	<div class="menu">
    		<span>${sessionScope.name }&emsp;</span>
    		<span><a href="logout">LOGOUT</a></span>
	        <span><a href="#">MYPAGE</a></span>
	        <span><a href="list">LIST</a></span>
	    </div>
    </nav>
    <section id="list">
	    <div class="mainP">
	        <form method=post name="contentForm">
	            <div>
	                <span id="head">CONTENT</span>
	            </div>
	            <table border=0 align=center width='1024' class="txt" align=center>
	                <tr>
	                    <td width=100><span>TITLE</span></td>
	                    <td class="formEle" colspan=4>
		                    <span>${content.title }</span>
		                    <input type="hidden" name="ititle" value="${content.title }">
	                    </td>
	                </tr>
	                <tr>
	                    <td width=100><span>WRITER</span></td>
	                    <td class="formEle" colspan=3><span>${content.name}</span>
	                    	<input type="hidden" name="iname" value="${content.name}">
	                    	<input type="hidden" name="iid" value="${content.id }">
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="3" class="formEle">
		                    <textarea name="icontent" cols="79" rows="15" readonly>${content.text }</textarea>
		                    <input type="hidden" name="icontent" value="${content.text }">
	                    </td>
	                </tr>
	                <tr>
	                    <td width=100><span>PASSWORD</span></td>
	                    <td class="formEle" colspan=3><input type="password" size="12" name="ipwd" maxlength="8"></td>
	                </tr>
	            </table>
	           	<span class="btn3"><input type="submit" value="DELETE" onclick="" formaction="write_delete?no=${content.no }"></span>
	            <div class="btn_area">
	                <span class="btn1"><input type="submit" value="MODIFY" onclick="" formaction="write_modify?no=${content.no }mod"></span>
	                <span class="btn2"><a href="javascript:history.back(-1)"><input type="button" value="CANCLE"></a></span>
	            </div>
	        </form>
	    </div>
    </section>
</body>
</html>