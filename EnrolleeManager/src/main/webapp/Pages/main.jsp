<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%--<%@ taglib prefix="option" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>--%>


<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>ІС "ВСТУП"</title>--%>
    <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>--%>
    <%--<style type="text/css">--%>
        <%--div.outline {--%>
            <%--width: 100%;--%>
            <%--display: inline-block;--%>
            <%--margin-left: 0;--%>
            <%--margin-top: 0;--%>
        <%--}--%>
        <%--div.inline1 {--%>
            <%--width: 25%;--%>
            <%--display: inline-block;--%>
            <%--margin-left: 0;--%>
            <%--margin-top: 0;--%>
        <%--}--%>
        <%--div.inline2 { width: 40%;--%>
            <%--display: inline-block;--%>
            <%--margin-left: 0;--%>
            <%--margin-top: 0;--%>
        <%--}--%>
        <%--div.block {--%>
            <%--position: absolute;--%>
            <%--top: 650px;--%>
            <%--left: 10px;--%>
        <%--}--%>
    <%--</style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form:form action="#" commandName="abiturient" method="post">--%>
    <%--<H1>Інформаційна система "ВСТУП"(developer version)</H1>--%>
    <%--&lt;%&ndash;<label>${messege}</label>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="outline" >&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="inline1">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<label>Соціальний статус</label>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="inline2">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<spring:select id="socSelector" path="abiturient.socialniyStatus.statusId">&ndash;%&gt;--%>
              <%--&lt;%&ndash;<c:forEach items="${soc}" var="socStatus">&ndash;%&gt;--%>
                 <%--&lt;%&ndash;<option value="${socStatus.statusId}" <c:out value="${socStatus.statusId==abiturient.socStatus.statusId?' selected':''}"></c:out>>&ndash;%&gt;--%>
                   <%--&lt;%&ndash;<c:out value="${socStatus.status}"/>&ndash;%&gt;--%>
                  <%--&lt;%&ndash;</option>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
             <%--&lt;%&ndash;</spring:select>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Номер особової справи</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<spring:input id="os" path="abiturient.osobovaSpravaId"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Прізвище</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<spring:input id="prizv" path="abiturient.prizvishche.prizvishche"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Ім'я</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<spring:input id="imya" path="abiturient.imya.imya" />--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Ім'я по батькові</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<spring:input id="impobatkovi" path="abiturient.imyaPoBatkovi.imyaPoBatkovi" />--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Стать</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<spring:select id="statSelector" path="abiturient.stat.statId">--%>
                <%--<c:forEach items="${stati}" var="stat">--%>
                    <%--<option value="${stat.statId}" <c:out value="${stat.statId==abiturient.stat.statId?' selected':''}"></c:out>>--%>
                        <%--<c:out  value="${stat.nazvaStati}"/>--%>
                    <%--</option>--%>
                <%--</c:forEach>--%>
            <%--</spring:select>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Дата народження</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<form:input type="date" path="birth"/>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
    <%--<label>Номер телефону</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
        <%--&lt;%&ndash;<c:forEach items="${abiturient.abiturient.nomerTelefonus}" var="nomer">&ndash;%&gt;--%>
            <%--<form:input path="nomerTelefonu"/>--%>
        <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
            <%--<button>+*</button>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="outline">--%>
        <%--<label>Дані про атестат абітурієнта</label><br><br>--%>
        <%--<div class="inline1">--%>
            <%--<label>Номер та серія </label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<form:input path="atestat.nomerSeriaAtest"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Середній бал (12-бальна шкала)</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<form:input path="atestat.seredniyBal12"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="outline">--%>
        <%--<div class="inline1">--%>
            <%--<label>Середній бал (200-бальна шкала)</label>--%>
        <%--</div>--%>
        <%--<div class="inline2">--%>
            <%--<form:input path="atestat.seredniyBal200"/>--%>
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



    <%--&lt;%&ndash;================================================================================================================&ndash;%&gt;--%>
    <%--<br><br>--%>
    <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--<button formmethod="POST" formaction="add">Додати абітурієнта</button>--%>
    <%--&nbsp;&nbsp;&nbsp;--%>
    <%--<button formmethod="POST" formaction="update2">Зберегти зміни</button>--%>
    <%--&nbsp;&nbsp;&nbsp;--%>
    <%--<a type="application/file" href="/app_storage/reports/primary.xls" download>Завантажити звіт(.xls)</a>--%>
    <%--&lt;%&ndash;<button onclick="window.location.href='/home/korch/t/test.xls'">Завантажити звіт(.xls)</button>&ndash;%&gt;--%>


    <%--&lt;%&ndash;<h2>Довідкові дані</h2>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<select id="sel"&lt;%&ndash; onchange="changeVisible(this)&ndash;%&gt;">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<option class="block1" value="1">Дисципліни ЗНО</option>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<option class="block2" value="2">Спеціальності</option>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<option class="block3" value="3">Квота по спеціальностям</option>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</select>&ndash;%&gt;--%>



    <%--&lt;%&ndash;<div id="infoBlock">&ndash;%&gt;--%>

        <%--&lt;%&ndash;<div class="block1" id="1" style="visibility: hidden">&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;<label>Назва дисципліни</label>&ndash;%&gt;&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;<form:input path=""/>&ndash;%&gt;&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="block2" id="2" style="visibility: hidden">&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;<label>Назва спеціальності</label>&ndash;%&gt;&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="block3" id="3" style="visibility: hidden">&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;<h1>3</h1>&ndash;%&gt;&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<p>${d}</p>&ndash;%&gt;--%>


    <%--&lt;%&ndash;----------------------------------SHOW TABLE-------------------------------------------------------------------&ndash;%&gt;--%>
