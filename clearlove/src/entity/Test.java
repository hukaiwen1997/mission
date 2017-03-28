package entity;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.ProjectService;
import service.TaskService;

@Controller
@RequestMapping(value="/clear")
public class Test {
	@RequestMapping(value = "/register")//当访问/user/register链接时，执行该方法
	public String register(
			@RequestParam("discriptionOfTask") String discriptionOfTask,//对应index.jsp中的userName，传值
			ModelMap modelmap//传递对象到jsp界面，modelmap类似Map，可以参考register.jsp查看如何使用
			){
		Task task = new Task();
		task.setDiscriptionOfTask(discriptionOfTask);
		
		modelmap.addAttribute("task", task);//类似Map的用法
		TaskService taskService = new TaskService();
		taskService.addTask(task);
		return "register";//跳转到/WEB-INF/pages/register.jsp
	}
}
