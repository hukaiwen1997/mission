/*-------------------------*/
/*-------------------------*/
var PROJECTS;
var TAGS;
var TASKS;
var PROJECTSLength=0;
var TAGSLength=0;
var TASKSLength=0; 
var t ;
var second_1=0;
var min_1 = 0;
var min_2 = 0;
var hour_1 = 0;
var hour_2 = 0;
var second_2 = 0;
var c;
var lasttime=0;
addLoadEvent(ShowTagsXMLDoc);
addLoadEvent(ShowProjectsXMLDoc);
addLoadEvent(ShowTasksXMLDoc);
addLoadEvent(showListTask);
addLoadEvent(makeListProject);
addLoadEvent(makeListTag);

function addLoadEvent(func) {  
	  var oldonload = window.onload;  
	  if (typeof window.onload != 'function') {  
	    window.onload = func;  
	  } else {  
	    window.onload = function() {  
	      if (oldonload) {  
	        oldonload();  
	      }  
	      func();  
	    }  
	  }  
	}  
/*-------------------*/
/*-------------------*/
function getPROJECTSLength(){
    var jsonLength=0;
    
    for (var i in PROJECTS) {
        jsonLength++;
    }
  
    return jsonLength;
}
function getTAGSLength(){
    var jsonLength=0;
    for (var i in TAGS) {
        jsonLength++;
    }
    return jsonLength;
}
function getTASKSLength(){
    var jsonLength=0;
    for (var i in TASKS) {
        jsonLength++;
    }
    return jsonLength;
}

/*------------------*/
/*------------------*/
function timedCount() 
{ 
	
if(second_1>9){
	second_2 = second_2+1;
	second_1=0;
}	

if(second_2>5){
	min_1 = min_1+1;
	second_2=0;
}

if(min_1>9){
	min_2=min_2+1;
	min_1=0;
}

if(min_2>5){
	hour_1=hour_1+1;
	min_2=0;
}

if(hour_1>9){
	hour_2=hour_2+1;
	hour_1=0;
}

 c="用时:"+hour_2+hour_1+":"+min_2+min_1+":"+second_2+second_1;
 
document.getElementById('txt').value=c ;
second_1=second_1+1 ;
t=setTimeout("timedCount()",1000) ;
} 
/*------------------*/
/*------------------*/
function stopCount() 
{ 
	
clearTimeout(t) ;

var data = getNowFormatDate();
document.getElementById("endtime").value=data;
} 
/*-------------------*/
/*-------------------*/
function makeListProject(){
	var xmlhttp;



	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		  for(i=0;PROJECTS[i];i++)
			{
			var dropdowns = document.getElementById("dropdown-project");
			var element1 = document.createElement("a");
		    element1.href="javascript:void(0)";
		    element1.innerText = PROJECTS[i].projectName;
		    var value="document.getElementById('project').innerText ='"+PROJECTS[i].projectName+"'";
		    element1.setAttribute("onclick", value);    
		    dropdowns.appendChild(element1);
			}  
	  }
	    
	  }
	xmlhttp.open("GET","/toggl/Task/getTasks",true);

	xmlhttp.send();
	
}
/*------------------*/
/*------------------*/
function makeListTag(){
	var xmlhttp;



	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		  for(i=0;TAGS[i];i++)
			{
			var dropdowns = document.getElementById("dropdown-tag");
			var element1 = document.createElement("a");
		    element1.href="javascript:void(0)";
		    element1.innerText = TAGS[i].tagName;
		    var value="document.getElementById('tag').innerText ='"+TAGS[i].tagName+"'";
		    element1.setAttribute("onclick", value);
		    dropdowns.appendChild(element1);
			}  
	  }
	    
	  }
	xmlhttp.open("GET","/toggl/Task/getTasks",true);

	xmlhttp.send();
	
}
/*------------------*/
/*-------------------*/
function showListProject(o) {	
    hideList("dropdown-content" + o.id);
    document.getElementById("dropdown-" + o.id).classList.toggle("show");
}
 /*-------------------------*/
