<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>
<html>
  <body>
    <h1>Person List</h1>

    <br/><br/>
    <div>
      <table border="1">
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
        </tr>
        <c:forEach  items="${employees}" var ="employee">
        <tr>
          <td>${employee.firstName}</td>
          <td>${employee.lastName}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </body>

</html>