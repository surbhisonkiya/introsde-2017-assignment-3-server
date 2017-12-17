package introsde.soap.eactivity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import introsde.soap.eactivity.dao.PersonDao;


/**
 * The persistent class for the "Person" database table.
 * 
 */
@Entity
@Table(name="\"Person\"")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
@XmlRootElement(name="person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int personId;
	
	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	
	@Column(name="birthdate")
	private String birthDate;
	
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@XmlElementWrapper(name="preferences")
	private List<Activity> activitypreference;
	
	public Person() {
	}
	

	public Person(String firstname, String lastname, String birthdate, List<Activity> activitypreference) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.birthDate = birthdate;
		this.activitypreference = activitypreference;
	}


	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthdate) {
		this.birthDate = birthdate;
	}

	public int getpersonId() {
		return this.personId;
	}

	public void setpersonId(int personId) {
		this.personId = personId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	//@XmlTransient
	public List<Activity> getActivityPreferences() {
	    return activitypreference;
	}
	

	public List<Activity> getActivitiesType(String type) {
	    List<Activity> activities = getActivityPreferences();
	    List<Activity> activitiestype = new ArrayList<>();
	    
	    for (Activity activity : activities) {
	    	if (activity.getType().equals(type)) {
	    		activitiestype.add(activity);
	    	}
	    }
	    return activitiestype;
	}
	
	public void setActivityPreferences(List<Activity> activities) {
	    this.activitypreference = activities;
	}
	
	public static Person getPersonById(int personId) {
		EntityManager em = PersonDao.instance.createEntityManager();
		Person person = em.find(Person.class, personId);
		PersonDao.instance.closeConnections(em);
		return person;
	}
	
	public static List<Person> getAllPerson() {
		EntityManager em = PersonDao.instance.createEntityManager();
	    List<Person> listPerson = em.createNamedQuery("Person.findAll", Person.class).getResultList();
		PersonDao.instance.closeConnections(em);
	    return listPerson;
	}
	
	public static Person savePerson(Person person) {
		EntityManager em = PersonDao.instance.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(person);
		et.commit();
		PersonDao.instance.closeConnections(em);
	    return person;
	}
	
	public static Person updatePerson(Person person) {
		EntityManager em = PersonDao.instance.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		person=em.merge(person);
		et.commit();
		PersonDao.instance.closeConnections(em);
	    return person;
	}
	
	public static void removePerson(Person person) {
		EntityManager em = PersonDao.instance.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		person=em.merge(person);
	    em.remove(person);
	    et.commit();
	    PersonDao.instance.closeConnections(em);
	}


	public List<Activity> getActivitiesType(ActivityType type, int activityId) {
		List<Activity> activities = getActivityPreferences();
	    List<Activity> activitiesType = new ArrayList<>();
	    
	    for (Activity activity : activities) {
	    	if (activity.getType().equals(type)) {
	    		activitiesType.add(activity);
	    	}
	    }
	    return activitiesType;
	}

	
	public Activity addActivityType(ActivityType type, Activity activity) {
		EntityManager em = PersonDao.instance.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Activity> initalActivities = this.getActivityPreferences();
		activity.setType(type);
		initalActivities.add(activity);
		this.setActivityPreferences(initalActivities);
		em.merge(this);
		et.commit();
		PersonDao.instance.closeConnections(em);
		return activity;
		
	}
	
	public static Person getPersonById(long id) {
		EntityManager em = PersonDao.instance.createEntityManager();
		Person p = em.find(Person.class, id);
		PersonDao.instance.closeConnections(em);
		return p;
}

	
	public Activity getActivitiesWithId(int activityId) {
		List<Activity> activities = getActivityPreferences();	    
		/*  for (Activity activity : activities) {
	    	
	    	if (activity.getactivityId()==activityId) {
	    		System.out.println("Person class is here");
	    		return activity;
	    	}
	    }*/
	   return Activity.getActivityById(activityId);
	}


	public Activity addActivity(Activity activity) {
		EntityManager em = PersonDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Activity> originalActivities = this.getActivityPreferences();
		originalActivities.add(activity);
		this.setActivityPreferences(originalActivities);
		Activity.saveActivity(activity);
		em.merge(this);
		tx.commit();
		PersonDao.instance.closeConnections(em);
		return activity;
		
	}


/*	public List<Activity> getBestPreferences() {
		List<Activity> activities = getActivityPreferences();
	    Stack<Activity> stack = new Stack();
	    stack.push(activities.get(0));
	    for (int i =1; i< activities.size();i++) {
	    	if (activities.get(i).getRating() >= stack.peek().getRating()){
	    		stack.pop();
	    		stack.push(activities.get(i));
	    	}
	    }
	   return stack;
	}
*/
}