/*------------------------*/
function showListTag(o) {
	
    hideList("dropdown-content" + o.id);
    document.getElementById("dropdown-" + o.id).classList.toggle("show");
}
 /*------------------*/
/*--------------------*/

function hideList(option) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
     
    for (var i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        if (openDropdown.id != option) {
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}
 
/*---------------------*/
/*---------------------*/
window.onclick = function(e) {
    if (!e.target.matches('.dropbtn')) {
        hideList("");
    }
}
/*--------------------*/
/*--------------------*/

function StartTaskXMLDoc()
{
var xmlhttp;



if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200){
	  timedCount();
	  var data =getNowFormatDate();
	  document.getElementById("starttime").value=data;
  }
    
  }
xmlhttp.open("GET","/toggl/Task/getTasks",true);

xmlhttp.send();



}

/*-------------------------*/
/*-------------------------*/
function SaveTaskXMLDoc()
{
var xmlhttp;
var discriptionOftask=document.getElementById("discriptionOfTask").value;
var projectname=document.getElementById("project").innerText;
var tagname=document.getElementById("tag").innerText;
var starttime=document.getElementById("starttime").value;
var endtime=document.getElementById("endtime").value;
var length;
hour_2=endtime[11]-starttime[11];
hour_1=endtime[12]-starttime[12];
min_2=endtime[14]-starttime[14];
min_1=endtime[15]-starttime[15];
second_2=endtime[17]-starttime[17];
second_1=endtime[18]-starttime[18];
var lasttime = second_1+second_2*10+min_1*60+min_2*600+hour_1*3600+hour_2*36000;
second_1 = 0;
second_2 = 0;
min_1 = 0;
min_2 = 0;
hour_1 = 0;
hour_2 = 0;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200){
	  
	  var ID = xmlhttp.responseText;
	  var add = {id:ID,discriptionOfTask:discriptionOftask,projectName:projectname,tagName:tagname,startTime:starttime,endTime:endtime,lastTime:lasttime};

	  TASKS.push(add);


	  length=getTASKSLength();
	  		var dropdowns = document.getElementById("showTasks");	
	  		var element = document.createElement("div");
	  		element.setAttribute("id", TASKS[length-1].id);
	  		dropdowns.appendChild(element);
	  		
	  		var element0=document.createElement("ul");
	  		element.appendChild(element0);				
	  		var element1=document.createElement("li");
	  		element1.setAttribute("class", "dropdown");
	  		element0.appendChild(element1);
	  		var element2 = document.createElement("input");	
	  		var inputid="input"+TASKS[length-1].id;
	  		element2.setAttribute("id", inputid);
	  		element2.setAttribute("type", "text");
	  		element2.setAttribute("value", TASKS[length-1].discriptionOfTask);
	  		element2.setAttribute("style", "background-color:green");
	  		element1.appendChild(element2);
	  		/*var button0 = document.createElement("button");
	  		var button0id = "button0-"+TASKS[i].id;
	  		button0.setAttribute("id", button0id);
	  		var button0onclick=""*/
	  		var element3 = document.createElement("a");
	  		var aid = "project"+TASKS[length-1].id;
	  		element3.setAttribute("id", aid);
	  		element3.href="javascript:void(0)";
	  		element3.innerText = TASKS[length-1].projectName;
	  		element3.setAttribute("class", "dropbtn");
	  		element3.setAttribute("style", "margin-left:20px");
	  		
	  		element1.appendChild(element3);
	  		var element4 = document.createElement("div");
	  		element4.setAttribute("class", "dropdown-content");
	  		var dropdownprojectid="dropdown-project"+TASKS[length-1].id;		    
	  		element4.setAttribute("id",dropdownprojectid );
	  		
	  		element3.setAttribute("onclick", "showListProjectofTask(this)");
	  		element1.appendChild(element4);
	  		
	  		makeListProjectofTask(aid,dropdownprojectid);
	  		/*-----------------*/
	  		var element5=document.createElement("li");
	  		element5.setAttribute("class", "dropdown");
	  		element0.appendChild(element5);
	  		
	  		var element6 = document.createElement("a");
	  		var bid = "tag"+TASKS[length-1].id;
	  		element6.setAttribute("id", bid);
	  		element6.href="javascript:void(0)";
	  		element6.innerText = TASKS[length-1].tagName;
	  		element6.setAttribute("class", "dropbtn");
	  		
	  		element5.appendChild(element6);
	  		var element7 = document.createElement("div");
	  		element7.setAttribute("class", "dropdown-content");
	  		var dropdowntagid="dropdown-tag"+TASKS[length-1].id;
	  		element7.setAttribute("id",dropdowntagid );
	  		
	  		element6.setAttribute("onclick", "showListTagofTask(this)");
	  		element5.appendChild(element7);
	  		makeListTagofTask(bid,dropdowntagid);
	  		
	  		var element8=document.createElement("li");
	  		element8.setAttribute("class", "dropdown");
	  		element0.appendChild(element8);
	  		var starttime1 = document.createElement("p");
	  		var starttime1id="starttime1"+TASKS[length-1].id;
	  		starttime1.setAttribute("style", "background-color:green;float:left;margin-left:60px");
	  		starttime1.setAttribute("id", starttime1id);
	  		starttime1.innerHTML=starttime;
	  		
	  		var endtime1 = document.createElement("p");
	  		var endtime1id = "endtime1"+TASKS[length-1].id;
	  		endtime1.setAttribute("style", "background-color:green;float:left;margin-left:90px");
	  		endtime1.setAttribute("id", endtime1id);
	  		endtime1.innerHTML=endtime;
	  		element8.appendChild(starttime1);
	  		element8.appendChild(endtime1);
	  		var element9=document.createElement("button");
	  		var updateid = "update"+TASKS[length-1].id;
	  		element9.innerHTML="修改";
	  		element9.setAttribute("id",updateid);
	  		element9.setAttribute("style","margin-left:20px");
	  		var updatevalue="updateTaskById('"+TASKS[length-1].id+"')";
	  		element9.setAttribute("onclick",updatevalue);
	  		element8.appendChild(element9);
	  		
	  		var element10=document.createElement("button");
	  		var deleteid = "delete"+TASKS[length-1].id;
	  		element10.innerHTML="删除";
	  		element10.setAttribute("id",deleteid);
	  		element10.setAttribute("style","margin-left:20px");
	  		var deletevalue="deleteTaskById('"+TASKS[length-1].id+"')";
	  		element10.setAttribute("onclick",deletevalue);
	  		element8.appendChild(element10);

	  
  }

    
  }
