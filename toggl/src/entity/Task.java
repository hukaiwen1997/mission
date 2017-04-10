package entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TASK3")
public class Task  {
	@Id
	@GeneratedValue
	private int id;
	private Integer lastTime;
	public Integer getLastTime() {
		return lastTime;
	}

	public void setLastTime(Integer lastTime) {
		this.lastTime = lastTime;
	}

	private String discriptionOfTask;//���ڸ����������������Ϊ��������ʲô�ȵȡ�
	private String startTime;//������Ŀ�ʼʱ�䡣
	private String endTime;//������Ľ���ʱ�䡣
    
    private String projectName;
   
    private String tagName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiscriptionOfTask() {
		return discriptionOfTask;
	}

	public void setDiscriptionOfTask(String discriptionOfTask) {
		this.discriptionOfTask = discriptionOfTask;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	
	
	
}
