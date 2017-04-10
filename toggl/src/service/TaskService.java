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
	public Integer addTask(Task task){ 
		Integer ID = 0;
		try {
			ID= taskDao.saveTask(task);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ID;
	}
   
    public void deleteTaskById(Integer id){ 
    	taskDao.deleteTaskById(id);
    }
    public Task getTaskById(Integer id){
    	return taskDao.loadTaskById(id);
    }
    public void updateTask(Task task){
    	taskDao.updateTask(task);
    	
    }
    
/*@Autowired private TaskDao taskDao;
public List<Task>getTasks(){
	return taskDao.getTasks();
}
public void addTask(Task task){ 
	taskDao.addTask(task);   
}
public void deleteTaskById(Integer id){
	taskDao.deleteTaskById(id);
	
	
}
public void updateTask(Task task){ 
	taskDao.updateTask(task);
}
public Task getTaskById(Integer id){
	return taskDao.getTaskById(id);
}*/
}
