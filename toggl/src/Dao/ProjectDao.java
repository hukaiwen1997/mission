package Dao;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import entity.Project;


@SuppressWarnings("deprecation")
@Repository
public class ProjectDao {
  /* 初始化Hibernate，创建SessionFactory实例*/
	public static SessionFactory sessionFactory;
	  static{
		  try{
			  sessionFactory = new Configuration().configure().buildSessionFactory();	  
		  }catch(RuntimeException e){e.printStackTrace();throw e;}
	  }
	  /*查询所有的Project对象，然后调用printProject（）方法打印project对象信息*/
/*	  @SuppressWarnings("unchecked")
*/	@SuppressWarnings("unchecked")
public List<Project> findAllProjects(){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  tx=session.beginTransaction();
		  Query query;		  
		  List<Project> projects;		  		  
		  try{
			  query =  session.createQuery("from Project");
			  projects = query.list();
			  tx.commit();
		  }catch(RuntimeException e){
			  if(tx!=null){
				  tx.rollback();
			  }
			  throw e;
		  }finally{
			  session.close();
		  }
		  return projects;
	   }
	
	
	/* 持久化一个project对象*/
	  public void saveProject(Project project){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  try{
			  tx=session.beginTransaction();
			  session.save(project);
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
	  
	/*  按照主键值加载一个project对象*/
	  public Project loadProjectById(Integer project_id){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  Project C =new Project();
		  try{
			  tx = session.beginTransaction();
			   C =(Project)session.get(Project.class, project_id);
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
	  /*删除Project对象*/
	  public void deleteProjectById(Integer project_id){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  
		  try{
			  tx = session.beginTransaction();
			  session.delete((Project)session.get(Project.class, project_id));
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
	public List<Project>getProjects(){
		return (List<Project>)this.getSession().createCriteria(Project.class).list();
	}
	public void addProject(Project project){
		this.getSession().save(project);
	}
	public void deleteProjectById(Integer id){
		this.getSession().createQuery("delete Project where id = ?")
		    .setParameter(0, id).executeUpdate();
	}
	public Project getProjectById(Integer id){
		return(Project)this.getSession().createQuery("from Project where id = ?")
			    .setParameter(0, id).uniqueResult();
	}*/
}
