package service;

import java.util.List;


import org.springframework.stereotype.Service;

import entity.Project;

import Dao.ProjectDao;


@Service
public class ProjectService {
    ProjectDao projectDao = new ProjectDao();
	@SuppressWarnings("unchecked")
	public List<Project>getAllProjects() {
		@SuppressWarnings("rawtypes")
		List projects = null;
		try {
			projects= projectDao.findAllProjects();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projects;
	}
	public void addProject(Project project){ 
		projectDao.saveProject(project);
	}
   
    public void deleteProjectById(Integer id){ 
    	projectDao.deleteProjectById(id);
    }
    public Project getProjectById(Integer id){
    	return projectDao.loadProjectById(id);
    }
	/*@Autowired ProjectDao projectDao;
	public List<Project>getProjects(){
		return projectDao.getProjects();
	}
	public void addProject(Project project){ 
		projectDao.addProject(project);
		
	}
	public void deleteProjectById(Integer id){
		projectDao.deleteProjectById(id);
	}
	public Project getProjectById(Integer id){
		return projectDao.getProjectById(id);
	}
	*/
}
