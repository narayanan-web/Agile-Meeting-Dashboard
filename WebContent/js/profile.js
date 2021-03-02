$(document).ready(function(){
    var profileStates = {
        editProfile: false,
        changePassword: false,
        showDetails: true
      };
      
      $(".editform-titles").on("click", function (e) {
        e.stopPropagation();
        tabHandler(e.currentTarget);
      });
      
      $(".cancel").on("click", function (e) {
        e.stopPropagation();
        e.preventDefault();
        pageReset();
      });
      
      function tabHandler(tab) {
        var editProfileTab = $(tab).hasClass("edit-profile");
        var changePassTab = $(tab).hasClass("change-password");
      
        switch (true) {
          // if Tab is Edit Profile and Edit Profile is not showing
          case editProfileTab && !isEditProfileShowing():
            // Check to see if Profile Details are showing. Hide if they are.
            if (isDetailsShowing()) {
              profileStates.showDetails = false;
              $(".student-details").removeClass("expanded");
            }
      
            // Remove .expanded from all content wrappers
            $(".tab-content").removeClass("expanded");
      
            // Add .expanded to edit profile content wrapper
            $(".edit-profile-form-wrap").addClass("expanded");
      
            profileStates.editProfile = true;
            profileStates.changePassword = false;
            break;
      
          // if Tab is Change Password and Detail is Showing
          case changePassTab && !isChangePasswordShowing():
            // Check to see if Profile Details are showing. Hide if they are.
            if (isDetailsShowing()) {
              profileStates.showDetails = false;
              $(".student-details").removeClass("expanded");
            }
      
            // Remove .expanded from all content wrappers
            $(".tab-content").removeClass("expanded");
      
            // Add .expanded to edit profile content wrapper
            $(".change-password-form-wrap").addClass("expanded");
            profileStates.editProfile = false;
            profileStates.changePassword = true;
            break;
      
          // if Tab is Edit Profile and Edit Profile is Showing
          case editProfileTab && isEditProfileShowing():
            pageReset();
            break;
          // if Tab is Change Password and Change Password is Shwoing
          case changePassTab && isChangePasswordShowing():
            pageReset();
            break;
        }
      }
      
      // Reset page to default state
      function pageReset() {
        $(".tab-content").removeClass("expanded");
        $(".student-details").addClass("expanded");
        profileStates.showDetails = true;
        profileStates.editProfile = false;
        profileStates.changePassword = false;
      }
      
      // Check to see if Student Details are being shown
      function isDetailsShowing() {
        return profileStates.showDetails;
      }
      
      // Check to see if Change Password form is showing
      function isChangePasswordShowing() {
        return profileStates.changePassword;
      }
      
      // Check to see if Edit Profil form is showing
      function isEditProfileShowing() {
        return profileStates.editProfile;
      }

 // POP UP ACTION 
	$("#updateUser").click(function () {
		var name=$("#name").val();
		var email=$('#email').val();
		$.ajax({
			url : 'Update',
			type: 'post',
			data : {name : name, email : email},
			dataType:"json",
			});
			alert("User Details are updated Successfully");
		});



    $("#updatePassword").click(function () {
        //var buttonId = $(this).attr("id");
		var pass=$("#pass").val();

		//alert(pass);
		$.ajax({
			url : 'Updatepass',
			type: 'post',
			data : {pass : pass},
			dataType:"json",
			success: function(){
				//alert("working")
			/*if(data>0)
			{
		        alert(data)
			}*/
			},
			
			error : function(error)
			{
				console.log(error);
				alert("Not work");
			}
		});
				//event.preventDefault();
				alert("Password is updated Successfully");
    });
/*	$(".login100-form-btn").click(function () {
        var buttonId = $(this).attr("id");
				$("#modal-container").removeAttr("class").addClass(buttonId);
	 			$(".page-content").addClass("modal-active");
    });
    $("#modal-container").click(function () {
        $(this).addClass("out");
        $(".page-content").removeClass("modal-active");
    });

*/
  });