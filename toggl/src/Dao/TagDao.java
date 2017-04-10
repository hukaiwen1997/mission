package Dao;

import java.util.List;






import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;



import entity.Tag;

@SuppressWarnings("deprecation")
@Repository
public class TagDao {
	/*初始化Hibernate，创建SessionFactory实例*/
	public static SessionFactory sessionFactory;
	  static{
		  try{
			  sessionFactory = new Configuration().configure().buildSessionFactory();	  
		  }catch(RuntimeException e){e.printStackTrace();throw e;}
	  }
	  /*查询所有的Project对象，然后调用printProject（）方法打印project对象信息*/
	  @SuppressWarnings("unchecked")
	public List<Tag> findAllTags(){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  tx=session.beginTransaction();
		  Query query;	
		  List<Tag> tags;	
		  try{
			  
			  query =  session.createQuery("from Tag");
			  tags = query.list();			  			  
			  tx.commit();
		  }catch(RuntimeException e){
			  if(tx!=null){
				  tx.rollback();
			  }
			  throw e;
		  }finally{
			  session.close();
		  }
		  return tags;
	   }
	 /* 持久化一个project对象*/
	  public void saveTag(Tag tag){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  try{
			  tx=session.beginTransaction();
			  session.save(tag);
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
	  
	 /* 按照主键值加载一个project对象*/
	  public Tag loadTagById(Integer tag_id){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  Tag C =new Tag();
		  try{
			  tx = session.beginTransaction();
			   C =(Tag)session.get(Tag.class, tag_id);
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
	 /* 删除Tag对象*/
	  public void deleteTagById(Integer tag_id){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  
		  try{
			  tx = session.beginTransaction();
			  session.delete((Tag)session.get(Tag.class, tag_id));
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
	public List<Tag>getTags(){
		return (List<Tag>)this.getSession().createCriteria(Tag.class).list();
	}
	public void addTag(Tag tag){
		this.getSession().save(tag);
	}
	public void deleteTagById(Integer id){
		this.getSession().createQuery("delete Tag where id = ?")
		    .setParameter(0, id).executeUpdate();
	}
	public Tag getTagById(Integer id){
		return(Tag)this.getSession().createQuery("from Tag where id = ?")
		    .setParameter(0, id).uniqueResult();
	}*/
}
