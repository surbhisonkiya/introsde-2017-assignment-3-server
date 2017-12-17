package introsde.soap.eactivity.ws;

import introsde.soap.eactivity.model.*;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface People {

	//Database Init
	@WebMethod(operationName="databaseInit")
	public void databaseInit();
	
	// Method #1
	@WebMethod(operationName="readPersonList")
	@WebResult(name="people") 
	public List<Person> readPersonList();

	// Method #2
	@WebMethod(operationName="readPerson")
	@WebResult(name="person") 
	public Person readPerson(@WebParam(name="id") int personid);

	// Method #3
	@WebMethod(operationName="updatePerson")
	@WebResult(name="id") 
	public int updatePerson(@WebParam(name="person") Person person);

	// Method #4
	@WebMethod(operationName="createPerson")
	@WebResult(name="id") 
	public Person createPerson(@WebParam(name="person") Person person);

	// Method #5
	@WebMethod(operationName="deletePerson")
	@WebResult(name="id") 
	public boolean deletePerson(@WebParam(name="id") int personid);
	
	// Method #6
	@WebMethod(operationName="readPersonPreferences")
	@WebResult(name="personPreferences") 
	public List<Activity> readPersonPreferences(int personid, String activityType);
	
	// Method #7
	@WebMethod(operationName="readPreferences")
	@WebResult(name="preferences") 
	public List<Activity> readPreferences();

	// Method #8
	@WebMethod(operationName="readPersonPreferencesWithId")
	@WebResult(name="personPreferencesWithId") 
	public Activity readPersonPreferencesWithId(int personid, int activityid);

	// Method #9
	@WebMethod(operationName="savePersonPreferences")
	@WebResult(name="savedActivity") 
	public Activity savePersonPreferences(int personid, Activity activity);

	// Method #10
	@WebMethod(operationName="updatePersonPreferences")
	@WebResult(name="updatedActivity") 
	public Activity updatePersonPreferences(int personid, Activity activity);

	// Method #11
	@WebMethod(operationName="evaluatePersonPreferences")
	@WebResult(name="evaluatedActivity") 
	public Activity evaluatePersonPreferences(int personid, Activity activity, int value);
	/*
	// Method #12
	@WebMethod(operationName="getBestPersonPreference")
	@WebResult(name="bestPreference") 
	public List<Activity> getBestPersonPreference(int personid);
*/

}