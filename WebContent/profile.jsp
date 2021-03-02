<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/jpg" href="images/icons/icon.jpg">
    <link rel="stylesheet" type="text/css" href="css/dashboard.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/profile.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/profile.js" type="text/javascript"></script>
    <title>Profile updation-Vsoft</title>
</head>
<body>
    <%
      response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

      if(session.getAttribute("email")==null)
      {
        response.sendRedirect("login.html");
      }
    %>
    <div class="task-manager">
    <div class="left-bar">
        <div class="upper-part">
            <div class="logoimg">
                <img src="images/Logo_vsoft-small.jpg" alt="IMG" width="165" height="60">
                <div class="text-center p-t-5"></div>
                <span class="logo-title">Agile Meeting Dashboard</span>       
            </div>
        </div>
        <div class="left-content">
            <ul>
                <li class="nbvred"><a href="dashboard.jsp">Dashboard</a></li>
                <li class="nbvgreen"><a href="meeting-notes.jsp">Meeting Notes</a></li>
                <li class="nbvblue"><a href="profile.jsp">Profile</a></li>
                <li class="nbvorange"><a href="#">About Us</a></li>
            </ul>
        </div>
    </div>
    <div class="page-content">
      <div class="header">
        <i class="fa fa-address-card-o" aria-hidden="true"></i>
        Profile Updation
      </div>
      <div class="profile-class">
      	<!-- <div id="modal-container" class="close-i">
          <div class="modal-background">
            <div class="modal">
              <span class="close-i"><i class="fa fa-times-circle" aria-hidden="true"></i></span>
              <h1>Details are updated Successfully</h1>
            </div>
          </div>
        </div> -->
          <div class="student-details expanded">
                <div class="profile-img">
                    <img src="images/img-01.jpg" width="150" height="150" />
                </div>
                <div class="student-name">Narayanan</div>
          </div>
          <form class="profile-form" > <!--action="Update" method="post"  -->
              <div class="editform-titles edit-profile">
                Edit Profile
                <i class="fa fa-angle-down" aria-hidden="true"></i>
              </div>
              <div class="tab-content edit-profile-form-wrap">
                <div class="wrap-input100">
                  <input class="input100" type="text" id="name" placeholder="First & Last name" required>
                  <span class="focus-input100"></span>
                  <span class="symbol-input100">
                    <i class="fa fa-user" aria-hidden="true"></i>
                  </span>
                </div>
                <div class="wrap-input100 validate-input">
                  <input class="input100" type="text" id="email" placeholder="E-mail" required>
                  <span class="focus-input100"></span>
                  <span class="symbol-input100">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                  </span>
                </div>
                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" id="updateUser">
                      Update
                    </button>
                </div>
              </div>
          </form>
          <form class="profile-form" > <!--action="Updatepass" method="post" -->
              <div class="editform-titles change-password">
                Change Password
                <i class="fa fa-angle-down" aria-hidden="true"></i>
              </div>
              <div class="tab-content change-password-form-wrap">
                <div class="wrap-input100 validate-input">
                  <input class="input100" type="password" id="pass" placeholder="Password" required>
                  <span class="focus-input100"></span>
                  <span class="symbol-input100">
                  <i class="fa fa-lock" aria-hidden="true"></i>
                  </span>
                </div>
                <div id="close-icon" class="container-login100-form-btn">
                  <button class="login100-form-btn" id="updatePassword">
                    Update
                  </button>
              </div>
              </div>
           </form>
      </div>
    </div>
    <div class="right-bar">
        <div class="top-part">
          <div class="username-style">Welcome ${name}</div>
          <div class="count">N</div>
          <form action="Logout">
          	<div class="container-logout-form-btn">
	  		<button class="logout-form-btn" >
	  			Logout
          	</button>
          	</div>
          </form>
        </div>
        <div class="header">Schedule</div>
        <div class="right-content">
        <div class="task-box yellow">
            <div class="description-task">
            <div class="time">08:00 - 09:00 AM</div>
            <div class="task-name">Product Review</div>
            </div>
            <div class="more-button"></div>
            <div class="members">
            <img src="https://images.unsplash.com/photo-1491349174775-aaafddd81942?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=934&q=80" alt="member">
            <img src="https://images.unsplash.com/photo-1476657680631-c07285ff2581?ixlib=rb-1.2.1&auto=format&fit=crop&w=2210&q=80" alt="member-2">
            <img src="https://images.unsplash.com/photo-1496345875659-11f7dd282d1d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80" alt="member-3">
            <img src="https://images.unsplash.com/photo-1455504490126-80ed4d83b3b9?ixlib=rb-1.2.1&auto=format&fit=crop&w=2250&q=80" alt="member-4">
            </div>
        </div>
        <div class="task-box blue">
            <div class="description-task">
            <div class="time">10:00 - 11:00 AM</div>
            <div class="task-name">Design Meeting</div>
            </div>
            <div class="more-button"></div>
            <div class="members">
            <img src="https://images.unsplash.com/photo-1484688493527-670f98f9b195?ixlib=rb-1.2.1&auto=format&fit=crop&w=2230&q=80" alt="member">
            <img src="https://images.unsplash.com/photo-1469334031218-e382a71b716b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80" alt="member-2">
            <img src="https://images.unsplash.com/photo-1455504490126-80ed4d83b3b9?ixlib=rb-1.2.1&auto=format&fit=crop&w=2250&q=80" alt="member-3">
            </div>
        </div>
        <div class="task-box red">
            <div class="description-task">
            <div class="time">01:00 - 02:00 PM</div>
            <div class="task-name">Team Meeting</div>
            </div>
            <div class="more-button"></div>
            <div class="members">
            <img src="https://images.unsplash.com/photo-1491349174775-aaafddd81942?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=934&q=80" alt="member">
            <img src="https://images.unsplash.com/photo-1475552113915-6fcb52652ba2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1934&q=80" alt="member-2">
            <img src="https://images.unsplash.com/photo-1493752603190-08d8b5d1781d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1600&q=80" alt="member-3">
            <img src="https://images.unsplash.com/photo-1484688493527-670f98f9b195?ixlib=rb-1.2.1&auto=format&fit=crop&w=2230&q=80" alt="member-4">
            </div>
        </div>
        <div class="task-box green">
            <div class="description-task">
            <div class="time">03:00 - 04:00 PM</div>
            <div class="task-name">Release Event</div>
            </div>
            <div class="more-button"></div>
            <div class="members">
            <img src="https://images.unsplash.com/photo-1523419409543-a5e549c1faa8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=943&q=80" alt="member">
            <img src="https://images.unsplash.com/photo-1519742866993-66d3cfef4bbd?ixlib=rb-1.2.1&auto=format&fit=crop&w=881&q=80" alt="member-2">
            <img src="https://images.unsplash.com/photo-1521122872341-065792fb2fa0?ixlib=rb-1.2.1&auto=format&fit=crop&w=2208&q=80" alt="member-3">
            <img src="https://images.unsplash.com/photo-1486302913014-862923f5fd48?ixlib=rb-1.2.1&auto=format&fit=crop&w=3400&q=80" alt="member-4">
            <img src="https://images.unsplash.com/photo-1484187216010-59798e9cc726?ixlib=rb-1.2.1&auto=format&fit=crop&w=955&q=80" alt="member-5">
            </div>
        </div>
        <div class="task-box blue">
            <div class="description-task">
            <div class="time">08:00 - 09:00 PM</div>
            <div class="task-name">Release Event</div>
            </div>
            <div class="more-button"></div>
            <div class="members">
            <img src="https://images.unsplash.com/photo-1523419409543-a5e549c1faa8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=943&q=80" alt="member">
            <img src="https://images.unsplash.com/photo-1519742866993-66d3cfef4bbd?ixlib=rb-1.2.1&auto=format&fit=crop&w=881&q=80" alt="member-2">
            <img src="https://images.unsplash.com/photo-1521122872341-065792fb2fa0?ixlib=rb-1.2.1&auto=format&fit=crop&w=2208&q=80" alt="member-3">
            <img src="https://images.unsplash.com/photo-1486302913014-862923f5fd48?ixlib=rb-1.2.1&auto=format&fit=crop&w=3400&q=80" alt="member-4">
            <img src="https://images.unsplash.com/photo-1484187216010-59798e9cc726?ixlib=rb-1.2.1&auto=format&fit=crop&w=955&q=80" alt="member-5">
            </div>
        </div>
        <div class="task-box yellow">
            <div class="description-task">
            <div class="time">11:00 - 12:00 PM</div>
            <div class="task-name">Practise</div>
            </div>
            <div class="more-button"></div>
            <div class="members">
            <img src="https://images.unsplash.com/photo-1491349174775-aaafddd81942?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=934&q=80" alt="member">
            <img src="https://images.unsplash.com/photo-1476657680631-c07285ff2581?ixlib=rb-1.2.1&auto=format&fit=crop&w=2210&q=80" alt="member-2">
            <img src="https://images.unsplash.com/photo-1496345875659-11f7dd282d1d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80" alt="member-3">
            <img src="https://images.unsplash.com/photo-1455504490126-80ed4d83b3b9?ixlib=rb-1.2.1&auto=format&fit=crop&w=2250&q=80" alt="member-4">
            </div>
        </div>
        </div>
    </div>
    </div>
</body>
</html>