xmlhttp.open("POST","/toggl/Task/addTask",true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("startTime="+starttime+"&endTime="+endtime+"&discriptionOfTask="+discriptionOftask+"&projectName="+projectname+"&tagName="+tagname+"&lastTime="+lasttime);

document.getElementById("discriptionOfTask").value="what are you working on?";
document.getElementById("project").innerText="+Project";
document.getElementById("tag").innerText="+Tag";
document.getElementById("starttime").value="";
document.getElementById("endtime").value="";
document.getElementById("txt").value="";


}
/*-------------------------*/
/*-------------------------*/
function ShowProjectsXMLDoc()
{
	
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200){
     var result = xmlhttp.responseText;
     var json = JSON.parse(result);
     PROJECTS = json;    
  }
  }

xmlhttp.open("GET","/toggl/Project/getProjects",true);
xmlhttp.send();

}
/*-------------------------*/
/*-------------------------*/
function CreatNewProjectXMLDoc()
{
var xmlhttp;
var length;
var projectname = document.getElementById("projectname").value;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200);
	 

  }

xmlhttp.open("POST","/toggl/Project/addProject",true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("projectName="+projectname);
document.getElementById("createnewproject").style.display="none";
document.getElementById("support").style.display="none";
document.getElementById("project").innerText=projectname;
var add = {projectName :projectname};



//document.write(add.projectName);
PROJECTS.push(add);


length=getPROJECTSLength();

//PROJECTS[length].projectName=projectName;

	var dropdowns1 = document.getElementById("dropdown-project");
	var element1 = document.createElement("a");
  element1.href="javascript:void(0)";
  element1.innerText = PROJECTS[length-1].projectName;
  
  var value="document.getElementById('project').innerText ='"+PROJECTS[length-1].projectName+"'";
  element1.setAttribute("onclick", value);    
  dropdowns1.appendChild(element1);


  for(i=0;TASKS[i];i++)
	{	  
    var dropdownprojectid="dropdown-project"+TASKS[i].id;    
	var dropdowns = document.getElementById(dropdownprojectid);	
	var element = document.createElement("a");	
  element.href="javascript:void(0)";    
  element.innerText = PROJECTS[length-1].projectName;  
  var value1="document.getElementById('"+"project"+TASKS[i].id+"').innerText ='"+PROJECTS[length-1].projectName+"'";      
  element.setAttribute("onclick", value1);   
  dropdowns.appendChild(element);    
	}  
}
/*-------------------------*/
/*-------------------------*/
function showCreatNewProject(){
	document.getElementById("createnewproject").style.display="block";
	document.getElementById("support").style.display="block";
}
/*-----------------------------*/
/*-----------------------------*/
function ShowTagsXMLDoc(o)
{
var xmlhttp;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200){
     var result = xmlhttp.responseText;
     var json = JSON.parse(result);
     TAGS = json;
     
  }
  }

