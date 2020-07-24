# Andrea_final_project
Java Bootcamp final project

* [Goal](#goal)

* [Methodology](#methodology)

* [Tools](#tools)

* [How it works](#how-it-works)

## <a name="goal"></a>Goal
The idea of this project was to create an application that would allow to easily organise a Rugby Tournament. The idea was to have two types of user the organisers and the team captains.
Team captains can enroll their teams into the tournament, watch all the teams participating, the results, the classifactions, the next matches they will have to play and where will they be.
The organisers (admin) will be able to do anythong a captain member (user) can do and they are the only ones that add the results of the matches once they have finished.

![Functional Diagram](/img/Rugby_Functional_Diagram.png)

## <a name="methodology"></a>Methodology
To apply the microservices architecture this project is divided into 6 services:
      
- Eureka server
- User service
- Edge Service
- Match Service
- Team Service
- Field Service

![Services Diagram](/img/Rugby_Services_Diagram.png.png)


## <a name="tools"></a>Tools used
- IntelliJ
- Spring
- MySQL
- MongoDB
- Postman
- Drawio
- Angular
- Bootstrap


## <a name="how-it-works"></a>How it works


1. Download the repository on your local computer.

2. Go into your MySQL Workbench and type the following commands ```CREATE SCHEMA final_project```, ```CREATE SCHEMA final_project```, and run the SQL file to insert all values needed in terms of app security. Remember to insert your password into the application.properties

3. To get the application working you need to run the projects in the following order:

  3.1 First run the eureka-server project.
  
  3.2 Then run the user-service project.
  
  3.3 Then run the edge-service project.
  
  3.3 Then run the match-service project.
  
  3.3 Then run the team-service project.
  
  3.3 Then run the field-service project.

4. You can now execute the Front project and explore the page.

5. You will be requested to login:

* There are two users that can be used:

````
user: admin
password: admin

user: TeamUser
password: admin

````
