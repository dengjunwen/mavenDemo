<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>成功桥 | 教育平台</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="${path}/css/cloud-admin.css">
<link rel="stylesheet" type="text/css"
	href="${path}/css/themes/default.css" id="skin-switcher">
<link rel="stylesheet" type="text/css" href="${path}/css/responsive.css">
<!-- STYLESHEETS -->
<!--[if lt IE 9]><script src="${path}/js/flot/excanvas.min.js"></script><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
<link href="${path}/demoH5/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- ANIMATE -->
<link rel="stylesheet" type="text/css"
	href="${path}/css/animatecss/animate.min.css" />
<!-- DATE RANGE PICKER -->
<link rel="stylesheet" type="text/css"
	href="${path}/js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
<!-- TODO -->
<link rel="stylesheet" type="text/css"
	href="${path}/js/jquery-todo/css/styles.css" />
<!-- FULL CALENDAR -->
<link rel="stylesheet" type="text/css"
	href="${path}/js/fullcalendar/fullcalendar.min.css" />
<!-- GRITTER -->
<link rel="stylesheet" type="text/css"
	href="${path}/js/gritter/css/jquery.gritter.css" />
<!-- FONTS -->
<link href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700'
	rel='stylesheet' type='text/css'>

<!-- JAVASCRIPTS -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- JQUERY -->
<script src="${path}/js/jquery/jquery-2.0.3.min.js"></script>
<!-- JQUERY UI-->
<script
	src="${path}/js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.min.js"></script>
<!-- BOOTSTRAP -->
<script src="${path}/bootstrap-dist/js/bootstrap.min.js"></script>


<!-- DATE RANGE PICKER -->
<script src="${path}/js/bootstrap-daterangepicker/moment.min.js"></script>

<script src="${path}/js/bootstrap-daterangepicker/daterangepicker.min.js"></script>
<!-- SLIMSCROLL -->
<script type="text/javascript"
	src="${path}/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.min.js"></script>
<!-- SLIMSCROLL -->
<script type="text/javascript"
	src="${path}/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.min.js"></script>
<script type="text/javascript"
	src="${path}/js/jQuery-slimScroll-1.3.0/slimScrollHorizontal.min.js"></script>
<!-- BLOCK UI -->
<script type="text/javascript"
	src="${path}/js/jQuery-BlockUI/jquery.blockUI.min.js"></script>
<!-- SPARKLINES -->
<script type="text/javascript"
	src="${path}/js/sparklines/jquery.sparkline.min.js"></script>
<!-- EASY PIE CHART -->
<script src="${path}/js/jquery-easing/jquery.easing.min.js"></script>
<script type="text/javascript"
	src="${path}/js/easypiechart/jquery.easypiechart.min.js"></script>
<!-- FLOT CHARTS -->
<script src="${path}/js/flot/jquery.flot.min.js"></script>
<script src="${path}/js/flot/jquery.flot.time.min.js"></script>
<script src="${path}/js/flot/jquery.flot.selection.min.js"></script>
<script src="${path}/js/flot/jquery.flot.resize.min.js"></script>
<script src="${path}/js/flot/jquery.flot.pie.min.js"></script>
<script src="${path}/js/flot/jquery.flot.stack.min.js"></script>
<script src="${path}/js/flot/jquery.flot.crosshair.min.js"></script>
<!-- TODO -->
<script type="text/javascript"
	src="${path}/js/jquery-todo/js/paddystodolist.js"></script>
<!-- TIMEAGO -->
<script type="text/javascript"
	src="${path}/js/timeago/jquery.timeago.min.js"></script>
<!-- FULL CALENDAR -->
<script type="text/javascript"
	src="${path}/js/fullcalendar/fullcalendar.min.js"></script>
<!-- COOKIE -->
<script type="text/javascript"
	src="${path}/js/jQuery-Cookie/jquery.cookie.min.js"></script>
<!-- GRITTER -->
<script type="text/javascript"
	src="${path}/js/gritter/js/jquery.gritter.min.js"></script>
<!-- CUSTOM SCRIPT -->
<script src="${path}/js/script.js">
</script>
<style type="text/css">

</style>
<script>
	$(function() {
		$("ul[name='sidebar'] li").bind("click", function() {
			$("ul[name='sidebar'] li").removeClass("active");
			$(this).addClass("active");
		});
	});
	
	function toIndex(path) {
		$("#main-content-iframe").attr("src", path);
	}