xmlhttp.open("GET","/toggl/Tag/getTags",true);
xmlhttp.send();

}
/*-------------*/
/*--------------*/
function CreatNewTagXMLDoc()
{
var xmlhttp;
var tagname = document.getElementById("tagname").value;
var length;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200);
    
  }
xmlhttp.open("POST","/toggl/Tag/addTag",true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("tagName="+tagname);
document.getElementById("createnewtag").style.display="none";
document.getElementById("support1").style.display="none";
document.getElementById("tag").innerText=tagname;

var add = {tagName :tagname};



//document.write(add.projectName);
TAGS.push(add);


length=getTAGSLength();

//PROJECTS[length].projectName=projectName;

	var dropdowns1 = document.getElementById("dropdown-tag");
	var element1 = document.createElement("a");
element1.href="javascript:void(0)";
element1.innerText = TAGS[length-1].tagName;

var value="document.getElementById('tag').innerText ='"+TAGS[length-1].tagName+"'";
element1.setAttribute("onclick", value);    
dropdowns1.appendChild(element1);


for(i=0;TASKS[i];i++)
	{	  
  var dropdowntagid="dropdown-tag"+TASKS[i].id;    
	var dropdowns = document.getElementById(dropdowntagid);	
	var element = document.createElement("a");	
element.href="javascript:void(0)";    
element.innerText = TAGS[length-1].tagName;  
var value1="document.getElementById('"+"tag"+TASKS[i].id+"').innerText ='"+TAGS[length-1].tagName+"'";      
element.setAttribute("onclick", value1);   
dropdowns.appendChild(element);    
	}  
}
/*----------------------*/
/*-----------------------*/
function showCreatNewTag(){
	document.getElementById("createnewtag").style.display="block";
	document.getElementById("support1").style.display="block";
}
/*-----------------------*/
/*-----------------------*/
function ShowTasksXMLDoc()
{
var xmlhttp;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200){
     var result = xmlhttp.responseText;
     var json = JSON.parse(result);
    
     TASKS = json;    
     
  }
  }

