<script type="text/javascript">
    try{ace.settings.loadState('main-container')}catch(e){}
</script>

<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li id="dashboard" class="">
            <a href="index.ftl">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text"> Dashboard </span>
            </a>

            <b class="arrow"></b>
        </li>



        <li id="workspace" class="">
            <a href="${basePath.getContextPath()}/workspace/index.jsp">
                <i class="menu-icon fa fa-list-alt"></i>
                <span class="menu-text"> 工作区 </span>
            </a>

            <b class="arrow"></b>
        </li>


        <li id="jarmanager" class="active">
            <a href="${basePath.getContextPath()}/jarmanager/index.jsp">
                <i class="menu-icon fa fa-list-alt"></i>
                <span class="menu-text"> jar包管理 </span>
            </a>
            <b class="arrow"></b>
        </li>


        <li id="dubboservice" class="">
            <a href="${basePath.getContextPath()}/dubboservice/index.jsp">
                <i class="menu-icon fa fa-list-alt"></i>
                <span class="menu-text"> dubbo服务列表 </span>
            </a>
            <b class="arrow"></b>
        </li>

        <li id="remotecall" class="">
            <a href="${basePath.getContextPath()}/remotecall/index.jsp">
                <i class="menu-icon fa fa-list-alt"></i>
                <span class="menu-text"> 服务调用记录表 </span>
            </a>
            <b class="arrow"></b>
        </li>
    </ul><!-- /.nav-list -->

    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>