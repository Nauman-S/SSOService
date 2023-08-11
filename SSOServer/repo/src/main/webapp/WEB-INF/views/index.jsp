<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SSO Server Home</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }
        .sso-message {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .sso-description {
            font-size: 18px;
            color: #6c757d;
            text-align: center;
        }
        .btn-wrapper {
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .or-text {
            margin: 10px 0;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="sso-message">Welcome to the SSO Server</div>
        <div class="sso-description">This server provides secure authentication services to other websites.</div>
        <div class="btn-wrapper">
            <a href="${pageContext.request.contextPath}/accounts/signup" class="btn btn-primary">Create Account</a>
            <p class="or-text">or</p>
            <a href="${pageContext.request.contextPath}/accounts/login" class="btn btn-primary">Sign In</a>
        </div>
    </div>
</body>
</html>
