<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<div class="container">
    <div class="row">
  		<div class="col-sm-10"><h1 class="text-center">${emp.employee_name}</h1></div>
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
             	
             		<form class="form-horizontal" action="${fn:replace(requestScope['javax.servlet.forward.request_uri'],'edit','update')}" method="post">
             			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
             		
	             		<div class="form-group form-margin">
	             			<label class="col-sm-4 control-label" for="id">EmployeeID</label>  
	             			<div class="col-sm-5">
	             				<h4 class="">
	             					${emp.employee_id}
	             				</h4>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="name">Name (Full name)</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-user"></i>
	             					</div>
	             					<input id="name" name="name" type="text" placeholder="${emp.employee_name}" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="bod">Date Of Birth</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-birthday-cake"></i>
	             					</div>
	             					<input id="bod" name="bod" type="text" placeholder="${emp.birthday}" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
						
						<div class="form-group">
							<label class="col-sm-4 control-label col-xs-12" for="address">Permanent Address</label>  
							<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-map-marker"></i>
	             					</div>
	             					<input id="address" name="address" type="text" placeholder="${emp.address}" class="form-control input-md">
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
	             			<label class="col-sm-4 control-label" for="phone">Phone number</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-phone"></i>
	             					</div>
	             					<input id="phone" name="phone" type="text" placeholder="${emp.phone}" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="email">Email Address</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-envelope-o"></i>
	             					</div>
	             					<input id="email" name="email" type="text" placeholder="${emp.email}" class="form-control input-md">
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="std">Started Day</label>  
	             			<div class="col-sm-5">
	             				<div class="input-group">
	             					<div class="input-group-addon">
	             						<i class="fa fa-calendar"></i>
	             					</div>
	             					<input id="std" name="std" type="text" placeholder="${emp.started_day}" class="form-control input-md">
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
	             					<select id="status" name="status" class="form-control input-md">
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
	             					<select id="role" name="role" class="form-control input-md">
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
	             					<select id="department" name="department" class="form-control input-md">
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
	             					<select id="position" name="position" class="form-control input-md">
	             						<c:forEach items="${listPositions}" var="position">
	             							<option value="${position.position_id}">${position.position_name}</option>
             							</c:forEach>
	             					</select>
	             				</div>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group form-margin">
	             			<label class="col-sm-4 control-label" ></label>  
	             			<div class="col-sm-5">
	             				<input type="submit" name="submit" id="submit" tabindex="4" class="btn btn-success" value="Update">
	             				<input type="reset" name="reset" id="reset" tabindex="4" class="btn btn-info" value="Reset">
	             				<a href="${fn:substringBefore(requestScope['javax.servlet.forward.request_uri'],'edit')}" class="btn btn-danger">Cancel</a>
	             			</div>
	             		</div>
	             	</form>
             	</div>
             </div><!--/tab-content-->
		</div><!--/col-9-->
	</div><!--/row-->
</div>