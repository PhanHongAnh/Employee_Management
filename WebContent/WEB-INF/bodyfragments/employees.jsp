<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
	<div class="row">
		<div class="col-md-6">
			<button class="dropdown btn btn-default dropdown-toggle">
				<span>Sort by</span>
				<div class="dropdown-content">
					<p>ASC Users</p>
					<p>DESC Users</p>
					<p>ASC Departments</p>
					<p>DESC Departments</p>
				</div>
			</button>
		</div>
        
        <div class="col-md-4">
			<div id="custom-search-input">
                <div class="input-group">
                    <input type="text" class="search-query form-control" placeholder="Search" />
                    <span class="input-group-btn">
                        <button class="btn btn-danger" type="button">
                            <span class=" glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>
            </div>
        </div>
        
        <div class="col-md-1">
	        <button type="button" class="button2" onclick="location.href='employee/new'" title="Add">
	            <span class="glyphicon glyphicon-plus"></span> Add
	        </button>
        </div>
        
		<form action="${pageContext.request.contextPath}/type" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="col-md-1 text-right" style="padding:0px;">
		        <button type="submit" name="type_view" value="list" class="show-button">
					<img src="<c:url value="/resources/img/button_list.png"/>" alt="" width="42" height="42"/>
				</button>
		        <button type="submit" name="type_view" value="card" class="show-button">
					<img src="<c:url value="/resources/img/button_card.png"/>" alt="" width="42" height="42">
				</button>
	        </div>
        </form>
	</div>
	
    <div class="row" style="margin-top:50px;">
        <div class="panel panel-default widget">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-user"></span>
                <h3 class="panel-title">
                    All Users</h3>
                <span class="label label-info">
                    ${total}</span>
            </div>
            <div class="panel-body">
            	<%if ((String) session.getAttribute("type_view")==null||(String) session.getAttribute("type_view")=="card"){ %>
                	<%@include file="employees_card.jsp" %>
                <%} else{%>
                	<%@include file="employees_list.jsp" %>
                	<%} %>
            </div>
        </div>
    </div>
</div>
