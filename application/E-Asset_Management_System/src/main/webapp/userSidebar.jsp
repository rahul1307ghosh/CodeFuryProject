<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">
	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">${userData.userName}</div>
	</a>
	<!-- Divider -->
	<hr class="sidebar-divider my-0">
	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link"
		href="userDashboard.jsp"> <i class="fa fa-user"></i> <span>${userData.name}</span>
	</a></li>
	<li class="nav-item active"><a class="nav-link"
		href="userDashboard.jsp"> <i class="fa fa-calendar"></i> <span>${prevLogin}</span>
	</a></li>
	<!-- Divider -->
	<hr class="sidebar-divider">
	<li class="nav-item active"><a class="nav-link"
		href="borrowedAssets.jsp"> <i class="fa fa-archive"></i> <span>Borrowed
				Assets</span>
	</a></li>
	<li class="nav-item active"><a class="nav-link"
		href="availableAssets.jsp"> <i class="fa fa-window-maximize"></i>
			<span>Available Assets</span>
	</a></li>
	<li class="nav-item active"><a class="nav-link"
		href="overdueMessage"> <i class="fa fa-comments-o"></i> <span>Messages</span>
	</a></li>
</ul>