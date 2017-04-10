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
		return taskService.getAllTasks();
	}
	@RequestMapping(value="/addTask")
	@ResponseBody
	public Integer addTask(
			@RequestParam("discriptionOfTask") String discriptionOfTask,
			@RequestParam("projectName") String projectName,
			@RequestParam("tagName") String tagName,
			@RequestParam("startTime") String startTime,
			@RequestParam("endTime") String endTime,
			@RequestParam("lastTime") Integer lastTime,
			ModelMap modelmap
			){ 
		 Task task = new Task();
		 task.setDiscriptionOfTask(discriptionOfTask);
		 task.setProjectName(projectName);
		 task.setTagName(tagName);
		 task.setEndTime(endTime);
		 task.setStartTime(startTime);
		 task.setLastTime(lastTime);
		 modelmap.addAttribute("task", task);   
		 return taskService.addTask(task);
	}
	@RequestMapping(value="/updateTask")
	public void updateTask(
			@RequestParam("discriptionOfTask") String discriptionOfTask,
			@RequestParam("projectName") String projectName,
			@RequestParam("tagName") String tagName,
			@RequestParam("startTime") String startTime,
			@RequestParam("endTime") String endTime,
			@RequestParam("lastTime") Integer lastTime,
			@RequestParam("id") Integer id,
			ModelMap modelmap			
			){ 
		  
		 Task task = new Task();
		 task.setDiscriptionOfTask(discriptionOfTask);
		 task.setProjectName(projectName);
		 task.setTagName(tagName);
		 task.setEndTime(endTime);
		 task.setStartTime(startTime);
		 task.setLastTime(lastTime);
		 task.setId(id);
		 modelmap.addAttribute("task", task); 
		 taskService.updateTask(task);
	}
	@RequestMapping(value="/deleteTaskById")
    public void deleteTaskById(@RequestParam("id") Integer id){ 
	     taskService.deleteTaskById(id);
    }
	@RequestMapping(value="/getTaskById")
	@ResponseBody
    public Task getTaskById(@RequestParam("id") Integer id){
    	return taskService.getTaskById(id);
    }

}
