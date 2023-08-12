<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css">
    <title>Error Page</title>
    <style>
        .error-container {
            text-align: center;
            margin-top: 100px;
        }
        .error-message {
            font-size: 24px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-container">
            <h1 class="error-message">Something went wrong</h1>
            <h3>${msg}</h3>
            <p>We apologize for the inconvenience. Please try again later.</p>
            <a href="${pageContext.request.contextPath}" class="btn btn-primary">Return to Homepage</a>
        </div>
    </div>
</body>
</html>
