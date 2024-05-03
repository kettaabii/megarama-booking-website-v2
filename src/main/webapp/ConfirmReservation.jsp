<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01/05/2024
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Confirm reservation</title>
    <style >
        body {
            background: #dd3f3e;
            font-family: 'Montserrat', sans-serif;
            margin: 0;
            padding: 0;
        }
        .ticket {
            display: -webkit-box;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            justify-content: center;
            -webkit-box-align: center;
            -ms-flex-align: center;
            align-items: center;
            width: 700px;
            margin: 20px auto;
        }
        .ticket .stub,
        .ticket .check {
            box-sizing: border-box;
        }
        .stub {
            background: #ef5658;
            height: 250px;
            width: 250px;
            color: white;
            padding: 20px;
            position: relative;
        }
        .stub:before {
            content: '';
            position: absolute;
            top: 0;
            right: 0;
            border-top: 20px solid #dd3f3e;
            border-left: 20px solid #ef5658;
            width: 0;
        }
        .stub:after {
            content: '';
            position: absolute;
            bottom: 0;
            right: 0;
            border-bottom: 20px solid #dd3f3e;
            border-left: 20px solid #ef5658;
            width: 0;
        }
        .stub .top {
            display: -webkit-box;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-align: center;
            -ms-flex-align: center;
            align-items: center;
            height: 40px;
            text-transform: uppercase;
        }
        .stub .top .line {
            display: block;
            background: #fff;
            height: 40px;
            width: 3px;
            margin: 0 20px;
        }
        .stub .top .num {
            font-size: 10px;
        }
        .stub .top .num span {
            color: #000;
        }
        .stub .number {
            position: absolute;
            left: 40px;
            font-size: 150px;
        }
        .stub .invite {
            position: absolute;
            left: 150px;
            bottom: 45px;
            color: #000;
            width: 20%;
        }
        .stub .invite:before {
            content: '';
            background: #fff;
            display: block;
            width: 40px;
            height: 3px;
            margin-bottom: 5px;
        }
        .check {
            background: #fff;
            height: 250px;
            width: 450px;
            padding: 40px;
            position: relative;
        }
        .check:before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            border-top: 20px solid #dd3f3e;
            border-right: 20px solid #fff;
            width: 0;
        }
        .check:after {
            content: '';
            position: absolute;
            bottom: 0;
            left: 0;
            border-bottom: 20px solid #dd3f3e;
            border-right: 20px solid #fff;
            width: 0;
        }
        .check .big {
            font-size: 80px;
            font-weight: 900;
            line-height: .8em;
        }
        .check .number {
            position: absolute;
            top: 50px;
            right: 50px;
            color: #ef5658;
            font-size: 40px;
        }
        .check .info {
            display: -webkit-box;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-pack: start;
            -ms-flex-pack: start;
            justify-content: flex-start;
            font-size: 12px;
            margin-top: 20px;
            width: 100%;
        }
        .check .info section {
            margin-right: 50px;
        }
        .check .info section:before {
            content: '';
            background: #ef5658;
            display: block;
            width: 40px;
            height: 3px;
            margin-bottom: 5px;
        }
        .check .info section .title {
            font-size: 10px;
            text-transform: uppercase;
        }

    </style>
</head>
<body>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<div class="ticket">
    <div class="stub">
        <div class="top">
            <span class="admit">Admit</span>
            <span class="line"></span>
            <span class="num">
        Invitation
        <span>31415926</span>
      </span>
        </div>
        <div class="number">1</div>
        <div class="invite">
            ${title}
        </div>
    </div>
    <div class="check">
        <div class="big">
            ticket <br> Megarama
        </div>
        <div class="number">${seats}</div>
        <div class="info">
            <section>
                <div class="title">Date</div>
                <div>${date}</div>
            </section>
            <section>
                <div class="title">Issued By</div>
                <div>${viewer}</div>
            </section>
            <section>
                <div class="title">Invite Number</div>
                <div>31415926</div>
            </section>
        </div>
    </div>
</div>

</body>
</html>
