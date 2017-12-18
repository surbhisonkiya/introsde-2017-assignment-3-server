package introsde.soap.eactivity.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="activity_type")
public enum ActivityType implements Serializable{
	SPORT("Sport"),
	SOCIAL("Social"),
	WORK("Work"),
	TRAVEL("Travel"),
	CULTURE("Culture");
	
	private String activityType;
	
	ActivityType(String activityType){
		this.activityType = activityType;
	}
	

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	
	 @Override
	 public String toString() {
	    return activityType;
	 }
}
