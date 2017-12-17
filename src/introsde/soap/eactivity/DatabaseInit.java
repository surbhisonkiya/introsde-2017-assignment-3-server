package introsde.soap.eactivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import introsde.soap.eactivity.model.Activity;
import introsde.soap.eactivity.model.ActivityType;
import introsde.soap.eactivity.model.Person;



public class DatabaseInit {
	//Request#0
	public static List<Activity> createActivities(){
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity1 = new Activity("Squash", "Squash Court in Sanbapolis", "Trento", ActivityType.SPORT, "2017-12-10");
		activities.add(activity1);
		
		Activity activity2 = new Activity("Jogging", "Jogging on Golden Gate Bridge", "San Francisco", ActivityType.SPORT, "2017-10-04");
		activities.add(activity2);
		
		Activity activity3 = new Activity("Dance", "Salsa dance classes", "Madrid", ActivityType.CULTURE, "2016-11-07");
		activities.add(activity3);
		
		Activity activity4 = new Activity("Workshop", "Design Thinking Workshop", "Jaipur", ActivityType.WORK, "2016-08-14");
		activities.add(activity4);
		
		Activity activity5 = new Activity("Culture class", "Learn italian culture in CLA", "Trento", ActivityType.CULTURE,"2017-06-13");
		activities.add(activity5);
		
		Activity activity6 = new Activity("Yoga", "Yoga Teacher Training Program", "Mysore", ActivityType.SPORT, "2017-09-26");
		activities.add(activity6);
		
		Activity activity7 = new Activity("Trekking", "Mountain trekking and rock climbing", "Shimla", ActivityType.SPORT, "2017-03-19");
		activities.add(activity7);
		
		Activity activity8 = new Activity("Travelling", "Visit historical places in the country", "Italy", ActivityType.TRAVEL, "2016-08-27");
		activities.add(activity8);
		
		Activity activity9 = new Activity("Party", "Friends get-togther", "Sanbapolis", ActivityType.SOCIAL, "2017-05-26");
		activities.add(activity9);
		
		Activity activity10 = new Activity("Team Meeting", "Discuss about the project", "Mysore", ActivityType.WORK, "2016-01-13");
		activities.add(activity10);
		
		return activities;
	}
	
	public static List<Person> createFivePeople(){
		List<Person> peopleList = new ArrayList<>();
		List<Activity> activityList = createActivities();
		Person person1 = new Person("Surbhi", "Sonkiya", "2017-10-10", activityList.subList(0, 2));
		peopleList.add(person1);
		activityList.get(0).setPerson(person1);
		activityList.get(1).setPerson(person1);
		
		Person person2 = new Person("Rohit", "Prakash", "2016-12-1", activityList.subList(2, 4));
		peopleList.add(person2);
		activityList.get(2).setPerson(person2);
		activityList.get(3).setPerson(person2);
		
		Person person3 = new Person("Parul", "Jain", "2017-10-18", activityList.subList(4, 6));
		peopleList.add(person3);
		activityList.get(4).setPerson(person3);
		activityList.get(5).setPerson(person3);

		Person person4 = new Person("Hari", "Jhawar", "2017-07-15", activityList.subList(8, 10));
		peopleList.add(person4);
		activityList.get(8).setPerson(person4);
		activityList.get(9).setPerson(person4);

		Person person5 = new Person("Renu", "Jhalani", "2016-11-05", activityList.subList(6, 8));
		peopleList.add(person5);
		activityList.get(6).setPerson(person5);
		activityList.get(7).setPerson(person5);
		
		return peopleList;
	}
	
	
	
	public static List<Person> init() {
		List<Person> peopleList = new ArrayList<>();
		Person person;
		for (int i=0; i<5; i++) {
			person = Person.savePerson(createFivePeople().get(i));
			peopleList.add(person);
		}
		return peopleList;

		
	}
	
	public static void main(String[] args) {
		init();
	}
	
}
