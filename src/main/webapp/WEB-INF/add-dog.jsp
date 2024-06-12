<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add dog</title>
    <%@include file="bootstrap.html"%>
</head>
<body>

<br/>

    <div class="col-6 offset-2 rounded text-bg-dark p-3">
        <form method="post" action="${pageContext.request.contextPath}/dog/add-dog">
                <legend>Ajouter un chien</legend>
            <div class="mb-3">
                <label for="name" class="form-label">Nom :</label>
                <input type="text" class="form-control" name="name" id="name" required>
            </div>
            <div class="mb-3">
                <label for="breed" class="form-label">Race :</label>
                <input type="text" class="form-control" name="breed" id="breed" required>
            </div>
            <div class="mb-3">
                <label for="dateOfBirth" class="form-label">Date de naissance :</label>
                <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" required>
            </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-outline-success">Ajouter</button>
                </div>

        </form>
    </div>

</body>
</html>