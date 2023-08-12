<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Account-Create</title>
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

        @media (max-width: 767px) {
           .form-card {
              height: auto;
           }
        }
            .form-fields {
                margin: 10px 0; /* Add spacing between form fields */
            }

            /* On larger screens, make form fields wider */
            @media (min-width: 768px) {
                .form-fields {
                    min-width: 30vw; /* Adjust the width as needed */
                    margin: 10px auto; /* Center the form fields horizontally */
                }
            }

            @media (max-width: 767px) {
                .form-card {
                    height: 90vh; /* Set form height to 80% of the viewport height on phone screens */
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
                        <h3 class="card-title text-center mb-4">Create Account</h3>
                        <form action="signup" method="post" onsubmit="return validateForm();">
                            <div class="mb-3 form-fields">
                                <label for="username" class="form-label">Username</label>
                                <input name="username" type="text" class="form-control" id="username" required>
                            </div>
                            <div class="mb-3 form-fields">
                                <label for="email" class="form-label">Email</label>
                                <input name="email" type="email" class="form-control" id="email" aria-describedby="emailHelp" required>
                            </div>
                            <div class="mb-3 form-fields">
                                <label for="password" class="form-label">Password</label>
                                <input  name="password" type="password" class="form-control" id="password" required>
                            </div>
                            <div class="mb-3 form-fields">
                                <label for="passwordVerification" class="form-label">Verify Password</label>
                                <input  name="passwordVerification" type="password" class="form-control" id="passwordVerification" required>
                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
                            </div>
                        </form>
                        <div class="alert alert-danger mt-3" id="passwordMismatchAlert" style="display: none;">
                            Passwords do not match. Please verify your password.
                        </div>
                        <div class="alert alert-danger mt-3" id="passwordLengthAlert" style="display: none;">
                            Password must be at least 8 characters long.
                        </div>
                        <div class="text-center mt-3">
                            <p>Already have an account? <a href="../accounts/login">Sign In</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <!-- Return to homepage button -->
    <div class="return-home-button mb4">
        <a href="${pageContext.request.contextPath}" class="btn btn-secondary">Return to Homepage</a>
    </div>

        <script>
        function validateForm() {
            var password = document.getElementById("password").value;
            var passwordVerification = document.getElementById("passwordVerification").value;
            var passwordMismatchAlert = document.getElementById("passwordMismatchAlert");
            var passwordLengthAlert = document.getElementById("passwordLengthAlert");

            if (password !== passwordVerification) {
                passwordMismatchAlert.style.display = "block";
                passwordLengthAlert.style.display = "none";
                return false;
            } else {
                passwordMismatchAlert.style.display = "none";
            }

            if (password.length < 8) {
                passwordLengthAlert.style.display = "block";
                return false;
            } else {
                passwordLengthAlert.style.display = "none";
            }

            return true;
        }

        </script>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>