package introsde.soap.eactivity.ws;

import introsde.soap.eactivity.DatabaseInit;
import introsde.soap.eactivity.model.*;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "introsde.soap.eactivity.ws.People")
public class PeopleImpl implements People {

	@Override
	public void databaseInit() {
		DatabaseInit dbInit = new DatabaseInit();
		dbInit.init();
		return;

	}
	
	@Override
	public List<Person> readPersonList() {
		List<Person> pList = Person.getAllPerson();
		return pList;
	}

	@Override
	public Person readPerson(int personid) {
		Person person = Person.getPersonById(personid);
		return person;
	}

	@Override
	public int updatePerson(Person person) {
		// Update only person info
		person.setActivityPreferences(null);
		person.updatePerson(person);
		return person.getpersonId();
	}   

	@Override
	public Person createPerson(Person person) {
		return Person.savePerson(person);
	}

	@Override
	public boolean deletePerson(int personid) {
	Person p = Person.getPersonById(personid);

		if (p != null) {
			Person.removePerson(p);
			return true;
		} else {
			return false;
		}
	}


	@Override
	public List<Activity> readPersonPreferences(int personid, String activityType){
		Person person = Person.getPersonById(personid);
		return person.getActivitiesType(activityType);
	}

	@Override
	public List<Activity> readPreferences(){
		return Activity.getAll();
	}

	@Override
	public Activity readPersonPreferencesWithId(int personid, int activityId) {
		Person person = Person.getPersonById(personid);
		return person.getActivitiesWithId(activityId);
	}

	@Override
	public Activity savePersonPreferences(int personid, Activity activity) {
		Person person = Person.getPersonById(personid);
		return person.addActivity(activity);
	}

	@Override
	public Activity updatePersonPreferences(int personid, Activity activity) {
		Person person = Person.getPersonById(personid);
		Activity initial = person.getActivitiesWithId(activity.getactivityId());
		Activity newA= initial.updateActivity(activity);
		return newA;
	}


	@Override
	public Activity evaluatePersonPreferences(int personid, Activity activity, int value) {
		Person person = Person.getPersonById(personid);
		Activity activity1 = person.getActivitiesWithId(activity.getactivityId());
		activity1.setRating(value);
		Activity updatedA = activity.updateActivity(activity1);
		return updatedA;
	}
	/*
	@Override
	public List<Activity> getBestPersonPreference(int personid){
		Person person = Person.getPersonById(personid);
		return person.getBestPreferences();
	}
*/
}