<%--</form:form>--%>

<%--<hr>--%>

<%--<form:form action="#" commandName="infoDateCase" method="post">--%>

    <%--&lt;%&ndash;<h2>Довідкові дані</h2>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<select id="sel"&lt;%&ndash; onchange="changeVisible(this)&ndash;%&gt;">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<option class="block1" value="1">Дисципліни ЗНО</option>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<option class="block2" value="2">Спеціальності</option>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<option class="block3" value="3">Квота по спеціальностям</option>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</select>&ndash;%&gt;--%>

    <%--<div id="infoBlock">--%>
        <%--<div>--%>
            <%--<labe>Назва дисципліни</labe>--%>
            <%--<form:input path="discipline.nazvaDiscipline"></form:input>--%>
        <%--</div>--%>
        <%--<div>--%>
            <%--<label>Назва спеціальності</label>--%>
            <%--<form:input path="specialnist.specialnist"></form:input>--%>
            <%--<label>Абривіатура спеціальності</label>--%>
            <%--<form:input path="specialnist.abriviatura"></form:input>--%>
        <%--</div>--%>
        <%--<div>--%>
            <%--<label>Кількість держ.замовлення відповідно до квоти</label>--%>
            <%--&lt;%&ndash;<form:select path=""&ndash;%&gt;--%>
        <%--</div>--%>
        <%--&lt;%&ndash;<form:input path="discipline.disciplineId"></form:input>&ndash;%&gt;--%>
    <%--</div>--%>

<%--</form:form>--%>

