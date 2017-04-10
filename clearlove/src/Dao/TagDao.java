package Dao;

import java.util.List;

import javax.annotation.Resource;
import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import entity.Tag;

@Repository
public class TagDao {
	/*��ʼ��Hibernate������SessionFactoryʵ��
	public static SessionFactory sessionFactory;
	  static{
		  try{
			  sessionFactory = new Configuration().configure().buildSessionFactory();	  
		  }catch(RuntimeException e){e.printStackTrace();throw e;}
	  }
	  ��ѯ���е�Project����Ȼ�����printProject����������ӡproject������Ϣ
	  @SuppressWarnings("unchecked")
	public List<Tag> findAllTags(){
		  Session session = sessionFactory.openSession();
		  Transaction tx =null;
		  tx=session.beginTransaction();
		  Query query;		  		  
		  try{
			  tx=session.beginTransaction();
			  query=(Query) session.createQuery("from Tag as c order by c.name asc");			  			  
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
	  �־û�һ��project����
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
	  
	  ��������ֵ����һ��project����
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
	  ɾ��Tag����
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
	
	*/
	
	
	@Resource private SessionFactory sessionFactory;
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
	}
}
