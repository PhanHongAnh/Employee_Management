<div class="container">
	<div class="row">
		<div class="col-sm-12 text-center">
			<h1>Change Password</h1>
		</div>
	</div><br><br><br>
	
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<form method="post" id="passwordForm" class="form-horizontal">
				
				<div class="form-group form-margin">
	     			<label class="col-sm-4 control-label" for="EmployeeID">EmployeeID</label>  
	     			<div class="col-sm-8">
	     				<h4 class="">
	     					20142531
	     				</h4>
	     			</div>
     			</div>
	            
	            <div class="form-group form-margin">
					<label class="col-sm-4 control-label" for="New Password">New Password</label>
					<div class="col-sm-8">
						<input type="password" class="input-lg form-control" name="password1" id="password1" placeholder="New Password" autocomplete="off">
					</div>
					<div class="row">
						<div class="col-sm-4"></div>
						<div class="col-sm-4">
							<span id="8char" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> 8 Characters Long<br>
							<span id="ucase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Uppercase Letter
						</div>
						<div class="col-sm-4">
							<span id="lcase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Lowercase Letter<br>
							<span id="num" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Number
						</div>
					</div>
				</div>
				
				<div class="form-group form-margin">
					<label class="col-sm-4 control-label" for="Repeat Password">Repeat Password</label>
					<div class="col-sm-8">
						<input type="password" class="input-lg form-control" name="password2" id="password2" placeholder="Repeat Password" autocomplete="off">
					</div>
					<div class="row">
						<div class="col-sm-4"></div>
						<div class="col-sm-4">
							<span id="pwmatch" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> Passwords Match
						</div>
					</div>
				</div>
           		
           		<div class="form-group">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<a href="#" class="btn btn-success"><span class="glyphicon glyphicon-thumbs-up"></span> Change Password</a>
					</div>
					<div class="col-sm-4">
						<a href="#" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign"></span> Cancel</a>
					</div>
           		</div>
			</form>
		</div><!--/col-sm-6-->
	</div><!--/row-->
</div>


<script>
$("input[type=password]").keyup(function(){
    var ucase = new RegExp("[A-Z]+");
	var lcase = new RegExp("[a-z]+");
	var num = new RegExp("[0-9]+");
	
	if($("#password1").val().length >= 8){
		$("#8char").removeClass("glyphicon-remove");
		$("#8char").addClass("glyphicon-ok");
		$("#8char").css("color","#00A41E");
	}else{
		$("#8char").removeClass("glyphicon-ok");
		$("#8char").addClass("glyphicon-remove");
		$("#8char").css("color","#FF0004");
	}
	
	if(ucase.test($("#password1").val())){
		$("#ucase").removeClass("glyphicon-remove");
		$("#ucase").addClass("glyphicon-ok");
		$("#ucase").css("color","#00A41E");
	}else{
		$("#ucase").removeClass("glyphicon-ok");
		$("#ucase").addClass("glyphicon-remove");
		$("#ucase").css("color","#FF0004");
	}
	
	if(lcase.test($("#password1").val())){
		$("#lcase").removeClass("glyphicon-remove");
		$("#lcase").addClass("glyphicon-ok");
		$("#lcase").css("color","#00A41E");
	}else{
		$("#lcase").removeClass("glyphicon-ok");
		$("#lcase").addClass("glyphicon-remove");
		$("#lcase").css("color","#FF0004");
	}
	
	if(num.test($("#password1").val())){
		$("#num").removeClass("glyphicon-remove");
		$("#num").addClass("glyphicon-ok");
		$("#num").css("color","#00A41E");
	}else{
		$("#num").removeClass("glyphicon-ok");
		$("#num").addClass("glyphicon-remove");
		$("#num").css("color","#FF0004");
	}
	
	if($("#password1").val() == $("#password2").val()){
		$("#pwmatch").removeClass("glyphicon-remove");
		$("#pwmatch").addClass("glyphicon-ok");
		$("#pwmatch").css("color","#00A41E");
	}else{
		$("#pwmatch").removeClass("glyphicon-ok");
		$("#pwmatch").addClass("glyphicon-remove");
		$("#pwmatch").css("color","#FF0004");
	}
});
</script>