<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<c:url value='/csstree/zTreeStyle.css'/>" type="text/css">
    <link rel="stylesheet" href="../boot3/css/bootstrap.min.css">
    <!-- tree.js 树的js文件，jquery不能删，jquery和tree的结合的 -->
    <script type="text/javascript" src="<c:url value='/js/tree.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.ztree.all-3.3.js'/>"></script>

    <script type="text/javascript">

        var setting={
            view:{
                showLine:true//是否显示线，默认为true
            },
            data:{
                key:{
                    name:"pname"
                },
                simpleData:{
                    enable:true,//开启树的层级结构
                    idKey:"id",//设置树节点id，节点参数id必须与之相匹配，即在Actiob中穿过来的值必须与之相对应
                    pIdKey:"pid"//设置pid，节点参数pid必须与之相匹配
                }
            },
            check:{
                enable:true
            },
            callback:{
                onClick:zTreeClick//定义节点点击的事件为单击事件
            }
        };

        var zNodes =${json};//struts2的特性，通过el表达式从java代码中读取zTree节点数据，json必须与从Action中传过来的参数是一样的

        var currentSelectedNode; //定义全局变量  查看当前节点

        //得到当前点击节点的信息，并将id赋值给将要添加节点的pid
        function zTreeClick(event, treeId, treeNode) {
            var treeObj = $.fn.zTree.getZTreeObj("treeClass");
            currentSelectedNode = treeObj.getNodeByTId(treeNode.tId);
            var path =currentSelectedNode.url;
            parent.frames[3].location.href = path;
        };
        $(document).ready(function(){
            $.fn.zTree.init($("#treeClass"),setting,zNodes);
        });
    </script>
    <script>
        function savequanxian() {
            var treeObj = $.fn.zTree.getZTreeObj("treeClass");
            var check=treeObj.getCheckedNodes(true);
            var ids="";
            for (var i = 0; i <check.length ; i++) {
                ids+=check[i].id+","
            }
            if (ids.length==0){
                if (window.confirm("该职位没有选择权限，您确定要提交吗")) {
                    $("[name=ids]").val(ids);
                    document.forms[0].submit();
                }
            }else {
                    ids=ids.substring(0,ids.length-1);
                    $("[name=ids]").val(ids);
                    document.forms[0].submit();
            }

        }
    </script>
</head>
<body>

<form class="form-inline" action="/saveQuanXian.do" method="post">
    <div class="form-group">
        <label>编号</label>
        <input type="text" name="rid" value="${rid}" class="form-control" >
    </div>
    <div class="form-group">
        <label>获取的权限编号</label>
        <input type="email" name="ids" class="form-control">
    </div>
    <input type="button" onclick="savequanxian()" value="保存" class="btn btn-link">
    </form>
<div id="nodes">
    <ul id="treeClass" class="ztree"></ul>
</div>
</body>

</html>