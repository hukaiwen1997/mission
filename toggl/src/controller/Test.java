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
	@RequestMapping(value = "/register",method = RequestMethod.POST)//������/user/register����ʱ��ִ�и÷���
	public String register(
			@RequestParam("projectName") String projectName,//��Ӧindex.jsp�е�userName����ֵ
			ModelMap modelmap//���ݶ���jsp���棬modelmap����Map�����Բο�register.jsp�鿴���ʹ��
			){
		Project project = new Project();
		project.setProjectName(projectName);
		
		modelmap.addAttribute("project", project);//����Map���÷�
		ProjectService projectService = new ProjectService();
		projectService.addProject(project);
		return "register";//��ת��/WEB-INF/register.jsp
	}
}