<%--<div style="position: relative">--%>
<%--<spring:form cssStyle="position: relative">--%>
    <%--<table oncontextmenu="menu(event)" border="1" cellpadding="4" cellspacing="0">--%>
        <%--<tr>--%>
            <%--<th>Номер особової справи</th>--%>
            <%--<th>Соціальний статус</th>--%>
            <%--<th>Прізвище</th>--%>
            <%--<th>Ім'я</th>--%>
            <%--<th>По батькові</th>--%>
            <%--<th>Дата народження</th>--%>
            <%--<th>Номер телефону</th>--%>
            <%--<th>Серія і номер</th>--%>
            <%--<th>Бал (12)</th>--%>
            <%--<th>Бал (200) </th>--%>
            <%--<th>Дата видачі</th>--%>
            <%--<th>Час реєстрації</th>--%>
        <%--</tr>--%>
        <%--<c:forEach  items="${abiturients}" var="abitur">--%>
            <%--<tr oncontextmenu="return menu('${abitur.id}', event)" id="string">--%>
                <%--<th><c:out value="${abitur.osobovaSpravaId}"/></th>--%>
                <%--<th><c:out value="${abitur.socialniyStatus.status}"/></th>--%>
                <%--<th><c:out value="${abitur.prizvishche.prizvishche}"/></th>--%>
                <%--<th><c:out value="${abitur.imya.imya}"/></th>--%>
                <%--<th><c:out value="${abitur.imyaPoBatkovi.imyaPoBatkovi}"/></th>--%>
                <%--<th><c:out value="${abitur.formatedDN}"/></th>--%>
                <%--<c:if test="${abitur.nomerTelefonus.size()>0}">--%>
                    <%--<th><c:out value="${abitur.nomerTelefonus.get(0).nomer}"/></th>--%>
                <%--</c:if>--%>
                <%--<c:if test="${abitur.atestats.size()>0}">--%>
                    <%--<th><c:out value="${abitur.atestats.get(0).nomerSeriaAtest}"/></th>--%>
                    <%--<th><c:out value="${abitur.atestats.get(0).seredniyBal12}"/></th>--%>
                    <%--<th><c:out value="${abitur.atestats.get(0).seredniyBal200}"/></th>--%>
                    <%--<th><c:out value="${abitur.atestats.get(0).formatedDate}"/></th>--%>
                <%--</c:if>--%>
                <%--<th><c:out value="${abitur.formatedChreg}"/></th>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>

    <%--<div id="contextMenuId" style="position:absolute; top:0; left:0; border:1px solid #666; background-color:white; display:none; float:left;"></div>--%>
<%--</spring:form>--%>
<%--</div>--%>


<%--&lt;%&ndash;----------------------------------------------------------------------------------------------------------------&ndash;%&gt;--%>
<%--&lt;%&ndash;-----------------------------JAVA_SCRIPT------------------------------------------------------------------------&ndash;%&gt;--%>
<%--&lt;%&ndash;----------------------------------------------------------------------------------------------------------------&ndash;%&gt;--%>

    <%--<script>--%>

        <%--&lt;%&ndash;$(document).ready(function(){&ndash;%&gt;--%>
            <%--&lt;%&ndash;$('#sel').change(function(){&ndash;%&gt;--%>
                <%--&lt;%&ndash;if ($('#sel option:selected').hasClass("block1")) {&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$('#infoBlock').HTML("<input value="${discipline.nazvaDiscipline}"></input>";);&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;//                        "<label>Назва дисципліни<label>" +&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;&lt;%&ndash;"<form:input path="discipline.nazvaDiscipline"></form:input>");&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;&lt;%&ndash;"<form:button formmethod='POST' formaction='add'>Додати абітурієнта</form:button>");&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;} else if ($("#sel option:selected").hasClass("block2")) {&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$("#infoBlock").html("<h1>Hello block2</h1>");&ndash;%&gt;--%>
                <%--&lt;%&ndash;} else if ($('#sel option:selected').hasClass("block3")) {&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$("#infoBlock").html("<input type='text' name='type' value='Ищу водителя / исполнителя'>");&ndash;%&gt;--%>
                <%--&lt;%&ndash;} /*else if ($('#sel option:selected').hasClass("sel4")) {&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$("#infoBlock").html("<input type='text' name='type' value='Отдам заказ / Ищу исполнителя'>");&ndash;%&gt;--%>
                <%--&lt;%&ndash;}*/&ndash;%&gt;--%>
            <%--&lt;%&ndash;});&ndash;%&gt;--%>
        <%--&lt;%&ndash;});&ndash;%&gt;--%>
