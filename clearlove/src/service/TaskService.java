package service;

import java.util.List;
import org.springframework.stereotype.Service;
import Dao.TaskDao;
import entity.Task;
@Service
public class TaskService {
	TaskDao taskDao = new TaskDao();
	@SuppressWarnings("unchecked")
	public List<Task>getAllTasks() {
		@SuppressWarnings("rawtypes")
		List tasks = null;
		try {
			tasks= taskDao.findAllTasks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}
	public void addTask(Task task){ 
		taskDao.saveTask(task);
	}
   
    public void deleteTaskById(Integer id){ 
    	taskDao.deleteTaskById(id);
    }
    public Task getTaskById(Integer id){
    	return taskDao.loadTaskById(id);
    }
    

}
