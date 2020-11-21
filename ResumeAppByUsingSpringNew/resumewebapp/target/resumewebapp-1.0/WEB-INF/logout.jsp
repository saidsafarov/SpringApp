<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Log out</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" id="bootstrap-css">
</head>
<body>
<div class="cont">
    <center>
        <div class="col-3">
            <h1 class="display-4"
                style="margin-top: 20px; padding-bottom: 10px;">
                Log out</h1>
            <form action="logout" method="POST">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary"
                        style="width: 60%; border-radius: 0;">
                    Log out
                </button>
            </form>
        </div>
    </center>
</div>
</body>
</html>
