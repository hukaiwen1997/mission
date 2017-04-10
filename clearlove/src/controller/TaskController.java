package controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProjectService;
import service.TagService;
import service.TaskService;
import entity.Task;

@Controller
@RequestMapping(value="/Task")
public class TaskController {
	TaskService taskService = new TaskService();
	ProjectService projectService=new ProjectService();
	TagService tagService = new TagService();
	@RequestMapping(value="/getTasks")
	@ResponseBody
	public List<Task>getTasks(){
		return taskService.getTasks();
	}
	@RequestMapping(value="/addTask")
	public void addTask(
			@RequestParam("discriptionOfTask") String discriptionOfTask,
			@RequestParam(value="projectId", required=false) Integer projectId,
			@RequestParam(value="tagId",required=false) Integer tagId,
			ModelMap modelmap
			){ 
		 Task task = new Task();
		 task.setDiscriptionOfTask(discriptionOfTask);
		 task.setProject(projectService.getProjectById(projectId));
		 task.setTag(tagService.getTagById(tagId));
		 modelmap.addAttribute("task", task);   
		 taskService.addTask(task);
	}
	/*@RequestMapping(value="/updateTask")
	public void updateTask(
			@RequestParam("discriptionOfTask") String discriptionOfTask,
			@RequestParam(value="projectId", required=false) Integer projectId,
			@RequestParam(value="tagId",required=false) Integer tagId,
			ModelMap modelmap,
			Task task
			){ 
		 
		 task.setDiscriptionOfTask(discriptionOfTask);
		 task.setProject(projectService.getProjectById(projectId));
		 task.setTag(tagService.getTagById(tagId));
		 modelmap.addAttribute("task", task);   
		 taskService.updateTask(task);  
	}*/
	@RequestMapping(value="/deleteTaskById")
    public void deleteTaskById(Integer id){ 
	     taskService.deleteTaskById(id);
    }
	@RequestMapping(value="/getTaskById")
	@ResponseBody
    public Task getTaskById(Integer id){
    	return taskService.getTaskById(id);
    }

}
