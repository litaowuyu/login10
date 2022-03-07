<%--
  Created by IntelliJ IDEA.
  User: 李涛
  Date: 2022/3/4
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登陆</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <style>
        .bd-example {
            position: relative;
            padding: 1rem;
            margin: 1rem -1.25rem 0;
            border: solid #dee2e6;
            border-width: 1px 0 0;
        }

        @media (min-width: 576px) {
            .bd-example {
                padding: 1.5rem;
                margin-right: 0;
                margin-left: 0;
                border-width: 1px;
                border-top-left-radius: 0.25rem;
                border-top-right-radius: 0.25rem;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <div class="bd-example">
        <div class="row mb-3">
            <label for="inputEmail3" class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" name="username"/>
            </div>
        </div>
        <div class="row mb-3">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" name="password"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary" id="loginButton">Login in</button>
    </div>
</div>
</body>
</html>
<script>
    $(function () {
        $('#loginButton').click(function () {
            let username = $('#inputEmail3').val();
            let password = $('#inputPassword3').val();
            let datas = {
                "username": username,
                "password": password
            };
            let finalDatas = JSON.stringify(datas);
            console.log(finalDatas);
            $.ajax({
                url: "${pageContext.request.contextPath}/loginDo",
                data: finalDatas,
                contentType: "application/json;charset=UTF-8",
                type: 'POST',
                success: function (data) {
                    console.log(data);
                    if (data.code == '0') {
                        alert(data.message);
                    } else {
                        alert(data.message);
                    }
                }
            });
        });
    });
</script>
