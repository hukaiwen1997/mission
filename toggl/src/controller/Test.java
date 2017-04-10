package controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Project;

import service.ProjectService;


@Controller
@RequestMapping(value="/clear")
public class Test {
	@RequestMapping(value = "/register",method = RequestMethod.POST)//当访问/user/register链接时，执行该方法
	public String register(
			@RequestParam("projectName") String projectName,//对应index.jsp中的userName，传值
			ModelMap modelmap//传递对象到jsp界面，modelmap类似Map，可以参考register.jsp查看如何使用
			){
		Project project = new Project();
		project.setProjectName(projectName);
		
		modelmap.addAttribute("project", project);//类似Map的用法
		ProjectService projectService = new ProjectService();
		projectService.addProject(project);
		return "register";//跳转到/WEB-INF/register.jsp
	}
}
