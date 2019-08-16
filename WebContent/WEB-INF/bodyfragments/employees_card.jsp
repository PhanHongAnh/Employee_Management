<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="list-group">
	<section id="team" class="pb-5">
		<div class="row">
		<c:forEach items="${list}" var="employee">
			<div class="col-xs-12 col-sm-6 col-md-4">
	           <div class="image-flip">
	               <div class="mainflip">
	                   <div class="frontside">
	                       <div class="card">
	                           <div class="card-body text-center">
	                               <p><img class=" img-fluid" src="<c:url value="/resources/img/no_avatar.jpg"/>" alt="card image"></p>
	                               <h4 class="card-title">${employee.employee_id}</h4>
	                               <h4 class="card-title">${employee.employee_name}</h4>
	                               <p class="card-text">
	                               		<c:forEach items="${listDepartments}" var="dep">
	                               			<c:if test="${dep.department_id == employee.department_id}">
	                  	            			Department: ${dep.department_name}
	                               			</c:if>
	                               		</c:forEach>
	                               		 | 
	                               		<c:forEach items="${listPositions}" var="posi">
	                               			<c:if test="${posi.position_id == employee.position_id}">
	                  	            			Positon: ${posi.position_name}
	                               			</c:if>
	                               		</c:forEach>
	                               	</p>
	                           </div>
	                       </div>
	                   </div>
	                   <div class="backside">
	                       <div class="card">
	                           <div class="card-body text-center">
	                               <a href="employee/${employee.employee_id}" class="card-title">${employee.employee_name}</a>
	                               <ul class="card-text">
		                               <li>Birthday: ${employee.birthday}</li>
		                               <li>Email: ${employee.email}</li>
		                               <li>Address: ${employee.address}</li>
	                               </ul>
	                               
	                    		   <div class="action">
			               				<button type="button" onclick="location.href='employee/${employee.employee_id}/edit'" class="but-action btn btn-primary btn-xs" title="Edit">
			                   				<span class="glyphicon glyphicon-pencil"></span>
			               				</button>
			               				<button type="button" class="but-action btn btn-danger btn-xs" title="Delete">
			                   				<span class="glyphicon glyphicon-trash"></span>
			               				</button>
	              					</div>                              
	                           </div>
	                       </div>
	                   </div>
	               </div>
	           </div>
	       </div>  
		</c:forEach>
		</div>
	</section>
</div>
