<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="fragment/header.jsp"/>
<div class="cart-banner">
    <img src="/resources/assets/templates/images/sl2_s.jpg" width="100%" style="position: relative;">
</div>

<br>

<div class="container">
    <div class="content-text">

        <h1 style="text-align: center;">Наши курсы польского.</h1>
        <div class="container">
            <div id="tabs" class="col-sm-12">
                <ul>
                    <li><a href="#tabs-1">${mapOfPolish.courseName}</a></li>
                    <li><a href="#tabs-2">${fromZeroToA2.courseName}</a></li>
                    <li><a href="#tabs-3">${fromA1A2ToB2.courseName}</a></li>
                    <li><a href="#tabs-4">${fromB2ToC1.courseName}</a></li>
                </ul>
                <div class="uk-grid">
                    <div class="uk-width-medium-2-3">
                        <div class="row">
                            <div id="tabs-1">
                                <div id="${mapOfPolish}" class="switcher-content__title">${mapOfPolish.courseName}</div>
                                <div id="costMapPolis" class="switcher-content_age another_p">
                                    <p>Cost</p>
                                </div>
                                <div class="switcher-content__message">
                                    <p id="courseDescription-1"></p>
                                </div>
                                <table></table>

                            </div>
                        </div>
                        <div id="tabs-2">
                            <div class="switcher-content__title">${fromZeroToA2.courseName}</div>
                            <div id="costZeroToA2" class="switcher-content_age another_p">
                                <p>Cost</p>
                            </div>
                            <div class="switcher-content__message">
                                <p id="courseDescription-2"></p>
                            </div>
                            <table></table>
                        </div>
                        <div id="tabs-3">
                            <div class="switcher-content__title">${fromA1A2ToB2.courseName}</div>
                            <div id="costA1A2ToB2" class="switcher-content_age another_p">
                                <p>Cost</p>
                            </div>
                            <div class="switcher-content__message">
                                <p id="courseDescription-3"></p>
                            </div>
                            <table></table>
                        </div>
                        <div id="tabs-4">
                            <div class="switcher-content__title">${fromB2ToC1.courseName}</div>
                            <div id="costB2ToC1" class="switcher-content_age another_p">
                                <p>Cost</p>
                            </div>
                            <div class="switcher-content__message">
                                <p id="courseDescription-4"></p>
                            </div>
                            <table></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br/>
<script>
    var mapPolish = "MAP_POLES";
    var fromZeroToA2 = "FROM_ZERO_TO_A2";
    var fromA1A2ToB2 = "FROM_A1_A2_TO_B2";
    var fromB2ToC1 = "FROM_B2_TO_C1";
    $(document).ready(getCoursesByName(mapPolish), getCoursesByName(fromZeroToA2), getCoursesByName(fromA1A2ToB2), getCoursesByName(fromB2ToC1));

    function getCoursesByName(nameOfCourse) {
        var url = "/courses/" + nameOfCourse;
        $.ajax({
                type: "GET",
                dataType: "json",
                contentType: "application/json",
                url: url,
                error: function () {

                },
                success: function (result) {
                    var appendTextCost = (result.cost + ' ' + 'рублей');
                    var appendTextDescription = (result.description);
                    if (nameOfCourse == mapPolish) {
                        $("#costMapPolis").append(appendTextCost);
                        $("#courseDescription-1").append(appendTextDescription);
                    } else if (nameOfCourse == fromZeroToA2) {
                        $("#costZeroToA2").append(appendTextCost);
                        $("#courseDescription-2").append(appendTextDescription);
                    }
                    else if (nameOfCourse == fromA1A2ToB2) {
                        $("#costA1A2ToB2").append(appendTextCost);
                        $("#courseDescription-3").append(appendTextDescription);
                    }
                    else if (nameOfCourse == fromB2ToC1) {
                        $("#costB2ToC1").append(appendTextCost);
                        $("#courseDescription-4").append(appendTextDescription);
                    }

                }
            }
        )
    }

</script>
</body>
</html>