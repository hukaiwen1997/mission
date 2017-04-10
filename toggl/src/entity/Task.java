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

	private String discriptionOfTask;//关于该任务的描述，内容为我们在做什么等等。
	private String startTime;//该任务的开始时间。
	private String endTime;//该任务的结束时间。
    
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
