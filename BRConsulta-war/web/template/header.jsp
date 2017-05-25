<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><!DOCTYPE html>
<html>
    <head>
        <title>Consulta Restaurantes</title>
        <meta charset="utf-8"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>    
            @font-face{
                font-family: Paprika;
                src: url(css/Paprika-Regular.ttf);
            }
            *{
                margin: 0;
                padding: 0;
            }
            
            html{
                margin: 0;
                padding: 0;
                width: 100%;
                height: 100%;
            }

            body{
                margin: 0;
                padding: 0;
                width: 100%;
                height: 100%;
                
                font-family: Paprika;
            }

            body header{
                width: 100%;
                height: 7.5%;
                position: fixed;
                background-color: rgb(13,255,0);
            }

            body header nav{
                width: 100%;
                height: 100%;
                margin: 0;
                padding: 0;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2), 0 0px 10px rgba(0, 0, 0, 0.19);

                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
            }

            body header nav ul{
                width: 80%;
                height: 100%;
                margin: 0;
                padding: 0;
                list-style: none;

                display: flex;
                flex-direction: row;
                flex-wrap: nowrap;
                justify-content: center;
                align-items: center;
            }

            body header nav ul li{
                margin: 0;
                padding: 0;
                width: 20%;
                height: 100%;
                color: #FFF;

                display: flex;
                flex-direction: row;
                justify-content: space-around;
                align-items: center;
                flex-basis: auto;
            }
            
            body header nav ul li:nth-child(1){
                background-color: rgba(9,181,29,0.4);
            }
            
            body header nav ul li:nth-child(4) a{
                padding: 2% 20%;
                border: 2px solid #fff;
                border-radius: 5px;
            }
            
            body header nav ul li a,body header nav ul li a:active,body header nav ul li a:visited{
                text-decoration: none;
                color: #fff;
                display: inline-block;
            }

            body header nav ul li:nth-child(1) a{
                width: 100%;
                height: 100%;

                display: flex;
                flex-direction: row;
                flex-wrap: nowrap;
                justify-content: center;
                align-items: center;
            }

            body header nav ul li:nth-child(1) a img{
                margin: 0;
                padding: 0;
                display: flex;
            }

            body header nav ul li:hover{
                background-color: #fff;
                transition-duration: 0.7s;
            }

            body header nav ul li:hover a{
                color: rgb(13,255,0);
                transition-duration: 0.7s;
            }

            body header nav ul li:nth-child(1):hover{
                background-color: rgba(9,181,29,0.4);
            }
            
            body header nav ul li:nth-child(4):hover{
                background-color: rgb(13,255,0);
            }
            
            body header nav ul li:nth-child(4):hover a{
                color: #fff;
            }
            
            body header nav ul li:nth-child(4) a:hover{
                color: rgb(13,255,0);
                background-color: #fff;
                transition-duration: 0.7s;
            }

            body header nav ul li:nth-child(1):hover a{
                color: #fff;
                transition-duration: 0s;
            }

            body footer{
                width: 100%;
                height: 5%;
                
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
                background-color: rgb(13,255,0);
            }

            body footer a{
                color: #fff;
                font-size: 14px;
            }
            
            body footer a:active, body footer a:visited{
                text-decoration: none;
                color: #fff;
            }
        </style>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/button_style.css"/>"/>
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="index.jsp">BRConsulta</a></li>
                    <li><a href="index.jsp">inicio</a></li>
                    <li><a href="signup.jsp">registrar-se</a></li>
                    <li><a href="signin.jsp">login</a></li>
                </ul>
            </nav>
        </header>
