$(document).ready(function() { 

    // Hover effects
    $('.table-responsive tr').hover(
	    function(){
	        $(this).find('.table-action').stop().fadeTo(200,1);
	    },
	    function(){
	         $(this).find('.table-action').stop().fadeTo(200,0.1);
	    });
});

$(document).on("click", "#edit_button", function(e) {
	var $row = $(this).closest('tr');
	var userId = $row.find('#input_id_edit').html();
	var userName = $row.find('#input_name_edit').html();
	var userEmail = $row.find('#input_email_edit').html();
	var userDepartment = $row.find('#input_department_edit').html();
	var userOffice = $row.find('#input_office_edit').html();
	var allHours = $row.find('#hoursField_edit').html();
	
	if (userId) {
		$.ajax(
			{
				type : "POST",
				url  : "/cs480/user/" + userId,
				data : {
					"name" : userName,
					"email" : userEmail,
					"department" : userDepartment,
					"office" : userOffice,
					"officeHours" : allHours
				},
				success : function(result) {
					location.reload();
				},
				error: function (jqXHR, exception) {
					alert("Failed to add the user. Please check the inputs.");
				}
			});
	} else {
		alert("Invalid user Id");
	}
});