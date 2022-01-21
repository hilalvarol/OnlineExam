<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Questions</title>
  <link rel="stylesheet" href="/allQuestion.css">
</head>
<body>
<header>
  <div class="navbar">

    <a id="logout" href="/">Log out</a>
  </div>
</header>
<div class="header">
  <a href="/question/add/${id}" class="addButton">Add new Question </a>
</div>
<div class="container">
  <div class="pack">
    <table class="bTable">
      <tr>
        <th>Question ID</th>
        <th>Question</th>
        <th>Term</th>
        <th>Subject Name</th>
        <th>Action</th>
        <th></th>
      </tr>
      <c:forEach var="question" items="${questions}">
        <tr class="rTable">
          <td>
              ${question.id}
          </td>
          <td>
            <span>${question.question}</span>
            <table>
              <tr>
                <th>Answer ID</th>
                <th>Answers</th>
                <th>Answer Status</th>
              </tr>
              <c:forEach var="answer" items="${answers}">
                <c:if test="${answer.questionId.id==question.id}">
                  <tr>
                    <td> ${answer.id}</td>
                    <td>${answer.answer}</td>
                    <td> ${answer.status}</td>
                  </tr>
                </c:if>
              </c:forEach>
            </table>
          </td>
          <td>${question.examId.examTerm}</td>
          <td>${question.subjectId.name}</td>
          <td class="buttons">
            <a class="updateButton" href="/question/edit/${question.id}" class="replay1">Update</a>
            <a class="updateButton" href="/question/delete/${question.id}" class="replay2">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
</body>
</html>
