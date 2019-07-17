<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="container">
    <div class="row">
  		<div class="col-sm-10"><h1 class="text-center">Create Employee</h1></div>
    </div><br><br>
    <div class="row">
  		<div class="col-sm-3"><!--left col-->
			<div class="text-center">
				<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
				<h6>Upload a different photo...</h6>
				<input type="file" class="text-center center-block file-upload">
			</div>
		</div><!--/col-3-->
    	
    	<div class="col-sm-9">
        	<ul class="nav nav-tabs">
				<li class="active"><h4>Profile</h4></li>
             </ul>
             
             <div class="tab-content">
             	<div class="tab-pane active">
             	
             		<form class="form-horizontal" action="${pageContext.request.contextPath}/create" method="post">
             			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
             		
	             		<div class="form-group form-margin">
	             			<label class="col-sm-4 control-label" for="EmployeeID">EmployeeID</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-id-card"></i>
	             					</div>
	             					<input type="text" name="employee_id" value="${employee.employee_id}" placeholder="EmployeeID" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Name (Full name)">Name (Full name)</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-user"></i>
	             					</div>
	             					<input type="text" name="employee_name" value="${employee.employee_name}" placeholder="Name (Full name)" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Date Of Birth">Date Of Birth</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-birthday-cake"></i>
	             					</div>
	             					<input type="date" name="birthday" value="${employee.birthday}" placeholder="Date Of Birth" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
							<label class="col-sm-4 control-label" for="gender">Gender</label>
							<div class="col-sm-5"> 
								<label class="radio-inline" for="male">
									<input type="radio" name="gender" id="male" value="Male" checked="checked"> Male
								</label> 
								<label class="radio-inline" for="female">
									<input type="radio" name="gender" id="female" value="Female"> Female
								</label>
								<label class="radio-inline" for="other">
									<input type="radio" name="gender" id="other" value="Other"> Other
								</label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-4 control-label col-xs-12" for="Permanent Address">Permanent Address</label>  
							<div class="col-sm-5">
								<input type="text" name="address" value="${employee.address}" placeholder="District" class="form-control input-md ">
							</div>	
						</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Phone number">Phone number</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-phone"></i>
	             					</div>
	             					<input type="text" name="phone" value="${employee.phone}" placeholder="Phone number" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Email Address">Email Address</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-envelope-o"></i>
	             					</div>
	             					<input type="text" name="email" value="${employee.email}" placeholder="Email Address" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Started Day">Started Day</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-calendar"></i>
	             					</div>
	             					<input type="date" name="started_day" value="${employee.started_day}" placeholder="Started Day" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="status">Status</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-user"></i>
	             					</div>
	             					<select id="status" name="status_id" class="form-control input-md">
	             						<c:forEach items="${listStatuses}" var="status">
	             							<option value="${status.status_id}">${status.status_name}</option>
	             						</c:forEach>
	             					</select>
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<ul class="nav nav-tabs">
							<li class="active"><h4>Role</h4></li>
			            </ul>
	             		
	             		<div class="form-group form-margin">
	             			<label class="col-sm-4 control-label" for="role">Role</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-user-times"></i>
	             					</div>
	             					<select id="role" name="role_id" class="form-control input-md">
	             						<c:forEach items="${listRoles}" var="role">
	             							<option value="${role.role_id}">${role.role_name}</option>
             							</c:forEach>
	             					</select>
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<ul class="nav nav-tabs">
							<li class="active"><h4>Position</h4></li>
			            </ul>
	             		
	             		<div class="form-group form-margin">
	             			<label class="col-sm-4 control-label" for="department">Department</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-users"></i>
	             					</div>
	             					<select id="department" name="department_id" class="form-control input-md">
	             						<c:forEach items="${listDepartments}" var="department">
	             							<option value="${department.department_id}">${department.department_name}</option>
             							</c:forEach>
	             					</select>
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="position">Position</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-user"></i>
	             					</div>
	             					<select id="position" name="position_id" class="form-control input-md">
	             						<c:forEach items="${listPositions}" var="position">
	             							<option value="${position.position_id}">${position.position_name}</option>
             							</c:forEach>
	             					</select>
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" ></label>  
	             			<div class="col-sm-5">
	             				<input type="submit" class="btn btn-success" value="Submit">
	             				<a href="/Employee_Management/employees" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign"></span> Cancel</a>
	             			</div>
	             		</div>
	             	</form>
             	</div>
             </div><!--/tab-content-->
		</div><!--/col-9-->
	</div><!--/row-->
</div>
