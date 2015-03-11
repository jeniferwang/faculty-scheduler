var shown = false;

function healthCheck() {
	$.ajax(
			{
				type : "GET",
				url  : "/cs461/ping",
				data : {
				},
				success : function(result) {
					$('#status').text(result);
					console.log('test');
				},
				error: function (jqXHR, exception) {
					$('#status').text("Failed to get the status");
				}
			});
}

function showUserList() {
	$(".user-list-toggle").slideToggle( "slow" );
	if(shown ==  true) {
		$("#user-list-button").text('Show');
		shown = false;
	}
	else {
		$("#user-list-button").text('Hide');
		shown = true;
	}
}


function deleteUser(userId) {
	$.ajax(
		{
			type : "DELETE",
			url  : "/cs461/user/" + userId,
			data : {
			},
			success : function(result) {
				location.reload();
			},
			error: function (jqXHR, exception) {
				alert("Failed to delete the user.");
			}
		});
}

function addUser() {
	var userId = $('#input_id').val();
	var userName = $('#input_name').val();
	var userEmail = $('#input_email').val();
	var userDepartment = $('#input_department').val();
	var userOffice = $('#input_office').val();
	var allHours = "";
	var intId = 0;
	
	$("#hoursField div").each(function() {
		var id = "input" + $(this).attr("id").replace("input_field","");
		allHours = allHours + $(this).find("input").val() + "<br>";
	});
	
	if (userId) {
		$.ajax(
			{
				type : "POST",
				url  : "/cs461/user/" + userId,
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
}

function addEntry() {
	var intId = $("#hoursField div").length + 1;
	var fieldWrapper = $("<div class=\"fieldwrapper\" style=\"padding-bottom:10px\" class=\"form-control\" id=\"input_field" + intId + "\"/>");
	var hours = $("<input type=\"text\" class=\"field" + intId + "\"/>");
	
	fieldWrapper.append(hours);
	$("#hoursField").append(fieldWrapper);
}

function removeEntry() {
	var lastElement = $("#hoursField div").length;
	$("#hoursField div:last").remove();
	
}

function getUser(userId) {
	var userId = $('#query_id').val();
	if (userId) {
		$.ajax(
				{
					type : "GET",
					url  : "/cs461/user/" + userId,
					data : {
					},
					success : function(result) {
						$('#result_id').text(result.id);
						$('#result_name').text(result.name);
						$('#result_email').text(result.email);
						$('#result_department').text(result.department);
						$('#result_office').text(result.office);
						$('#result_officeHours').text(result.officeHours);
					},
					error: function (jqXHR, exception) {
						alert("Failed to get the user.");
					}
				});
	} else {
		alert("Invalid user Id");
	}
}