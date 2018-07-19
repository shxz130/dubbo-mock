<!DOCTYPE html>
<html lang="en">

	<#include "../common/head.ftl"/>

	<body class="no-skin">
	<#include "../common/header.ftl"/>


    <div class="main-container ace-save-state" id="main-container">
		<#include "../common/left.ftl"/>


        <div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">工作区</a>
							</li>

						
							<li class="active">添加测试场景</li>
						</ul><!-- /.breadcrumb -->

				
					</div>

					<div class="page-content">
						


							<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="alert alert-info">
									<button class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>

									<i class="ace-icon fa fa-hand-o-right"></i>
									 请输入你要添加的场景名称和场景说明
								</div>

								

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->

						

						
						
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 测试场景名称</label>

										<div class="col-sm-9">
											<input type="text" id="form-field-1" placeholder="测试场景名称" class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1"> 测试场景说明 </label>

										<div class="col-sm-9">
											<textarea class="form-control" id="form-field-8" placeholder="测试场景说明"></textarea>
										</div>
									</div>

									<div class="space-4"></div>


									<div class="space-4"></div>

									

									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" onclick="javascript:window.location.href='scene_group.ftl';">
												<i class="ace-icon fa fa-check bigger-110"></i>
												提交
											</button>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset" onclick="javascript:window.location.href='scene_group.ftl';">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												返回到列表
											</button>
										</div>
									</div>




					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

				<#include "../common/footer.ftl"/>

				</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="../assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="../assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="../assets/js/bootstrap-datepicker.min.js"></script>
		<script src="../assets/js/jquery.jqGrid.min.js"></script>
		<script src="../assets/js/grid.locale-en.js"></script>

		<!-- ace scripts -->
		<script src="../assets/js/ace-elements.min.js"></script>
		<script src="../assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		
			
			
	</body>
</html>
