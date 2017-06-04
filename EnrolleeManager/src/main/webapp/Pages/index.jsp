<%@ page import="java.util.Date" %>
<%@ page import="java.awt.*" %>
<%@ page import="viti.kaf22.controllers.IndexController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="option" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>ІС "ВСТУП"</title>
    <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>--%>
    <script src="sources/jquery-3.2.0.min.js"></script>
    <style type="text/css">
        div.outline {
            width: 100%;
            display: inline-block;
            margin-left: 0;
            margin-top: 0;
        }

        div.inline1 {
            width: 25%;
            display: inline-block;
            margin-left: 0;
            margin-top: 0;
        }

        div.inline2 {
            width: 40%;
            display: inline-block;
            margin-left: 0;
            margin-top: 0;
        }

        div.block {
            position: absolute;
            top: 650px;
            left: 10px;
        }
    </style>
</head>
<body>
<form:form commandName="abiturient">
    <H1>Інформаційна система "ВСТУП"(developer version)</H1>

    <%-------------------------Input/Edit blocks----------------------------------------------------------------------%>
    <div class="outline">
        <div class="inline1">
            <label>Соціальний статус</label>
        </div>
        <div class="inline2">
            <spring:select id="socSelector" path="abiturient.status.id" onchange="showStatusBlock()">
                <c:forEach items="${statuses}" var="status">
                    <option value="${status.id}">
                        <c:out value="${status.name}"/>
                    </option>
                </c:forEach>
            </spring:select>
        </div>
    </div>

    <div id="status" class="outline" style="display: none">
        <div class="inline1">
            <label>Військова частина</label>
        </div>
        <div class="inline2">
            <spring:input path="abiturient.viyskovaChastina.number"/>
        </div>
        <div class="inline2">
            <label>Військове звання</label>
        </div>
        <spring:select id="zvSelector" path="abiturient.zvan.id">
            <c:forEach items="${zvannya}" var="zv">
                <option value="${zv.id}" <c:out value="${zv.id==abiturient.viyskoveZvanya.id?' selected':''}"></c:out>>
                    <c:out value="${zv.name}"/>
                </option>
            </c:forEach>
        </spring:select>
    </div>

    </div>
    <div class="outline">
        <div class="inline1">
            <label>Номер особової справи</label>
        </div>
        <div class="inline2">
            <spring:input id="os" path="abiturient.sprava"/>
        </div>
    </div>

    <div class="outline">
        <div class="inline1">
            <label>Прізвище</label>
        </div>
        <div class="inline2">
            <spring:input id="prizv" path="abiturient.prizvishche.name"/>
        </div>
    </div>

    <div class="outline">
        <div class="inline1">
            <label>Ім'я</label>
        </div>
        <div class="inline2">
            <spring:input id="imya" path="abiturient.imya.name"/>
        </div>
    </div>

    <div class="outline">
        <div class="inline1">
            <label>Ім'я по батькові</label>
        </div>
        <div class="inline2">
            <spring:input id="impobatkovi" path="abiturient.imyaPoBatkovi.name"/>
        </div>
    </div>

    <div class="outline">
        <div class="inline1">
            <label>Стать</label>
        </div>
        <div class="inline2">
            <spring:select id="statSelector" path="abiturient.stat.id">
                <c:forEach items="${stati}" var="stat">
                    <option value="${stat.id}" <c:out value="${stat.id==abiturient.stat.id?' selected':''}"></c:out>>
                        <c:out value="${stat.name}"/>
                    </option>
                </c:forEach>
            </spring:select>
        </div>
    </div>

    <div class="outline">
        <div class="inline1">
            <label>Дата народження</label>
        </div>
        <div class="inline2">
            <form:input type="date" path="birth"/>
        </div>
    </div>

    <div class="outline" id="phoneEditor">
        <%--<c:forEach items="${abiturient.abiturient.nomerTelefonus}" var="phone">--%>
            <%--<div class="inline1">--%>
                <%--<label>Номер телефону</label>--%>
            <%--</div>--%>
            <%--<div id="phoneNumber" class="inline2">--%>
                <%--<spring:input path="phoneNumber" value="phone"/>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>
        <button onclick="alert('phoneNumber')">+</button>
    </div>

    <%--<div class="outline">--%>
        <%--<label>Дані про атестат абітурієнта</label><br><br>--%>
        <%--<div class="inline1">--%>
            <%--<label>Номер та серія </label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<form:input path="nomerSeria"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Середній бал (12-бальна шкала)</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<form:input path="avarage12"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Середній бал (200-бальна шкала)</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<form:input path="avarage200"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Дата видачі</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<form:input path="dataVidachi"/>--%>
        <%--</div>--%>
    <%--</div>--%>


    <%--================================================================================================================--%>
    <br><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button formmethod="POST" formaction="add">Додати абітурієнта</button>
    &nbsp;&nbsp;&nbsp;
    <button formmethod="POST" formaction="update2">Зберегти зміни</button>
    &nbsp;&nbsp;&nbsp;
    <a type="application/file" href="/app_storage/reports/primary.xls" download>Завантажити звіт(.xls)</a>

</form:form>

