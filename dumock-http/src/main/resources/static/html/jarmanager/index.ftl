<!DOCTYPE html>
<html lang="en">

	<head>
			<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Dashboard - Ace Admin</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/font-awesome/4.5.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="../assets/css/fonts.googleapis.com.css" />
		<link rel="stylesheet" href="../assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
		<link rel="stylesheet" href="../assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="../assets/css/ace-rtl.min.css" />
		<script src="../assets/js/ace-extra.min.js"></script>
		<script src="../assets/js/jquery-2.1.4.min.js"></script>

	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="index.ftl" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							DuMock
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="../assets/images/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									Jason
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										Settings
									</a>
								</li>

								<li>
									<a href="profile.html">
										<i class="ace-icon fa fa-user"></i>
										Profile
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>

		<div class="main-container ace-save-state" id="main-container">


			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">工作区</a>
							</li>
							<li class="active">我的工作台</li>
						</ul><!-- /.breadcrumb -->
					</div>

					<div class="page-content">
						<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								
								<div class="row">
									<div class="col-xs-12">
										<h3 class="header smaller lighter blue">jar包列表</h3>

										<div class="clearfix">
											<div class="pull-right tableTools-container"></div>
										</div>
										
										<!-- div.table-responsive -->

										<!-- div.dataTables_borderWrap -->
										<div>
											<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														
														<th>groupId</th>
														<th>artifactId</th>
														<th>版本号</th>
														<th>jar包名称</th>
													</tr>
												</thead>

												<tbody>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
													<tr>
														<td>org.springframework.boot</td>
														<td>spring-boot-starter-aop</td>
														<td>1.2.3</td>
														<td>spring-boot-starter-aop.jar</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>

								
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							Application &copy; 2013-2014
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="../assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="../assets/js/jquery.dataTables.min.js"></script>
		<script src="../assets/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="../assets/js/dataTables.buttons.min.js"></script>
		<script src="../assets/js/buttons.flash.min.js"></script>
		<script src="../assets/js/buttons.html5.min.js"></script>
		<script src="../assets/js/buttons.print.min.js"></script>
		<script src="../assets/js/buttons.colVis.min.js"></script>
		<script src="../assets/js/dataTables.select.min.js"></script>

		<!-- ace scripts -->
		<script src="../assets/js/ace-elements.min.js"></script>
		<script src="../assets/js/ace.min.js"></script>

	
	</body>
</html>
