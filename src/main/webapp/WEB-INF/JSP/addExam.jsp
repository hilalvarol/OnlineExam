<%--
  Created by IntelliJ IDEA.
  User: hilal varol
  Date: 19.01.2022
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Exam</title>
    <link rel="stylesheet" href="/addExam.css">
</head>
<body>
<div class="container">
    <h2> Exam</h2>
    <form action="/exam/add" method="post">
        <h3>Exam term</h3>
        <div class="term">
            <label for="midterm">Midterm</label>
            <input type="radio" name="term" value="midterm" id="midterm" checked required>
            <label for="final">Final</label>
            <input type="radio" name="term" value="final" id="final" required>
        </div>
        <label for="examDuration">Exam Duration</label>
        <select name="examDuration" id="examDuration">
            <c:forEach var="value" begin="1" end="60">
                <option value="${value}">${value}</option>
            </c:forEach>
        </select><br>
        <label for="subject">Subject</label>
        <select name="subject" id="subject">
            <c:forEach items="${subjects}" var="subject">
                <option value="${subject.id}">${subject.name}</option>
            </c:forEach>
        </select><br>
        <label for="examDate">Exam Date</label>
        <input class="datePicker" type="datetime-local" name="examDate" id="examDate" required><br>
        <input class="button" type="submit" value="Add Exam" name="submit"/>
    </form>
</div>
</body>
</html>
