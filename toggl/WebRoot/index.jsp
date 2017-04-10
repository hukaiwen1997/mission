<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% String PROJECTNAME;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
	<link rel="stylesheet" href="css/style.css">
	
    <script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
   
    <script src="js/function.js"></script>
    <script src="jedate/jedate.js"></script>
    
    
    <script>
 $(document).ready(function(){
        $(document).mousedown(function(event){
                    if((event.target.id==""||$("#createnewproject").find("#"+event.target.id).length==0)&&event.target.id!="createnewproject"){
                            $("#createnewproject").hide();
                            $("#support").hide();
                        }
            });
     })
    $(document).ready(function(){
        $(document).mousedown(function(event){
                    if((event.target.id==""||$("#createnewtag").find("#"+event.target.id).length==0)&&event.target.id!="createnewtag"){
                            $("#createnewtag").hide();
                            $("#support1").hide();
                        }
            });
     }) 
 </script>
 
 <link href="css/lyz.calendar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.5.1.js"></script>
<script src="js/lyz.calendar.min.js" type="text/javascript"></script>
<style>
body {
font-size: 12px;
font-family: "微软雅黑", "宋体", "Arial Narrow";
}
</style>
<script>
    $(function () {
        $("#txtBeginDate").calendar({
            controlId: "divDate",                                 // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
            speed: 200,                                           // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
            complement: true,                                     // 是否显示日期或年空白处的前后月的补充,默认：true
            readonly: true,                                       // 目标对象是否设为只读，默认：true
            upperLimit: new Date(),                               // 日期上限，默认：NaN(不限制)
            lowerLimit: new Date("2011/01/01"),                   // 日期下限，默认：NaN(不限制)
            callback: function () {                               // 点击选择日期后的回调函数
                alert("您选择的日期是：" + $("#txtBeginDate").val());
            }
        });
        $("#txtEndDate").calendar();
    });
</script>
 
 
	</head>
	
 
 <body>
 
 <div id="support" style="width: 100%;
height:100% ;
margin: 0px;
padding: 0px;
display:none;
position:absolute;
filter:alpha(Opacity=50);
opacity: 0.5;
background-color:green">
</div>
<div id="support1" style="width: 100%;
height:100% ;
margin: 0px;
padding: 0px;
display:none;
position:absolute;
filter:alpha(Opacity=50);
opacity: 0.5;
background-color:black">
</div>

    <div id="welcome" style="background-color:green; height:100px" >
	<h3 style="text-align:center;font-size:30px">
				Welcome To Toggl!
	</h3>
   </div>
   <div style=" width:500px;">
  <input id="txtBeginDate" style="width:170px;padding:7px 10px;border:1px solid #ccc;margin-right:10px;"/>
  <input id="txtEndDate" style="width:170px;padding:7px 10px;border:1px solid #ccc;" /><br/>
  <button onclick="abc()">确定</button>
  </div>
   <div id="startnewtask">
   <h4 style="font-size:15px">Start a new task!</h4>
    </div> 
  
   
   
   
   <ul>
           <li class="dropdown"><input id="discriptionOfTask" type="text"  value="what are you working on?" /></li>
            <li class="dropdown">
                
                <a id="project" href="javascript:void(0)" class="dropbtn" onclick="showListProject(this)">+Project</a>
                <div class="dropdown-content" id="dropdown-project">  
                 <a href="javascript:void(0)" onclick="showCreatNewProject()">+Create a new Project</a>            
                </div>
            </li>
            <li class="dropdown">
                <a id="tag" href="javascript:void(0)" class="dropbtn" onclick="showListTag(this)">+Tag</a>
                <div class="dropdown-content" id="dropdown-tag">
                    <a href="javascript:void(0)" onclick="showCreatNewTag()">+Create a new Tag</a>
                </div>
                
				
				
            </li>
            <li class="dropdown"><input type="button" value="开始计时！" onClick="StartTaskXMLDoc()"> 
				<input type="text" id="txt"> 
				<input type="button" value="停止计时！" onClick="stopCount()"> 
				
				<input type="button" value="保存记录" onClick="SaveTaskXMLDoc()"> 
				<br/>
				<input style="background-color:green;float:left" id="starttime">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input style="background-color:green;float:left;margin-left:10px" id="endtime">
				</li>
        </ul>
        
   
        <div id="createnewproject"  style="border:1px solid red;
        width:500px;height:380px;
        position:absolute;
        left:50%;
        margin-left:-250px;
        top:50%;
        margin-top:-190px;
        display:none">
        <h3 id="h3" style="text-align:center">Create a new project!</h3><br/><br/><br/><br/><br/>
        <input id="projectname" type="text"  value="Create a new project" />&nbsp;&nbsp;&nbsp;
        <button id="button" onclick="CreatNewProjectXMLDoc()" >确定</button>
        </div>
        
        
        <div id="createnewtag"  style="border:1px solid red;
        width:500px;height:380px;
        position:absolute;
        left:50%;
        margin-left:-250px;
        top:50%;
        margin-top:-190px;
        display:none">
        <h3 id="H3" style="text-align:center">Create a new tag!</h3><br/><br/><br/><br/><br/>
        <input id="tagname" type="text"  value="Create a new tag" />&nbsp;&nbsp;&nbsp;
        <button id="Button" onclick="CreatNewTagXMLDoc()" >确定</button>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <div id="showTasks">
         <ul>
   <li class="dropdown">                   
                <a  href="javascript:void(0)" class="dropbtn" >记录描述</a>                            
   </li>
   <li class="dropdown">                   
                <a  href="javascript:void(0)" class="dropbtn" >记录分类</a>                            
   </li>
   <li class="dropdown">                   
                <a  href="javascript:void(0)" class="dropbtn" >标签</a>                            
   </li>
    <li class="dropdown">                   
                <a  href="javascript:void(0)" class="dropbtn" style="margin-left:30px">开始时间</a>                            
   </li>
    <li class="dropdown">                   
                <a  href="javascript:void(0)" class="dropbtn" style="margin-left:40px">结束时间</a>                            
   </li>
   </ul>
        </div>


 
 
 
  </body>

</html>
