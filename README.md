# introsde-2017-assignment-3-server

Surbhi Sonkiya

Email-id: surbhi.sonkiya@studenti.unitn.it

Worked Alone.

Server URL: https://studentactivity.herokuapp.com/ws/people?wsdl

Server github repository: https://github.com/surbhisonkiya/introsde-2017-assignment-3-server.git

Client github repository: https://github.com/surbhisonkiya/introsde-2017-assignment-3-client.git

Project Description:

This project provides a system to the University to understand the preferences of their students, that can help them register students and their preferred activities. Firstname, lastname, birthdate of the students needs to be defined and stored. About the activities they need to register name, description, type of activity, place, start date/time. The University needs to add, read, modify and delete the information via Web (SOAP Services). Additionally, the results needs to be saved in a database.

About the code:

I have used SQLite database (name of the database "activitystudentDB"). Person and Activity tables are implemented through Java Persistence API. In src folder, Person.java and Activity.java implements these tables respectively. Activity types is implemented in an enum class. Hence, it is not stored as a table in the database. If the code is run locally, using PeopleClient.java class, it implements the server on localhost port:6900.

Below are the list of tasks that are implemented:

    Method#0: databaseInit() => an initialization process at deployment should create 5 new persons to initialise the database and return the newly created persons including at least one activity preference per person.

Using JAX-WS, implement CRUD services for the following model including the following operations:

    Method #1: readPersonList() => List<Person> | should list all the people in the database (all information related to each person) in your database.
    Method #2: readPerson(Long id) => Person | should give all the Personal information of one Person identified by {id}.
    Method #3: updatePerson(Person p) => Person | should update the Personal information of the Person identified by {id} (e.g., only the Person's information)
    Method #4: createPerson(Person p) => Person | should create a new Person and return the newly created Person with its assigned id (if a preference is included, create also those values for the new Person).
    Method #5: deletePerson(Long id) | should delete the Person identified by {id} from the system
    Method #6: readPersonPreferences(Long id, String activity_type) => List<Preference> | should return the list of values of {activity_type} (e.g. sport) for a Person identified by {id}
    Method #7: readPreferences() => List<Preferences> | should return the list of all preferences
    Method #8: readPersonPreferences(Long id, Long activity_id) => Preference | should return the value identified by {activity_id} for a Person identified by {id}
    Method #9: savePersonPreferences(Long id, Activity activity) | should save a new activity object {activity} of a Person identified by {id}
    Method #10: updatePersonPreferences(Long id, Activity activity) => Preference | should update the activity identified with {activity.id}, related to the Person identified by {id}
    Method #11 (Extra): evaluatePersonPreferences(Long id, Activity activity, int value) => Preference | should update the activity identified with {activity.id}, related to the Person identified by {id} with the value that define a specific value of preferences (e.g. 4 out of 5, or 8 out of 10).
    Method #12 (Extra): getBestPersonPreference(Long id) => List<Preference> | should  return the best preference (or preferences if there are more) of the Person identified by {id}  from his/her list of preferences.

Execution:

    1. Create an account on Heroku (URL: https://www.heroku.com/) and create an app in the Heroku (can create after logging into your Heroku account from the browser). I have created an app named "studentactivity".

    2. Clone the server github repository to your local machine -

     Server github repository: https://github.com/surbhisonkiya/introsde-2017-assignment-3-server.git

    3. In the terminal, navigate to the path where you have cloned the repository on your local machine.

    4. Build the war file from build.xml. Execute below command in the terminal. It creates war with name "sde-assignment-03-server.war".

      ant create.war

    5. Login to your heroku account from the terminal.

    6. Deploy the newly created war on heroku. Use below command to do so -

     heroku war:deploy sde-assignment-03-server.war --app studentactivity --includes activitystudentDB.sqlite

    7. In the browser, execute the below mentioned -

      https://studentactivity.herokuapp.com/ws/people?wsdl

    Server is ready. Client operations could be performed to verify the output.

Additional Notes:

Method# 12 has not been implemented.