</script>
</head>
<body>
	<!-- HEADER -->
	<header class="navbar clearfix" id="header">
	<div class="container">
		<div class="navbar-brand">
			<!-- COMPANY LOGO -->
			<a href="index.html"> <img src="${path}/img/logo/logo.png"
				alt="Cloud Admin Logo" class="img-responsive" height="30"
				width="120">
			</a>
			<!-- /COMPANY LOGO -->
			<!-- TEAM STATUS FOR MOBILE -->
			<div class="visible-xs">
				<a href="#" class="team-status-toggle switcher btn dropdown-toggle">
					<i class="fa fa-users"></i>
				</a>
			</div>
			<!-- /TEAM STATUS FOR MOBILE -->
			<!-- SIDEBAR COLLAPSE -->
			<!-- /SIDEBAR COLLAPSE -->
		</div>
		<!-- NAVBAR LEFT -->
		<!-- /NAVBAR LEFT -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<ul class="nav navbar-nav pull-right">
			<!-- END TODO DROPDOWN -->
			<!-- BEGIN USER LOGIN DROPDOWN -->
			<!-- END USER LOGIN DROPDOWN -->
		</ul>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- TEAM STATUS --> <!-- /TEAM STATUS --> </header>
	<!--/HEADER -->
	<!-- PAGE -->
	<!-- SIDEBAR -->
	<div id="sidebar" class="sidebar">
		<div class="sidebar-menu nav-collapse">
			<div class="divide-20"></div>
			<!-- SEARCH BAR -->
			 
			<!-- /SEARCH BAR -->

			<!-- SIDEBAR MENU -->
			<ul name="sidebar">
				<li class="has-sub"><a href="javascript:;" ><i
						class="fa fa-tasks fa-fw"></i> <span class="arrow">任务管理</span></a>
					<ul class="sub">
						<li><a class="" href="#" onclick="toIndex('${path}/manage/tasks')"><span
								class="sub-menu-text">任务列表</span></a></li>
						<li>
						<a class="" href="javascript:void(0)" onclick="toIndex('${path}/manage/tasks/addLiveTask')">
							<span class="menu-text">Live任务添加</span></a></li>
							<li><a class="" href="#" onclick="toIndex('${path}/manage/online')"><span
								class="sub-menu-text">online任务添加</span></a></li>
						</ul>
						
					</li>
				<li><a href="javascript:;"
					onclick="toIndex('${path}/manage/classes')"><i
						class="fa fa-desktop fa-fw"></i> <span class="menu-text">班级事务</span></a></li>
				<li class="has-sub"><a href="javascript:;" class=""> <i
						class="fa fa-columns fa-fw"></i> <span class="menu-text">课件管理</span>
						<span class="arrow"></span>
				</a>
					<ul class="sub">
						<li><a class="" href="#" onclick="toIndex('${path}/manage/page/list')"><span
								class="sub-menu-text">课件列表</span></a></li>
						<li><a class="" href="#" onclick="toIndex('${path}/manage/page/addPage')"><span
								class="sub-menu-text">新增课件</span></a></li>
					</ul></li>
				<li><a class="" href="javascript:void(0)" onclick="toIndex('${path}/manage/teacher/list')">
					<i class="fa fa-desktop fa-fw"></i> <span class="menu-text">教师管理</span></a>
				</li>
				<li><a class="" href="javascript:void(0)" onclick="toIndex('${path}/manage/student/list')">
					<i class="fa fa-desktop fa-fw"></i> <span class="menu-text">学生管理</span></a>
				</li>
				
				<li><a class="" href="javascript:void(0)" onclick="toIndex('${path}/xzqh/direct')">
					<i class="fa fa-desktop fa-fw"></i> <span class="menu-text">行政区划管理</span></a>
				</li>
				
				<li><a class="" href="javascript:void(0)" onclick="toIndex('${path}/resource/direct')">
					<i class="fa fa-desktop fa-fw"></i> <span class="menu-text">资源管理</span></a>
				</li>
				
				<li><a class="" href="javascript:void(0)" onclick="toIndex('${path}/manage/studentTaskHistory/list')">
					<i class="fa fa-desktop fa-fw"></i> <span class="menu-text">学生任务记录</span></a>
				</li>
				
				<li><a class="" href="javascript:void(0)" onclick="toIndex('${path}/manage/studentTaskScore/list')">
					<i class="fa fa-desktop fa-fw"></i> <span class="menu-text">学生任务评分</span></a>
				</li>
			</ul>
			<!-- /SIDEBAR MENU -->
		</div>
	</div>
	<!-- /SIDEBAR -->
	<div id="main-content" style="height: 90%;">
		<iframe id="main-content-iframe"
			style="width: 100%; height: 100%;border: 0 ; scrolling: auto; overflow: hidden">
		</iframe>
	</div>
	<!--/PAGE -->
</body>
</html>