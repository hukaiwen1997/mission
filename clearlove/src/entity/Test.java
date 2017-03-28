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
	@RequestMapping(value = "/register")//������/user/register����ʱ��ִ�и÷���
	public String register(
			@RequestParam("discriptionOfTask") String discriptionOfTask,//��Ӧindex.jsp�е�userName����ֵ
			ModelMap modelmap//���ݶ���jsp���棬modelmap����Map�����Բο�register.jsp�鿴���ʹ��
			){
		Task task = new Task();
		task.setDiscriptionOfTask(discriptionOfTask);
		
		modelmap.addAttribute("task", task);//����Map���÷�
		TaskService taskService = new TaskService();
		taskService.addTask(task);
		return "register";//��ת��/WEB-INF/pages/register.jsp
	}
}
