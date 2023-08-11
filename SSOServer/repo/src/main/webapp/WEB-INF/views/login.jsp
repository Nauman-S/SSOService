<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <!-- Link Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .profile-image {
            border-radius: 50%;
            cursor: pointer;
        }
        .form-card {
            margin: 0 auto; /* Center the form horizontally */
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .form-fields {
            margin: 10px 0; /* Add spacing between form fields */
        }

        /* On larger screens, make form fields wider */
        @media (min-width: 768px) {
            .form-fields {
                min-width: 40vw; /* Adjust the width as needed */
                margin: 10px auto; /* Center the form fields horizontally */
            }
        }

        @media (max-width: 767px) {
            .form-card {
                height: 80vh; /* Set form height to 80% of the viewport height on phone screens */
            }
        }

	    /* Style for the return-to-home button */
        .return-home-button {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card form-card">
                    <div class="card-body">
                        <h3 class="card-title text-center mb-4">Sign In</h3>
                        <form action="../accounts/login" method="post">
                            <div class="mb-3 form-fields">
                                <label for="usernameOrEmail" class="form-label">Username or Email</label>
                                <input name="identifier" type="text" class="form-control" id="usernameOrEmail" required>
                            </div>
                            <div class="mb-3 form-fields">
                                <label for="password" class="form-label">Password</label>
                                <input  name="password" type="password" class="form-control" id="password" required>
                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">Sign In</button>
                            </div>
                        </form>
                        <div class="text-center mt-3">
                            <p><a href="#">Forgot Password?</a></p>
                            <p>Don't have an account? <a href="../accounts/signup">Sign Up</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <!-- Return to homepage button -->
    <div class="return-home-button">
        <a href="${pageContext.request.contextPath}" class="btn btn-secondary">Return to Homepage</a>
    </div>

    <!-- Link Bootstrap JS and Popper.js (required for Bootstrap components) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
