<%--
  Created by IntelliJ IDEA.
  User: hilal varol
  Date: 19.01.2022
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Exams</title>
  <link rel="stylesheet" href="/panelExam.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Rajdhani&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>

<body>
<header>
  <div class="navbar">
    <a id="logout" href="/">Log out</a>
  </div>
</header>
<div class="package">
  <div class="container">
    <a id="add" href="/exam/add/${id}">Add new Exam</a>
    <div class="pack">
      <table>
        <tr>
          <th>Subject Name</th>
          <th>Exam Date</th>
          <th>Exam Duration</th>
          <th>Exam term</th>
          <th>Action</th>
        </tr>
        <c:forEach var="exam" items="${exams}">
          <tr>
            <c:forEach var="subject" items="${subjects}">
              <c:if test="${exam.subjectId.id==subject.id}">
                <td>${subject.name}</td>
              </c:if>
            </c:forEach>
            <td>${exam.examDate}</td>
            <td>${exam.duration}</td>
            <td>${exam.examTerm}</td>
            <td>
            <a id="delete" href="/exam/delete/${exam.id}" class="replay2">Delete</a>
            <a id="question" href="/exam/question/${exam.subjectId.id}" class="replay3">Questions</a></td>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</div>
</body>
</html>