/**
 * Created by jetty on 18/7/11.
 */
function login(){
    var loginName=$("#loginName").val();
    var password=$("#password").val();
    if(loginName =='' || loginName ==null){
        alert("用户名不能为空");
        return;
    }

    $.ajax({
        cache:false,
        type:"POST",//为post请求
        url:"/login.json",//这是我在后台接受数据的文件名
        data:{
            "loginName":loginName,
            "password":password
        },//将该表单序列化
        async:false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
        error:function(request){//请求失败之后的操作
            bootbox.alert("请求出错后台登录出错");
            return;
        },
        success:function(data){//请求成功之后的操作

            if(data.code=='000000'){
                window.location.href="/index.jsp";
            }else if(data.code=='100004'){
                alert("用户名不能为空");
                return;
            }else if(data.code=='100008'){
                alert("用户不存在");
                return;
            }else if(data.code=='100009'){
               alert("密码出错");
                return;
            }else{
                alert("系统出错,请稍后重试！");
            }
        }
    });


    function alert(message){
        bootbox.alert({
            size: "small",
            title: "登录失败",
            message: message,
            callback: function(){ /* your callback code */ }
        })
    }

}