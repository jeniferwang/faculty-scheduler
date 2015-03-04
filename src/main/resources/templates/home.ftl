<html>

<head>
    <title>Cal Poly Pomona Faculty Scheduler</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/home-control.js"></script>
    <script src="/js/editable-table.js"></script>
	<link href="/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/custom-feature.css" rel="stylesheet">
</head>

<body>    
    
    
    <nav class="navbar navbar-inverse navbar-fixed-top">
    	<div class="container">
    		<img class="navbar-brand-icon" src="/images/cpp-logo.png">
    		<a class="navbar-brand" href="./home">Faculty Scheduler</a>
    	</div>
    </nav>
    
    <div class="jumbotron">
    
    	<div class="container">
            <div class="page-header">Add User</div>
	       	<div class="row clearfix">
		       	<div class="col-md-12 table-responsive">
		            <table class="table">
		            	<thead>
			                <tr>
			                    <th>ID</th>
			                    <th>Name</th>
			                    <th>Email</th>
			                    <th>Department</th>
			                    <th>Office</th>
			                    <th>Office Hours</th>
			                    <th>Add</th>
			                </tr>             
			                <tr>
			                    <td><input type="text" class="form-control" id="input_id"></td>
			                    <td><input type="text" class="form-control" id="input_name"></td>
			                    <td><input type="text" class="form-control" id="input_email"></td>
			                    <td><input type="text" class="form-control" id="input_department"></td>
			                    <td><input type="text" class="form-control" id="input_office"></td> 
			                    <td>
			                    	<fieldset id="hoursField"></fieldset>
			                    	<button class="btn btn-default" onclick="addEntry()">Add</button>
			                    	<button class="btn btn-default" onclick="removeEntry()">Remove</button>
			                    </td>                   
			                    <td><button class="btn btn-default" onclick="addUser()">Add User</button></td>
			                </tr>
			            </thead>
		            </table>
		        </div>
	        </div>
        </div>    
    
	    <div class="container">
	       	<div class="page-header">User List
	       		<button class="btn btn-default" id="user-list-button" onclick="showUserList()"> Show</button>
	       	</div>
	       	<div class="user-list-toggle">
	       		<div class="table-responsive">
		       		<table class="table table-striped table-hover">
		       			<thead>         
			                <tr>
			                    <th>ID</th>
			                    <th>Name</th>
			                    <th>Email</th>
			                    <th>Department</th> 
			                    <th>Office</th>
			                    <th>Office Hours</th>
			                    <th>Last Updated</th>
			                    <th>Actions</th>
			                </tr>
			            </thead>
			            <tbody>
			                <#list users as user>
				                <tr>
				                    <td id="input_id_edit">${user.id}</td>
				                    <td id="input_name_edit" contenteditable="true">${user.name}</td>
				                    <td id="input_email_edit" contenteditable="true">${user.email}</td>
				                    <td id="input_department_edit" contenteditable="true">${user.department}</td>
				                    <td id="input_office_edit" contenteditable="true">${user.office}</td>
				                    <td id="hoursField_edit" contenteditable="true">${user.officeHours}</td>
				                    <td>${user.updateTime}</td>
				                    <td>
				                    	<button class="btn btn-default table-action" id="edit_button">Edit</button>
				                    	<button class="btn btn-default table-action" onclick="deleteUser('${user.id}')">Delete</button>
									</td>
				                </tr>
			                </#list>
		                </tbody>
		        	 </table>
	             </div>
	    	</div>
        </div>
        
        <div class="container page-config">
        	<div class="page-header bottom-line"></div>
        	<button class="btn btn-default" onclick="window.location='./student'">Student Version</button>
        </div>
</body>

</html>