<div style="position: relative">
    <spring:form cssStyle="position: relative">
        <table oncontextmenu="menu(event)" border="1" cellpadding="4" cellspacing="0">
            <tr>
                <th>Номер особової справи</th>
                <th>Соціальний статус</th>
                <th>Прізвище</th>
                <th>Ім'я</th>
                <th>По батькові</th>
                <th>Дата народження</th>
                <th>Номер телефону</th>
                <th>Серія і номер</th>
                <th>Бал (12)</th>
                <th>Бал (200)</th>
                <th>Дата видачі</th>
                <th>Час реєстрації</th>
            </tr>
            <c:forEach items="${abiturients}" var="abitur">
                <tr oncontextmenu="return menu('${abitur.id}', event)" id="string">
                    <th><c:out value="${abitur.sprava}"/></th>
                    <th><c:out value="${abitur.status.name}"/></th>
                    <th><c:out value="${abitur.prizvishche.name}"/></th>
                    <th><c:out value="${abitur.imya.name}"/></th>
                    <th><c:out value="${abitur.imyaPoBatkovi.name}"/></th>
                    <th><c:out value="${abitur.birth}"/></th>
                        <%--<c:if test="${abitur.nomerTelefonus.size()>0}">--%>
                        <%--<th><c:out value="${abitur.nomerTelefonus.get(0).nomer}"/></th>--%>
                        <%--</c:if>--%>
                    <th><c:out value="${abitur.atestat.nomerSeria}"/></th>
                    <th><c:out value="${abitur.atestat.average12}"/></th>
                    <th><c:out value="${abitur.atestat.average200}"/></th>
                    <th><c:out value="${abitur.atestat.dataVidachi}"/></th>

                    <th><c:out value="${abitur.chasReestr}"/></th>
                </tr>
            </c:forEach>
        </table>

        <div id="contextMenuId"
             style="position:absolute; top:0; left:0; border:1px solid #666; background-color:white; display:none; float:left;"></div>
    </spring:form>
</div>


<%--------------------------------------------------------------------------------------------------------------------%>
<%-------------------------------JAVA_SCRIPT--------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<script>
    <%--$(document).ready(function(){--%>
    <%--$('#sel').change(function(){--%>
    <%--if ($('#sel option:selected').hasClass("block1")) {--%>
    <%--$('#infoBlock').HTML("<input value="${discipline.nazvaDiscipline}"></input>";);--%>
    <%--&lt;%&ndash;//                        "<label>Назва дисципліни<label>" +&ndash;%&gt;--%>
    <%--&lt;%&ndash;"<form:input path="discipline.nazvaDiscipline"></form:input>");&ndash;%&gt;--%>
    <%--&lt;%&ndash;"<form:button formmethod='POST' formaction='add'>Додати абітурієнта</form:button>");&ndash;%&gt;--%>
    <%--} else if ($("#sel option:selected").hasClass("block2")) {--%>
    <%--$("#infoBlock").html("<h1>Hello block2</h1>");--%>
    <%--} else if ($('#sel option:selected').hasClass("block3")) {--%>
    <%--$("#infoBlock").html("<input type='text' name='type' value='Ищу водителя / исполнителя'>");--%>
    <%--} /*else if ($('#sel option:selected').hasClass("sel4")) {--%>
    <%--$("#infoBlock").html("<input type='text' name='type' value='Отдам заказ / Ищу исполнителя'>");--%>
    <%--}*/--%>
    <%--});--%>
    <%--});--%>

    function addPhone(phoneNumber) {
        alert(phoneNumber);
//        $.ajax({
//            url: "addPhone",
//            type: "POST",
//            data: "phoneNumber"
//        })
    }

    function showStatusBlock() {
        if (document.getElementById('socSelector').value == 1) {
            document.getElementById('status').style.display = 'inline';
        } else if (document.getElementById('socSelector').value == 2) {
            document.getElementById('status').style.display = 'none';
        }

    }

    //===Удалить/Обновить==========================================================================================//
    var temp;
    function deleteAbiturient(temp) {
        $.ajax({
            url: "delete",
            type: "POST",
            data: temp,
            contentType: "application/json"
        });
    }
    function updateAbiturient(temp) {
        $.ajax({
            url: "update",
            type: "POST",
            data: temp,
            contentType: "application/json"
        });
    }

    //===Собсвенное контекстное меню==============================================================================//
    $.document
    function defPosition(event) {
        var x = y = 0;
        if (document.attachEvent != null) {
            x = window.event.clientX + (document.documentElement.scrollLeft ? document.documentElement.scrollLeft : document.body.scrollLeft);
            y = window.event.clientY + (document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop);
        } else if (!document.attachEvent && document.addEventListener) { // Gecko
            x = event.clientX + window.scrollX;
            y = event.clientY + window.scrollY;
        } else {
            // Do nothing
        }
        return {x: x, y: y};
    }

    function menu(abiturient, evt) {
        temp = abiturient;

        // Блокируем всплывание события contextmenu
        evt = evt || window.event;
        evt.cancelBubble = true;
        // Показываем собственное контекстное меню
        var menu = document.getElementById("contextMenuId");
        var html = "";
        html += "<br><label onclick=\"deleteAbiturient(temp)\">Видалити</label>";
        html += "<br><label onclick=\"updateAbiturient(temp)\">Редагувати</label>";

        if (html) {
            menu.innerHTML = html;
            menu.style.top = defPosition(evt).y + "px";
            menu.style.left = defPosition(evt).x + "px";
            menu.style.display = "";
        }
        // Блокируем всплывание стандартного браузерного меню
        return false;
    }

    //============================================================================================================//
    // Закрываем контекстное при клике левой или правой кнопкой по документу
    // Функция для добавления обработчиков событий
    function addHandler(object, event, handler, useCapture) {
        if (object.addEventListener) {
            object.addEventListener(event, handler, useCapture ? useCapture : false);
        } else if (object.attachEvent) {
            object.attachEvent('on' + event, handler);
        } else alert("Add handler is not supported");
    }
    addHandler(document, "contextmenu", function () {
        document.getElementById("contextMenuId").style.display = "none";
    });
    addHandler(document, "click", function () {
        document.getElementById("contextMenuId").style.display = "none";
    });
</script>

</body>
</html>