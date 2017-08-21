<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>gabinet-polski</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/resources/assets/templates/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/resources/assets/templates/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="/resources/assets/templates/css/fonts.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="/resources/assets/templates/css/font-awesome.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="/resources/assets/templates/css/icomoon.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="/resources/assets/templates/libs/jquery.fancybox.css">
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

    <%-- <script>
         $(function () {
             $("#tabs").tabs();
         });
     </script>--%>
    <%--<script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-81130650-1', 'auto');
        ga('require', 'displayfeatures');
        ga('send', 'pageview');

    </script>--%>
    <%--<script>
        $(document).ready(function () {
            var tabTitle = $("#tab_title"),
                tabContent = $("#tab_content"),
                tabTemplate = "<li><a href=myHref>myLabel</a> <span class='ui-icon ui-icon-close' role='presentation'>Remove Tab</span></li>",
                    /* tabTemplate1 = "<li><a href=\"#",
                     tabTemplate2 = "\">#",
                     tabTemplate3 = "</a> <span class='ui-icon ui-icon-close' role='presentation'>Remove Tab</span></li>",*/
                tabCounter = 2;

            var tabs = $("#tabs").tabs();

            // Modal dialog init: custom buttons and a "close" callback resetting the form inside
            var dialog = $("#dialog").dialog({
                autoOpen: false,
                modal: true,
                buttons: {
                    Add: function () {
                        addTab();
                        $(this).dialog("close");
                    },
                    Cancel: function () {
                        $(this).dialog("close");
                    }
                },
                close: function () {
                    form[0].reset();
                }
            });

            // AddTab form: calls addTab function on submit and closes the dialog
            var form = dialog.find("form").on("submit", function (event) {
                addTab();
                dialog.dialog("close");
                event.preventDefault();
            });

            // Actual addTab function: adds new tab using the input from the form above
            function addTab() {
                var label = tabTitle.val() || "Tab " + tabCounter,
                    id = "tabs-" + tabCounter,
                    li = $(tabTemplate.replace("myhref", "#" + id).replace("myLabel", label)),
                    tabContentHtml = tabContent.val() || "Tab " + tabCounter + " content.";

                tabs.find(".ui-tabs-nav").append(li);
                tabs.append("<div id='" + id + "'><p>" + tabContentHtml + "</p></div>");
                tabs.tabs("refresh");
                tabCounter++;
            }

            // AddTab button: just opens the dialog
            $("#add_tab")
                .button()
                .on("click", function () {
                    dialog.dialog("open");
                });

            // Close icon: removing the tab on click
            tabs.on("click", "span.ui-icon-close", function () {
                var panelId = $(this).closest("li").remove().attr("aria-controls");
                $("#" + panelId).remove();
                tabs.tabs("refresh");
            });

            tabs.on("keyup", function (event) {
                if (event.altKey && event.keyCode === $.ui.keyCode.BACKSPACE) {
                    var panelId = tabs.find(".ui-tabs-active").remove().attr("aria-controls");
                    $("#" + panelId).remove();
                    tabs.tabs("refresh");
                }
            });
        });
    </script>--%>

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
                    <li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>
                        <a href="contacts">ул. Кальварийская 1, каб 205а</a></li>
                </ul>
            </div>
            <div><a href="/">
                <img class="logo" src="/resources/assets/templates/images/logo.jpg"></a>
            </div>
            <div class="indicate">
                <i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>
                <a href="/mail">info@mail.by</a></li>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="container">
        <nav class="navbar navbar-default">
            <div class="">

                <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                    <i class="fa fa-bars visible-sm visible-xs" aria-hidden="true"></i>
                    <img src="/resources/assets/templates/images/logo.jpg" class="fix-logo">
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
<div class="cart-banner">
    <img src="/resources/assets/templates/images/sl2_s.jpg" width="100%" style="position: relative;">
</div>

<br>

