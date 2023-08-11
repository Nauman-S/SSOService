<%@page isELIgnored="false" %>
<%@page import="groupELstupido.sso.domain.model.* "%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <!-- Link Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .logout-button {
            margin-top: 20px;
        }
        @media (min-width: 768px) {
            .logout-button {
                position: absolute;
                bottom: 0;
                right: 0;
                margin: 20px;
            }
	}
    </style>
</head>
<body>
            <%
                  UserDisplay user = (UserDisplay) request.getAttribute("userDisplay");
            %>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-4">
<!-- User Profile Card -->
                <div class="card">
                    <img src="profile-image.jpg" class="card-img-top profile-image" alt="User Profile Image" data-bs-toggle="modal" data-bs-target="#profileImageModal">
                    <div class="card-body">
                        <h5 class="card-title">${user.getUsername()} </h5>

                    </div>
                </div>
                <!-- List of Friends -->
                <div class="card mt-3">
                    <div class="card-body">
                        <h5 class="card-title">Friends</h5>
                        <ul class="list-group" id="friendList">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Jane Smith
                                <button class="btn btn-sm btn-danger" onclick="removeFriend(this)">Remove</button>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Michael Johnson
                                <button class="btn btn-sm btn-danger" onclick="removeFriend(this)">Remove</button>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Emily Williams
                                <button class="btn btn-sm btn-danger" onclick="removeFriend(this)">Remove</button>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                David Brown
                                <button class="btn btn-sm btn-danger" onclick="removeFriend(this)">Remove</button>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- Add Friend Button -->
                <button class="btn btn-primary mt-3" data-bs-toggle="modal" data-bs-target="#addFriendModal">Add Friend</button>
            </div>
            <div class="col-md-8">
                <!-- User Profile Details -->
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Profile Details</h5>
                        <p class="card-text"><strong>Email:</strong> ${user.getEmail()}</p>
                        <p class="card-text"><strong>Location:</strong> New York, USA</p>
                        <p class="card-text"><strong>Bio:</strong> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ac purus sit amet odio tristique scelerisque vel et ex.</p>
                    </div>
                </div>
		<!-- Logout Button -->
                <button class="btn btn-danger mt-3 logout-button" data-bs-toggle="modal" data-bs-target="#logoutModal">Logout</button>
            </div>
        </div>
    </div>

    <!-- Add Friend Modal -->
    <div class="modal fade" id="addFriendModal" tabindex="-1" aria-labelledby="addFriendModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addFriendModalLabel">Add New Friend</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="addFriendForm">
                        <div class="mb-3">
                            <label for="friendName" class="form-label">Friend's Name</label>
                            <input type="text" class="form-control" id="friendName" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Add Friend</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Logout Modal -->
    <div class="modal fade" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="logoutModalLabel">Logout Confirmation</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Are you sure you want to log out?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Stay Logged In</button>
                    <button type="button" class="btn btn-danger" onclick="logout()">Logout</button>
                </div>
            </div>
        </div>
    </div>
<!-- Profile Image Modal -->
    <div class="modal fade" id="profileImageModal" tabindex="-1" aria-labelledby="profileImageModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="profileImageModalLabel">Profile Image Options</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                    <img src="profile-image.jpg" class="img-fluid mb-3" alt="User Profile Image">
		<div>
                    <button class="btn btn-primary mb-2" data-bs-toggle="modal" data-bs-target="#uploadImageModal" data-bs-dismiss="modal">Upload New Image</button>
                    <button class="btn btn-danger" onclick="deleteImage()" data-bs-dismiss="modal">Delete Image</button>
		</div>
                </div>
            </div>
        </div>
    </div>

    <!-- Link Bootstrap JS and Popper.js (required for Bootstrap components) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Logout Function -->
    <script>
        function logout() {
            // Add your logout logic here
            alert('Logged out successfully');
        }

        function removeFriend(button) {
            const listItem = button.parentElement;
            listItem.remove();
        }

        // Add Friend Form Submission
        document.getElementById("addFriendForm").addEventListener("submit", function(event) {
            event.preventDefault();
            const friendName = document.getElementById("friendName").value;
            addFriend(friendName);
            document.getElementById("friendName").value = "";
            $('#addFriendModal').modal('hide');
        });

        function addFriend(name) {
            const friendList = document.getElementById("friendList");
            const listItem = document.createElement("li");
            listItem.className = "list-group-item d-flex justify-content-between align-items-center";
            listItem.innerHTML = `
                ${name}
                <button class="btn btn-sm btn-danger" onclick="removeFriend(this)">Remove</button>
            `;
            friendList.appendChild(listItem);
        }
    </script>
</body>
</html>
