<html>

<head>
    <title>Cal Poly Pomona Faculty Scheduler</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/home-control.js"></script>
    <script src="/js/editable-table.js"></script>
	<link href="/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/custom-feature.css" rel="stylesheet">
	<link href="/css/print.css" rel="stylesheet" type="text/css" media="print">
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
	       	<div class="page-header">Faculty Schedule</div>
       		<div class="table-responsive">
	       		<table class="table table-striped table-bordered">
	       			<thead>         
		                <tr>
		                    <th>Name</th> 
		                    <th>Email</th> 
		                    <th>Office</th>
		                    <th>Office Hours</th>
		                </tr>
		            </thead>
		            <tbody>
		                <#list users as user>
			                <tr>
			                    <td>${user.name}</td>
			                    <td>${user.email}</td>
			                    <td>${user.office}</td>
			                    <td>${user.officeHours}</td>
			                </tr>
		                </#list>
	                </tbody>
	        	 </table>
             </div>
        </div>
        
        <div class="container page-config">
        	<div class="page-header bottom-line"></div>
        	<button class="btn btn-default" onclick="window.print();">Print Page</button>
        </div>
</body>

</html>