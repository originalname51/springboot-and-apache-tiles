<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>
<html>

<body>
<h1>Create a Person:</h1>

<!--
         In Thymeleaf the equivalent of
         JSP's ${pageContext.request.contextPath}/edit.html
         would be @{/edit.html}
         -->

      <form th:action="${pageContext.request.contextPath}/addPerson"
         th:object="${personForm}" method="POST">
         First Name:
         <input type="text" th:field="*{firstName}" />
         <br/>
         Last Name:
         <input type="text" th:field="*{lastName}" />
         <br/>
         <input type="submit" value="Create" />
      </form>

<br/>

<!-- Check if errorMessage is not null and not empty -->

<div th:if="${errorMessage}" th:utext="${errorMessage}"
     style="color:red;font-style:italic;">
   ...
</div>

</body>

</html>