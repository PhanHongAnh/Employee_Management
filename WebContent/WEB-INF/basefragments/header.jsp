<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav>
	<div class="row">
		<div class="col-md-2">
			<a href="#" class="logo">Logo</a>
		</div>
		<div class="col-md-9">
			<div class="pull-right">
				<ul class="list-inline" style="margin: 10px 0px;">
					<li>Welcome</li>
					<li><img src="<c:url value="/resources/img/no_avatar.jpg"/>" class="header-avatar img-circle img-thumbnail" alt="avatar"></li>
				</ul>
			</div>
		</div>
		<div class="col-md-1">
			<button class="navicon">
				<span>&#9776;</span>
				<div class="mainNavDropDown">
					<p>My Profile</p>
					<p>Change Password</p>
				</div>
			</button>
		</div>
	</div>
</nav>