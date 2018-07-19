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

						
							<li class="active">XXX系统XXX场景对应接口列表</li>
						</ul><!-- /.breadcrumb -->

				
					</div>

					<div class="page-content">
						

						<form class="form-search">


							<div class="row">
									<div class="col-xs-12">
										<h3 class="header smaller lighter green">操作</h3>

										<p></p>
										
											<a class="btn btn-success" href="interface_list.ftl">添加新接口</a>

										
									</div>
							</div>
							<div class="hr"></div>

							

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								
								<table id="grid-table"></table>

							

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->

						<div class="row">
							
						</div><!-- /.row -->



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
		<script type="text/javascript">
			var grid_data = 
			[ 
				{id:"1",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"2",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"3",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"4",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"5",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"6",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"7",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"8",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"9",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"10",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"11",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"12",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"},
				{id:"13",facadeName:"com.github.hycx.cgw.facade.XXXFacade",methodName:"methodABeforeBAfterCDo",version:"version"}
			];
			
			
			jQuery(function($) {
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
				
				
				var parent_column = $(grid_selector).closest('[class*="col-"]');
				//resize to fit page size
				$(window).on('resize.jqGrid', function () {
					$(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
			    })		
			
				jQuery(grid_selector).jqGrid({
					subGrid : false,
					data: grid_data,
					datatype: "local",
					height: 500,
					colNames:[ 'id','接口名称','方法名称','版本号','操作'],
					colModel:[
						{name:'id',index:'id', width:30, sorttype:"int", editable: false},
						{name:'facadeName',index:'facadeName', width:130,editable: false},
						{name:'methodName',index:'methodName', width:50,editable: false},
						{name:'version',index:'version', width:50,editable: false},
						{
		                    label: '操作', name: 'flag', index: 'flag', width: 45, align: 'center',
		                    formatter: function (cellvalue, options, rowObject) {
		                    	 var control="<button type=\"button\" class=\"btn btn-white btn-primary\" onclick=\"javascript:window.location.href='interface_controller.ftl';\">操作</button>";
		                   		 var detail="<button class=\"btn btn-white btn-warning\" onclick='javascript:alert(\"success\");'>删除</button>";
                       			 return control+detail;       
                    		},
                		}
		               
					], 
			
					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
					pager : pager_selector,
					altRows: true,
					//toppager: true,
					
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: false,
			
					loadComplete : function() {
						var table = this;
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
			
					editurl: "./dummy.php"
				});

				$(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
				
				

				//enable search/filter toolbar
			
			
				//switch element when editing inline
				function aceSwitch( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=checkbox]')
							.addClass('ace ace-switch ace-switch-5')
							.after('<span class="lbl"></span>');
					}, 0);
				}
				//enable datepicker
				function pickDate( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=text]')
							.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
					}, 0);
				}
			
			jQuery(grid_selector).jqGrid('navGrid',pager_selector,
					{ 
						edit: false,
						editicon : 'ace-icon fa fa-pencil blue',
						add: false,
						addicon : 'ace-icon fa fa-plus-circle purple',
						del: false,
						delicon : 'ace-icon fa fa-trash-o red',
						search: false,
						searchicon : 'ace-icon fa fa-search orange',
						refresh: false,
						refreshicon : 'ace-icon fa fa-refresh green',
						view: false,
						viewicon : 'ace-icon fa fa-search-plus grey',
					});
			
			
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
					
					form.find('input[name=stock]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
							   //don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
							  //.addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
			
							
					//update buttons classes
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
					buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')
					
					buttons = form.next().find('.navButton a');
					buttons.find('.ui-icon').hide();
					buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
					buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');		
				}
			
				function style_delete_form(form) {
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
					buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')
				}
				
				function style_search_filters(form) {
					form.find('.delete-rule').val('X');
					form.find('.add-rule').addClass('btn btn-xs btn-primary');
					form.find('.add-group').addClass('btn btn-xs btn-success');
					form.find('.delete-group').addClass('btn btn-xs btn-danger');
				}
				function style_search_form(form) {
					var dialog = form.closest('.ui-jqdialog');
					var buttons = dialog.find('.EditTable')
					buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
					buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
					buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
				}
				
				function beforeDeleteCallback(e) {
					var form = $(e[0]);
					if(form.data('styled')) return false;
					
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_delete_form(form);
					
					form.data('styled', true);
				}
				
				function beforeEditCallback(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			
			
			
				//it causes some flicker when reloading or navigating grid
				//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
				//or go back to default browser checkbox styles for the grid
				function styleCheckbox(table) {
				/**
					$(table).find('input:checkbox').addClass('ace')
					.wrap('<label />')
					.after('<span class="lbl align-top" />')
			
			
					$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
					.find('input.cbox[type=checkbox]').addClass('ace')
					.wrap('<label />').after('<span class="lbl align-top" />');
				*/
				}
				
			
				//unlike navButtons icons, action icons in rows seem to be hard-coded
				//you can change them like this in here if you want
				function updateActionIcons(table) {
					/**
					var replacement = 
					{
						'ui-ace-icon fa fa-pencil' : 'ace-icon fa fa-pencil blue',
						'ui-ace-icon fa fa-trash-o' : 'ace-icon fa fa-trash-o red',
						'ui-icon-disk' : 'ace-icon fa fa-check green',
						'ui-icon-cancel' : 'ace-icon fa fa-times red'
					};
					$(table).find('.ui-pg-div span.ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
					*/
				}
				
				//replace icons with FontAwesome icons like above
				function updatePagerIcons(table) {
					var replacement = 
					{
						'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
						'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
						'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
						'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
					};
					$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
				}
			
				function enableTooltips(table) {
					$('.navtable .ui-pg-button').tooltip({container:'body'});
					$(table).find('.ui-pg-div').tooltip({container:'body'});
				}
			
				//var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			
				$(document).one('ajaxloadstart.page', function(e) {
					$.jgrid.gridDestroy(grid_selector);
					$('.ui-jqdialog').remove();
				});
			});
		</script>
	</body>
</html>
