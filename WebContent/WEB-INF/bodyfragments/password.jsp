<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<div class="container">
	<div class="row">
		<div class="col-sm-12 text-center">
			<h1>Change Password</h1>
		</div>
	</div><br><br><br>
	
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<form method="post" id="passwordForm" class="form-horizontal" action="${fn:replace(requestScope['javax.servlet.forward.request_uri'],'change','update')}">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="form-group form-margin">
	     			<label class="col-sm-4 control-label" for="EmployeeID">EmployeeID</label>  
	     			<div class="col-sm-8">
	     				<h4 class="">
	     					${emp.employeeId}
	     				</h4>
	     			</div>
     			</div>
	            
	            <c:if test="${error != null}">
		            <span class="form-group form-margin">
		            	<label class="col-sm-4"></label>
			            <span class="col-sm-8 error">${error}
						</span>
		            </span>
		        </c:if>
		        
	            <div class="form-group form-margin">
					<label class="col-sm-4 control-label" for="New Password">
						New Password <span style="color:red;">*</span>
					</label>
					<div class="col-sm-8">
						<input type="password" class="input-lg form-control" name="password1" id="password1" 
							placeholder="New Password" autocomplete="off" data-rule-passwordCheck="true">
					</div>
				</div>
				
				<div class="form-group form-margin">
					<label class="col-sm-4 control-label" for="Confirm Password">
						Confirm  Password <span style="color:red;">*</span>
					</label>
					<div class="col-sm-8">
						<input type="password" class="input-lg form-control" name="password2" id="password2" 
							placeholder="Repeat Password" autocomplete="off">
					</div>
				</div>
           		
           		<div class="form-group">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<input type="submit" name="submit" id="submit" tabindex="4" class="btn btn-success" value="Change Password">
					</div>
					<div class="col-sm-4">
						<a href="${fn:substringBefore(requestScope['javax.servlet.forward.request_uri'],'/change_password')}" class="btn btn-danger">Cancel</a>
					</div>
           		</div>
			</form>
		</div><!--/col-sm-6-->
	</div><!--/row-->
</div>


<script>
jQuery.validator.addMethod("passwordCheck", function(value) {
	return /[0-9]/.test(value)
	},
	"Password must include at least a number");

$("#passwordForm").validate({
  rules: {
    password1: {
        required: true,
        minlength: 8,
    },
    password2: {
      equalTo: "#password1"
    }
  },
  messages: {
    password1: {
        required: "Password is required",
        minlength: "Password must be at least 8 characters",
    },
    password2: {
      equalTo: "Repeat Password does not match"
    }
  }
});
</script>