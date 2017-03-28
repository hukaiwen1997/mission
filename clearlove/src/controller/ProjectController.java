package controller;



import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Project;
import service.ProjectService;

@Controller
@RequestMapping(value="/Project")
public class ProjectController {
	ProjectService projectService=new ProjectService();
	
	@RequestMapping(value="/getProjects")
	@ResponseBody
	public List<Project>getProjects(){
		return projectService.getAllProjects();
	}
	
	@RequestMapping(value="/addProject")
	public void addProject(
			@RequestParam("proJect") String proJect,
			ModelMap modelmap
			){
		   Project project = new Project();
		   project.setProject(proJect);
		   projectService.addProject(project);
	}
	@RequestMapping(value="/deleteProjectById")
	public void deleteProjectById(Integer id){
		   projectService.deleteProjectById(id);		   
	}
	@RequestMapping(value="/getProjectById")
	public Project getProjectById(Integer id){
		   return projectService.getProjectById(id);
	}
	
	
	
}
