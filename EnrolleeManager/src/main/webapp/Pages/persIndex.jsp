<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="option" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: korch
  Date: 30.05.17
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
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
        div.inline2 { width: 40%;
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
    <spring:form action="#" commandName="person" method="post">
        <H1>Інформаційна система "ВСТУП"(developer version)</H1>
        <div class="outline" >
            <div class="inline1">
                <label>Соціальний статус</label>
            </div>
            <div class="inline2">
                <spring:select id="socSelector" path="status.id">
                    <c:forEach items="${statuses}" var="status">
                        <option value="${status.id}" <c:out value="${status.id==abiturient.status.id?' selected':''}"></c:out>>
                            <c:out value="${status.name}"/>
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
                <spring:input id="os" path="sprava"/>
            </div>
        </div>
        <div class="outline">
            <div class="inline1">
                <label>Прізвище</label>
            </div>
            <div class="inline2">
                <spring:input id="prizv" path="prizvishche.name"/>
            </div>
        </div>
        <div class="outline">
            <div class="inline1">
                <label>Ім'я</label>
            </div>
            <div class="inline2">
                <spring:input id="imya" path="imya.name" />
            </div>
        </div>
        <div class="outline">
            <div class="inline1">
                <label>Ім'я по батькові</label>
            </div>
            <div class="inline2">
                <spring:input id="impobatkovi" path="imyaPoBatkovi.name" />
            </div>
        </div>

        <div class="outline">
            <div class="inline1">
                <label>Стать</label>
            </div>
            <div class="inline2">
                <spring:select id="statSelector" path="stat.id">
                    <c:forEach items="${stati}" var="stat">
                        <option value="${stat.id}" <c:out value="${stat.id==abiturient.stat.id?' selected':''}"></c:out>>
                            <c:out  value="${stat.name}"/>
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
                <spring:input type="date" path="birth"/>
            </div>
        </div>

        <div class="outline">
        <div class="inline1">
        <label>Номер телефону</label>
        </div>
        <div class="inline2">
        <%--<c:forEach items="${abiturient.abiturient.nomerTelefonus}" var="nomer">--%>
        <form:input path="nomerTelefonus.nomer"/>
        <%--</c:forEach>--%>
        <button>+*</button>
        </div>
        </div>

        <%--<div class="outline">--%>
            <%--<label>Дані про атестат абітурієнта</label><br><br>--%>
            <%--<div class="inline1">--%>
                <%--<label>Номер та серія </label>--%>
            <%--</div>--%>
            <%--<div class="inline2">--%>
                <%--<spring:input path="atestat.nomerSeria"/>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="outline">--%>
            <%--<div class="inline1">--%>
                <%--<label>Середній бал (12-бальна шкала)</label>--%>
            <%--</div>--%>
            <%--<div class="inline2">--%>
                <%--<spring:input path="atestat.average12"/>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="outline">--%>
            <%--<div class="inline1">--%>
                <%--<label>Середній бал (200-бальна шкала)</label>--%>
            <%--</div>--%>
            <%--<div class="inline2">--%>
                <%--<spring:input path="atestat.average200"/>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="outline">
            <div class="inline1">
                <label>Дата видачі</label>
            </div>
            <div class="inline2">
                <spring:input path="atestat.dataVidachi"/>
            </div>
        </div>



        <%--================================================================================================================--%>
        <br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button formmethod="POST" formaction="add">Додати абітурієнта</button>

    </spring:form>
</body>
</html>
