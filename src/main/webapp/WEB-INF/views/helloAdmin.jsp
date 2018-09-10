<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>消息选择发送器</title>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"> </script>
</head>

<body>
    <table>
        <tr><td><span>请求路径</span></td><td><input type="text" id="paramUrl" name="paramUrl" placeholder="请求路径"></td></tr>
        <tr><td><span>交互机名</span></td><td><input type="text" id="exchangeName" name="exchangeName" placeholder="交互机名"></td></tr>
        <tr><td><span>路由名称</span></td><td><input type="text" id="queueName" name="queueName" placeholder="路由名称"></td></tr>
        <tr><td><span>消息内容</span></td><td><input type="text" id="massageContent" name="massageContent" placeholder="消息内容"></td></tr>
        <tr><td><button onclick="save()">登录</button></td></tr>
    </table>
</body>
<script type="text/javascript">
    function save() {
        console.log("提交数据");
        var params = {};
        params.paramUrl = $("#paramUrl").val();
        params.exchangeName = $("#exchangeName").val();
        params.queueName = $("#queueName").val();
        params.massageContent = $("#massageContent").val();
        console.log("params数据：", JSON.stringify(params));
        $.ajax({
            url:'http://127.0.0.1:8081/hello/jspController',
            // data: params.serialize(),
            data: JSON.stringify(params),
            type: "POST",
            contentType: "application/json;charset=utf-8;",
            success:function(data){
                if(data.success){
                    alert(data.message);
                } else {
                    alert("请求失败！"+ data.message);
                }
            },
            error:function(){
                alert("请求失败")
            }
        });
    }
</script>
</html>