<%--//        function changeVisible(obj) {--%>
<%--//            for (var i = 0; i < $('#base').find('.block').length; i++){--%>
<%--//                if (obj.options[obj.selectedIndex].value-1 == i) {--%>
<%--//                    document.getElementById(i+1).style.visibility= 'visible';--%>
<%--//                    continue;--%>
<%--//                } else {--%>
<%--//                    document.getElementById(i+1).style.visibility= 'hidden';--%>
<%--//                }--%>
<%--//            }--%>
<%--//        }--%>

        <%--//===Удалить/Обновить==========================================================================================//--%>
        <%--var temp;--%>
        <%--function  deleteAbiturient(temp) {--%>
            <%--$.ajax ({--%>
                <%--url: "delete",--%>
                <%--type: "POST",--%>
                <%--data: temp,--%>
                <%--contentType: "application/json"--%>
            <%--});--%>
        <%--}--%>
        <%--function  updateAbiturient(temp) {--%>
            <%--$.ajax ({--%>
                <%--url: "update",--%>
                <%--type: "POST",--%>
                <%--data: temp,--%>
                <%--contentType: "application/json"--%>
            <%--});--%>
        <%--}--%>

        <%--//===Собсвенное контекстное меню==============================================================================//--%>
        <%--$.document--%>
        <%--function defPosition(event) {--%>
            <%--var x = y = 0;--%>
            <%--if (document.attachEvent != null) {--%>
                <%--x = window.event.clientX + (document.documentElement.scrollLeft ? document.documentElement.scrollLeft : document.body.scrollLeft);--%>
                <%--y = window.event.clientY + (document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop);--%>
            <%--} else if (!document.attachEvent && document.addEventListener) { // Gecko--%>
                <%--x = event.clientX + window.scrollX;--%>
                <%--y = event.clientY + window.scrollY;--%>
            <%--} else {--%>
                <%--// Do nothing--%>
            <%--}--%>
            <%--return {x:x, y:y};--%>
        <%--}--%>

        <%--function menu(abiturient, evt) {--%>
            <%--temp = abiturient;--%>

            <%--// Блокируем всплывание события contextmenu--%>
            <%--evt = evt || window.event;--%>
            <%--evt.cancelBubble = true;--%>
            <%--// Показываем собственное контекстное меню--%>
            <%--var menu = document.getElementById("contextMenuId");--%>
            <%--var html = "";--%>
            <%--html += "<br><label onclick=\"deleteAbiturient(temp)\">Видалити</label>";--%>
            <%--html += "<br><label onclick=\"updateAbiturient(temp)\">Редагувати</label>";--%>

            <%--if (html) {--%>
                <%--menu.innerHTML = html;--%>
                <%--menu.style.top = defPosition(evt).y + "px";--%>
                <%--menu.style.left = defPosition(evt).x + "px";--%>
                <%--menu.style.display = "";--%>
            <%--}--%>
            <%--// Блокируем всплывание стандартного браузерного меню--%>
            <%--return false;--%>
        <%--}--%>

        <%--//============================================================================================================//--%>
        <%--// Закрываем контекстное при клике левой или правой кнопкой по документу--%>
        <%--// Функция для добавления обработчиков событий--%>
        <%--function addHandler(object, event, handler, useCapture) {--%>
            <%--if (object.addEventListener) {--%>
                <%--object.addEventListener(event, handler, useCapture ? useCapture : false);--%>
            <%--} else if (object.attachEvent) {--%>
                <%--object.attachEvent('on' + event, handler);--%>
            <%--} else alert("Add handler is not supported");--%>
        <%--}--%>
        <%--addHandler(document, "contextmenu", function() {--%>
            <%--document.getElementById("contextMenuId").style.display = "none";--%>
        <%--});--%>
        <%--addHandler(document, "click", function() {--%>
            <%--document.getElementById("contextMenuId").style.display = "none";--%>
        <%--});--%>
    <%--</script>--%>

<%--</body>--%>
<%--</html>--%>