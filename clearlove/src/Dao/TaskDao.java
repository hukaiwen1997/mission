package Dao;

import java.util.List;
import javax.management.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import entity.Task;
@Repository
public class TaskDao {
	
	/*初始化Hibernate，创建SessionFactory实例*/
	public static SessionFactory sessionFactory;
	  static{
		  try{
			  sessionFactory = new Configuration().configure().buildSessionFactory();	  
		  }catch(RuntimeException e){e.printStackTrace();throw e;}
	  }
	  /*查询所有的Task对象*/
	  @SuppressWarnings("unchecked")
	public List<Task> findAllTasks(){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  tx=session.beginTransaction();
		  Query query;		  		  
		  try{
			  tx=session.beginTransaction();
			  query=(Query) session.createQuery("from Task as c order by c.name asc");			  			  
			  tx.commit();
		  }catch(RuntimeException e){
			  if(tx!=null){
				  tx.rollback();
			  }
			  throw e;
		  }finally{
			  session.close();
		  }
		  return ((org.hibernate.Query) query).list();
	   }
	  /*持久化一个Task对象*/
	  public void saveTask(Task task){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  try{
			  tx=session.beginTransaction();
			  session.save(task);
			  tx.commit();
		  }catch(RuntimeException e){
			  if(tx!=null){
				  tx.rollback();
			  }
			  throw e;
		  }finally{
			  session.close();
		  }
	  }
	  
	  /*按照主键值加载一个Task对象*/
	  public Task loadTaskById(Integer task_id){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  Task C =new Task();
		  try{
			  tx = session.beginTransaction();
			  C =(Task)session.get(Task.class, task_id);
			  tx.commit();
		  }catch (RuntimeException e){
			  if(tx!=null){
				  tx.rollback();
			  }
			  throw e;
		  }finally{
			  session.close();
		  }
		  return C;
	  }
	  /*删除Task对象*/
	  public void deleteTaskById(Integer task_id){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  
		  try{
			  tx = session.beginTransaction();
			  session.delete((Task)session.get(Task.class, task_id));
			  tx.commit();
		  }catch (RuntimeException e){
			  if(tx!=null){
				  tx.rollback();
			  }
			  throw e;
		  }finally{
			  session.close();
		  }
	  }
	/*@Resource private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<Task>getTasks(){
		return (List<Task>)this.getSession().createCriteria(Task.class).list();
	}
	public void addTask(Task task){ 
		this.getSession().save(task);   
	}
   
    public void updateTask(Task task){ 
		this.getSession().update(task);	  
		
    }
	 
    public void deleteTaskById(Integer id){ 
	    this.getSession().createQuery("delete Task where id = ?")
	    .setParameter(0, id).executeUpdate();
    }
    public Task getTaskById(Integer id){
    	return(Task)this.getSession().createQuery("from Task where id = ?")
	    .setParameter(0, id).uniqueResult();
    }*/
}
