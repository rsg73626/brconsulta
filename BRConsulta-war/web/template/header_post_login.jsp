<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><!DOCTYPE html>
<html>
    <head>
        <title>Consulta Restaurantes</title>
        <meta charset="utf-8"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>    
            @font-face{
                font-family: Paprika;
                src: url(<c:url value="/css/Paprika-Regular.ttf"/>);
            }*{
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
                background-color: rgb(13,255,0);
            }

            body header nav{
                width: 100%;
                height: 100%;
            }

            body header nav #main_menu{
                width: 100%;
                height: 100%;
                list-style-type: none;
            }

            body header nav #main_menu .main_options{
                width: 25%;
                height: 100%;
                color: #fff;
                float: left;
            }

            body header nav #main_menu .main_options a{
                width: 100%;
                height: 100%;
                color: #fff;
                text-align-last: center;
                line-height: 300%;
                display: inline-block;
                text-decoration: none;
                
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
            }
            
            body header nav #main_menu .main_options:nth-child(1) a{
                background-color:rgba(9,181,29,0.4);
            }
            body header nav #main_menu .main_options #profile{
                width: 100%;
                height: 100%;
                display: inline-block;
                text-align: center;
                line-height: 300%;
                background-color: rgb(13,255,0);
                color: #fff; 
                cursor: pointer;
                
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
            }
            

            
            body header nav ul li a:visited{
                text-decoration: none;
                color: #fff;
            }
            
            body header nav #main_menu li a:hover{
                background-color: #fff;
                color: rgb(13,255,0);
                transition-duration: 0.7s;
            }                
            
            body header nav #main_menu .main_options:nth-child(1) a:hover{                
                background-color:rgba(9,181,29,0.4);
                color: #fff;
            }                
            
            body header nav #main_menu .main_options #profile:hover{
                color: rgb(13,255,0);
                background-color: #fff;
                transition-duration: 0.7s;
            }

            body header nav #main_menu li:nth-child(4):hover #sub_menu{
                display: block;
            }

            body header nav #sub_menu{
                width: 100%;
                height: 200%;
                display: none;
                list-style: none;
            }

            body header nav #sub_menu .sub_options{
                width: 100%;
                height: 50%;
                background-color: rgb(13,255,0);
            }
            
            body header nav #sub_menu .sub_options a{
                color: #fff;
            }
            
            body header nav #sub_menu .sub_options a:hover{
                background-color:rgba(9,181,29,0.4);
                color: #fff;
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
    </head>
    <body>
        <header>
            <nav>
                <ul id="main_menu">
                    <li id="logo" class="main_options">
                        <a href="<c:url value="/index.jsp"/>">
                            BRConsulta
                        </a>
                    </li>
                    <li class="main_options"><a href="<c:url value="/user_area/home.jsp"/>">busca</a></li>
                    <li class="main_options"><a href="<c:url value="/user_area/favorites.jsp"/>">favoritos</a></li>
                    <li class="main_options">
                        <span id="profile">${usuario.userName}</span>
                        <ul id="sub_menu">
                            <li class="sub_options"><a href="<c:url value="/user_area/profile.jsp"/>">perfil</a></li>
                            <li class="sub_options"><a href="${pageContext.request.contextPath}/FrontController?ctrl=Logout">logout</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </header>