package entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TASK")
public class Task  {
	@Id
	@GeneratedValue
	private String id;
	private String discriptionOfTask;//���ڸ����������������Ϊ��������ʲô�ȵȡ�
	private Date StartTime;//������Ŀ�ʼʱ�䡣
	private Date EndTime;//������Ľ���ʱ�䡣
    @ManyToOne
    private Project project;
    @ManyToOne
    private Tag tag;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDiscriptionOfTask() {
		return discriptionOfTask;
	}
	public void setDiscriptionOfTask(String discriptionOfTask) {
		this.discriptionOfTask = discriptionOfTask;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
}