xmlhttp.open("GET","/toggl/Task/getTasks",true);
xmlhttp.send();

}
/*--------------*/
/*--------------*/
function showListTask(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		  for(i=0;TASKS[i];i++)
			{
				
			var dropdowns = document.getElementById("showTasks");	
			var element = document.createElement("div");
		    element.setAttribute("id", TASKS[i].id);
		    dropdowns.appendChild(element);
		    
			var element0=document.createElement("ul");
			element.appendChild(element0);				
			var element1=document.createElement("li");
			element1.setAttribute("class", "dropdown");
			element0.appendChild(element1);
		    var element2 = document.createElement("input");	
		    var inputid="input"+TASKS[i].id;
		    element2.setAttribute("id", inputid);
		    element2.setAttribute("type", "text");
		    element2.setAttribute("value", TASKS[i].discriptionOfTask);
		    element2.setAttribute("style", "background-color:green");
		    element1.appendChild(element2);
		    /*var button0 = document.createElement("button");
		    var button0id = "button0-"+TASKS[i].id;
		    button0.setAttribute("id", button0id);
		    var button0onclick=""*/
		    var element3 = document.createElement("a");
		    var aid = "project"+TASKS[i].id;
		    element3.setAttribute("id", aid);
		    element3.href="javascript:void(0)";
		    element3.innerText = TASKS[i].projectName;
		    element3.setAttribute("class", "dropbtn");
		    element3.setAttribute("style", "margin-left:20px");
		   
		    element1.appendChild(element3);
		    var element4 = document.createElement("div");
		    element4.setAttribute("class", "dropdown-content");
		    var dropdownprojectid="dropdown-project"+TASKS[i].id;		    
		    element4.setAttribute("id",dropdownprojectid );
		   
		    element3.setAttribute("onclick", "showListProjectofTask(this)");
		    element1.appendChild(element4);
		    
		    makeListProjectofTask(aid,dropdownprojectid);
		    /*-----------------*/
		    var element5=document.createElement("li");
			element5.setAttribute("class", "dropdown");
			element0.appendChild(element5);
		    
		    var element6 = document.createElement("a");
		    var bid = "tag"+TASKS[i].id;
		    element6.setAttribute("id", bid);
		    element6.href="javascript:void(0)";
		    element6.innerText = TASKS[i].tagName;
		    element6.setAttribute("class", "dropbtn");
		    
		    element5.appendChild(element6);
		    var element7 = document.createElement("div");
		    element7.setAttribute("class", "dropdown-content");
		    var dropdowntagid="dropdown-tag"+TASKS[i].id;
		    element7.setAttribute("id",dropdowntagid );
		   
		    element6.setAttribute("onclick", "showListTagofTask(this)");
		    element5.appendChild(element7);
		    makeListTagofTask(bid,dropdowntagid);
		    
		    var element8=document.createElement("li");
			element8.setAttribute("class", "dropdown");
			element0.appendChild(element8);
		    var starttime = document.createElement("p");
		    var starttimeid = "starttime1"+TASKS[i].id;
		    starttime.setAttribute("style", "background-color:green;float:left;margin-left:60px");
		    starttime.setAttribute("id", starttimeid);
		    starttime.innerHTML=TASKS[i].startTime;
		    var endtime = document.createElement("p");
            var endtimeid="endtime1"+TASKS[i].id;
		    endtime.setAttribute("style", "background-color:green;float:left;margin-left:90px");
		    endtime.setAttribute("id", endtimeid);
		    endtime.innerHTML=TASKS[i].endTime;
		    element8.appendChild(starttime);
		    element8.appendChild(endtime);
		    
		    var element9=document.createElement("button");
	  		var updateid = "update"+TASKS[i].id;
	  		element9.innerHTML="修改";
	  		element9.setAttribute("id",updateid);
	  		element9.setAttribute("style","margin-left:20px");
	  		
	  		var updatevalue="updateTaskById('"+TASKS[i].id+"')";
	  		element9.setAttribute("onclick",updatevalue);
	  		element8.appendChild(element9);

	  		var element10=document.createElement("button");
	  		var deleteid = "delete"+TASKS[i].id;
	  		element10.innerHTML="删除";
	  		element10.setAttribute("id",deleteid);
	  		element10.setAttribute("style","margin-left:20px");
	  		
	  		var deletevalue="deleteTaskById('"+TASKS[i].id+"')";
	  		element10.setAttribute("onclick",deletevalue);
	  		element8.appendChild(element10);
	  		
			}
		    
	  }
	  }

	xmlhttp.open("GET","/toggl/Task/getTasks",true);
	xmlhttp.send();
	
	
}
/*------------------------*/
/*------------------------*/
function makeListProjectofTask(aid,dropdownprojectid){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    var dropdown1 = document.getElementById(dropdownprojectid);	
			var element1 = document.createElement("a");	
		    element1.href="javascript:void(0)";    
		    element1.innerText = "+Create a new project";  		        
		    element1.setAttribute("onclick", "showCreatNewProject()");   
		    dropdown1.appendChild(element1);   
		  
    for(i=0;PROJECTS[i];i++)
	{
    
	var dropdowns = document.getElementById(dropdownprojectid);	
	var element = document.createElement("a");	
    element.href="javascript:void(0)";    
    element.innerText = PROJECTS[i].projectName;  
    var value="document.getElementById('"+aid+"').innerText ='"+PROJECTS[i].projectName+"'";      
    element.setAttribute("onclick", value);   
    dropdowns.appendChild(element);    
	}  
    //document.write(PROJECTS[0].projectName);
	  }
	  }

	xmlhttp.open("GET","/toggl/Task/getTasks",true);
	xmlhttp.send();
	
}
/*------------------------*/
/*------------------------*/
function showListProjectofTask(o){
	
	
    hideList("dropdown-content" + o.id);   
    document.getElementById("dropdown-" + o.id).classList.toggle("show");
    //document.write(PROJECTS[0].projectName);
	 
	
}
/*------------------------*/
/*---------------------------*/
function makeListTagofTask(bid,dropdowntagid){
    
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    var dropdown1 = document.getElementById(dropdowntagid);	
			var element1 = document.createElement("a");	
		    element1.href="javascript:void(0)";    
		    element1.innerText = "+Create a new tag";  		        
		    element1.setAttribute("onclick", "showCreatNewTag()");   
		    dropdown1.appendChild(element1); 
    for(i=0;TAGS[i];i++)
	{
    
	var dropdowns = document.getElementById(dropdowntagid);	
	var element = document.createElement("a");	
    element.href="javascript:void(0)";    
    element.innerText = TAGS[i].tagName;  
    var value="document.getElementById('"+bid+"').innerText ='"+TAGS[i].tagName+"'";      
    element.setAttribute("onclick", value);   
    dropdowns.appendChild(element);    
	}  
    
   
    //document.write(PROJECTS[0].projectName);
	  }
	  }

	xmlhttp.open("GET","/toggl/Task/getTasks",true);
	xmlhttp.send();
	
	
}
/*-------------------------*/
/*-------------------------*/
        
