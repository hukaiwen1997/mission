package entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="PROJECT")
public class Project {
	  @Id
	  @GeneratedValue
	  private int id;
      private String project;
    
     
  	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
      
}