<div class="container">
    <div class="content-text">

        <h1 style="text-align: center;">Наши курсы польского.</h1>

        <%-- <div id="dialog" title="Tab data">
             <form>
                 <fieldset class="ui-helper-reset">
                     <label for="tab_title">Title</label>
                     <input type="text" name="tab_title" id="tab_title" value="Tab Title"
                            class="ui-widget-content ui-corner-all">
                     <label for="tab_content">Content</label>
                     <textarea name="tab_content" id="tab_content"
                               class="ui-widget-content ui-corner-all">Tab content</textarea>
                 </fieldset>
             </form>
         </div>--%>

        <%--<button id="add_tab">Add Tab</button>--%>
        <div id="tabs">
            <ul>
                <li><a href="#tabs-1">${mapOfPolish.courseName}</a></li>
                <li><a href="#tabs-2">${fromZeroToA2.courseName}</a></li>
                <li><a href="#tabs-3">${fromA1A2ToB2.courseName}</a></li>
                <li><a href="#tabs-4">${fromB2ToC1.courseName}</a></li>
            </ul>
            <div class="uk-grid">
                <div class="uk-width-medium-2-3">
                    <div id="tabs-1">
                        <div class="switcher-content__title">${mapOfPolish.courseName}</div>
                        <div class="switcher-content_age another_p">
                            <p>Cost</p>
                        </div>
                        <div class="switcher-content__message">
                            <p></p>
                        </div>
                        <table></table>
                    </div>
                    <div id="tabs-2">
                        <div class="switcher-content__title">${fromZeroToA2.courseName}</div>
                        <div class="switcher-content_age another_p">
                            <p>Cost</p>
                        </div>
                        <div class="switcher-content__message">
                            <p></p>
                        </div>
                        <table></table>
                    </div>
                    <div id="tabs-3">
                        <div class="switcher-content__title">${fromA1A2ToB2.courseName}</div>
                        <div class="switcher-content_age another_p">
                            <p>Cost</p>
                        </div>
                        <div class="switcher-content__message">
                            <p></p>
                        </div>
                        <table></table>
                    </div>
                    <div id="tabs-4">
                        <div class="switcher-content__title">${fromB2ToC1.courseName}</div>
                        <div class="switcher-content_age another_p">
                            <p>Cost</p>
                        </div>
                        <div class="switcher-content__message">
                            <p></p>
                        </div>
                        <table></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br/>

<%--<script type="text/javascript">
    $(document).ready(function () {
        $(".ga_ym_t").bind('click', function () {
            //console.log('click');
            ga('send', 'event', 'tel-info', 'ClickTel');
            yaCounter38618230.reachGoal('ClickTelYM');

            return true;
        });
        $(".ga_ym_t").bind('copy', function () {
            ga('send', 'event', 'tel-info', 'CopyTel');
            yaCounter38618230.reachGoal('CopyTelYM');
            return true;
        });
        $(".ga_ym_t").bind('contextmenu', function () {
            ga('send', 'event', 'tel-info', 'RightTel');
            yaCounter38618230.reachGoal('RightClickTelYM');
            return true;
        });
        $(".ga_ym_m").bind('click', function () {
            ga('send', 'event', 'mail-info', 'ClickMail');
            yaCounter38618230.reachGoal('ClickMailYM');
            return true;
        });
        $(".ga_ym_m").bind('copy', function () {
            ga('send', 'event', 'mail-info', 'CopyMail');
            yaCounter38618230.reachGoal('CopyMailYM');
            return true;
        });
        $(".ga_ym_m").bind('contextmenu', function () {
            ga('send', 'event', 'mail-info', 'RightMail');
            yaCounter38618230.reachGoal('RightClickMailYM');
            return true;
        });
    });
</script>
<!-- Yandex.Metrika counter -->
<script type="text/javascript">
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function () {
            try {
                w.yaCounter38618230 = new Ya.Metrika({
                    id: 38618230,
                    clickmap: true,
                    trackLinks: true,
                    accurateTrackBounce: true,
                    webvisor: true,
                    trackHash: true
                });
            } catch (e) {
            }
        });

        var n = d.getElementsByTagName("script")[0],
            s = d.createElement("script"),
            f = function () {
                n.parentNode.insertBefore(s, n);
            };
        s.type = "text/javascript";
        s.async = true;
        s.src = "https://mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else {
            f();
        }
    })(document, window, "yandex_metrika_callbacks");
</script>--%>
</body>
</html>