function showListTagofTask(o){
	        
    hideList("dropdown-content" + o.id);   
    document.getElementById("dropdown-" + o.id).classList.toggle("show");
    //document.write(PROJECTS[0].projectName);
	  
	
	
}
/*--------------------*/
/*--------------------*/
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var strHours =date.getHours();
    var strMinutes = date.getMinutes();
    var strSeconds = date.getSeconds();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if (strHours >= 0 && strHours <= 9) {
        strHours = "0" + strHours;
    }
    if (strMinutes >= 0 && strMinutes <= 9) {
        strMinutes = "0" + strMinutes;
    }
    if (strSeconds >= 0 && strSeconds <= 9) {
        strSeconds = "0" + strSeconds;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + strHours + seperator2 + strMinutes
            + seperator2 + strSeconds;
    return currentdate;
}
/*-----------------------*/
/*------------------------*/
function abc(){
	
	var BeginDate = document.getElementById("txtBeginDate").value;
	var EndDate = document.getElementById("txtEndDate").value;
	
	var k;
	var m = 1;
	var totaltime=0;
	
	var length=getPROJECTSLength();
	var arr1 = new Array(length);
	for(i=0;i<length;i++){
		arr1[i]= 0 ;
	}
	for(i=0;TASKS[i];i++){
		
		w=TASKS[i].startTime.indexOf(" ");
		var startTime=TASKS[i].startTime.substring(0, w);
		k=dateCompare(BeginDate,EndDate,startTime);
		
		if(k==0){
			alert("日期选择错误，请重新选择");
			m=0;
			break;
		}
		if(k==1){
			totaltime = totaltime + TASKS[i].lastTime;
			for(j=0;PROJECTS[j];j++){
				if(PROJECTS[j].projectName==TASKS[i].projectName){
					arr1[j]=arr1[j]+TASKS[i].lastTime;
				}
			}
		}
	}
	
	if(totaltime==0){
		if(m==1){
			var information = "from "+BeginDate+" to "+EndDate+" totaltime: "+totaltime+" 。you spend ";
			for(i=0;PROJECTS[i];i++){
				information = information+arr1[i]+"%" +" on "+PROJECTS[i].projectName+", ";
			}
			alert(information);
			}
	}
	if(totaltime!=0){
	if(m==1){
	var information = "from "+BeginDate+" to "+EndDate+" totaltime: "+totaltime+" 。you spend ";
	for(i=0;PROJECTS[i];i++){
		arr1[i]=arr1[i]*100/totaltime;
		information = information+arr1[i]+"%" +" on "+PROJECTS[i].projectName+", ";
	}
	alert(information);
	}
	}
	
}
/*-----------------------*/
/*-----------------------*/
function dateCompare(date1,date2,date3){
	date1 = date1.replace(/\-/gi,"/");
	date2 = date2.replace(/\-/gi,"/");
	date3 = date3.replace(/\-/gi,"/");
	var time1 = new Date(date1).getTime();
	var time2 = new Date(date2).getTime();
	var time3 = new Date(date3).getTime();
	if(time1 > time2){
		return 0;
	}else if(time1 == time2){
		if(time1 == time3){
			return 1;
		}
		else {
			return 2;
		}
	}else{
		if(time1<=time3&&time3<=time2){
			return 1;
			}
		else{
			return 2;
		}
	}
}
/*---------------------*/
/*---------------------*/
function updateTaskById(id){
	
	var xmlhttp;
	var disid="input"+id;
	var pid="project"+id;
	var tid="tag"+id;
	var startid="starttime1"+id;
	var endid="endtime1"+id;
	var discriptionOftask = document.getElementById(disid).value;	
	
	var projectname = document.getElementById(pid).innerText;	
	
	var tagname = document.getElementById(tid).innerText;
	
	var starttime=document.getElementById(startid).innerHTML;
	
	var endtime=document.getElementById(endid).innerHTML;
	
	for(i=0;TASKS[i];i++){
		if(TASKS[i].id==id){
			var lasttime=TASKS[i].lastTime;
			break;
		}
	}
	
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200);
		   
    
   
    
	  
	  }

	xmlhttp.open("POST","/toggl/Task/updateTask",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id="+id+"&discriptionOfTask="+discriptionOftask+"&projectName="+projectname+"&tagName="+tagname+"&startTime="+starttime+"&endTime="+endtime+"&lastTime="+lasttime);
	
	
}
/*--------------------*/
/*--------------------*/
function deleteTaskById(id){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200);
		 
		  
	
  
 
  
	  
	  }

	xmlhttp.open("POST","/toggl/Task/deleteTaskById",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id="+id);
	
	var my = document.getElementById(id);
	my.parentNode.removeChild(my);
	  
	  
}