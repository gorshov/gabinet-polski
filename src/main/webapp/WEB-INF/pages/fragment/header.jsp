<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>gabinet-polski</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/resources/assets/templates/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/resources/assets/templates/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="/resources/assets/templates/css/fonts.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="/resources/assets/templates/css/font-awesome.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="/resources/assets/templates/css/icomoon.css" type="text/css" media="all"/>
    <%--
        <link rel="stylesheet" href="/resources/assets/templates/libs/jquery.fancybox.css">
    --%>
    <link rel="stylesheet" href="/resources/assets/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="/resources/assets/templates/libs/uikit.min.css">
    <%--<script src="/resources/assets/templates/libs/jquery.fancybox.pack.js"></script>--%>
    <script src="/resources/assets/templates/libs/uikit.min.js"></script>
    <script src="/resources/assets/templates/js/jquery.min.js"></script>
    <script src="/resources/assets/templates/js/bootstrap.min.js"></script>
    <script src="/resources/assets/templates/js/common.js"></script>
    <script src="/resources/assets/jquery-3.2.1.min.js"></script>
    <script src="/resources/assets/jquery-ui.min.js"></script>
    <style>
        #dialog label, #dialog input {
            display: block;
        }

        #dialog label {
            margin-top: 0.5em;
        }

        #dialog input, #dialog textarea {
            width: 95%;
        }

        #tabs {
            margin-top: 1em;
        }

        #tabs li .ui-icon-close {
            float: left;
            margin: 0.4em 0.2em 0 0;
            cursor: pointer;
        }

        #add_tab {
            cursor: pointer;
        }
    </style>

    <script>
        $(function () {
            $("#tabs").tabs();
        });
    </script>
</head>
<body>
<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="detail">
                <ul>
                    <li><i class="glyphicon glyphicon-earphone" aria-hidden="true">
                    </i><a class="ga_ym_t" href="/">+37529 746-75-68</a></li>
<%--
                    <li><a onclick="ga('send', 'event', 'btn-otkr_form_zakazat_zvonok', 'click-btn-otkr_form_zakazat_zvonok'); yaCounter38618230.reachGoal('otkr_form_zakazat_zvonok'); return true;" class="call-me-btn">Заказать звонок</a></li>
--%>
                    <%--<li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>
                        <a href="contacts">ул. Кальварийская 1, каб 205а</a></li>--%>
                </ul>
            </div>
            <div><a href="/"><img class="logo" src="/resources/assets/templates/images/logo.jpg"></a>
            </div>
            <div class="indicate">
                <p>
                <i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>
                <a href="/mail">info@mail.by</a></li>
                </p>
                <p><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>
                    <a href="/contacts">ул. Кальварийская 1, каб 205а</a></p>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="container">
    <nav class="navbar navbar-default">
        <div class>
            <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                <i class="fa fa-bars visible-sm visible-xs" aria-hidden="true"></i>
                <img src="/resources/assets/templates/images/logo.jpg" class="fix-logo" style="display: none;">
                <nav class="link-effect-2" id="link-effect-2">
                    <ul class="nav navbar-nav">
                        <li class="dropdown"><a href="/">Главная</a></li>
                        <li class="dropdown"><a href="/courses">Наши курсы</a>
                        </li>

                        <li class="dropdown"><a href="/faq">FAQ</a></li>
                        <li class="dropdown"><a href="/reviews">Отзывы</a></li>
                        <li class="dropdown"><a href="/contacts">Контакты</a></li>
                        <li class="dropdown"><a href="/test">Пройти тест</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </nav>
    </div>
</div>

