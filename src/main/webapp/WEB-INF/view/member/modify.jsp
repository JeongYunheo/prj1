<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>

<c:import url="/WEB-INF/fragment/navbar.jsp"/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">

            <h3 class="mb-4">회원정보 수정</h3>

            <form action="/member/modify" method="post" onsubmit="return confirm('정보를 수정하겠습니까?')">
                <input type="hidden" name="id" value="${member.id}">
                <div class="mb-3">
                    <label for="inputEmail" class="form-label">이메일</label>
                    <input id="inputEmail" type="email" class="form-control-plaintext" readonly value="${member.email}">
                </div>
                <div class="mb-3">
                    <label for="inputPassword" class="form-label">패스워드</label>
                    <input oninput="passwordCheck()" id="inputPassword" type="password" class="form-control"
                           name="password"
                           value="${member.password}">
                </div>
                <div class="mb-3">
                    <label for="inputPasswordCheck" class="form-label">패스워드</label>
                    <input oninput="passwordCheck()" id="inputPasswordCheck" type="password" class="form-control"
                           value="${member.password}">
                    <div id="passwordMessage" class="form-text"></div>
                </div>
                <div class="mb-3">
                    <label for="inputNickName" class="form-label">닉네임</label>
                    <input id="inputNickName" type="text" class="form-control" name="nickName"
                           value="${member.nickName}">
                </div>
                <div>
                    <button class="btn btn-secondary">저장</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function passwordCheck() {
        const password = document.querySelector("#inputPassword").value;
        const passwordCheck = document.querySelector("#inputPasswordCheck").value;

        if (password == passwordCheck) {
            document.querySelector("#passwordMessage").textContent = ""
        } else {
            document.querySelector("#passwordMessage").textContent = "패스워드가 일치하지 않습니다"
        }
    }
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
