messManagementSoftware
======================
Introduction:
Many students from school, college, university and some non-student people stay in a place we call that a Mess and the students and non-students people are called boarders of the Mess. Since boarders come from various places over the country for the purpose of study in case of students or of doing some job in case of non-students, there is a need for managing the Mess of some type. Such as managing the meal they take every day, managing the house rent they pay every month, managing some sort of extra bills e.g. electric bill, water bill, television bill, etc. 
All of the management is done by some rules of the Mess and the rules for all of the Mess’s are almost same with a very little difference among these which can be easily managed. 
Till today, all of this management is held in paper and pen and some time it’s tedious to some people to do that. 
Since a vast amount of people are involved in this processing of Mess management, we are going to develop a software which will be used in the mobile phone as this is available to all the people today. And with this software all the management for the Mess will be very easy, no one have to do calculation in paper and pen to manage. 
Also there will be something very interesting with the software in using it.

Scope:
This will be very easy with the mobile Mess management software to manage the Mess. It will be very easy to find an appropriate Mess seeing their ranking based on various criteria. It will provide everyday market price for the various items such as rice, meat, fish, etc.
Finally the people who are looking for a Mess, a search option based on Mess location, Mess type (Male, female), no. of boarder, seat rent will be provided and which is based on web service using the internet. 
We hope that we will nearly complete our full task within provided time.
Overview of the System:
In this section, we will describe the features and use cases of the system we will develop named “Mess Management Software”.
Users and their roles:
There will be three kinds of user of our software with different responsibilities and restrictions. They are:
 	Anonymous user: People who are looking for a Mess, a search option based on Mess location, Mess type (male, female), no. of boarder, seat rent will be provided and which is based on web service using the internet, these users are known as anonymous user.
 	Mess Manager: Initially manager for a month of the Mess will create an account of Mess using username, Mess name, Building owner name, Location, Contact number and password for the current month, after that he will create account (without user name and password) for the boarders. There will be several pages or forms to manage meals, bazaar schedule, deposit, extra bills and some utility pages which can be accessed only from the manager account and manager can delete, insert, and update the information. Meal rate and other cost of the mess will be updated daily basis. And at the end of the month a summary page will be created to look at a glance overall statistics of the management.
 	Mess Boarder: There are no important roles of a border of a Mess in this software. They can use this as an anonymous user. But if they need any kinds of information about management or any kinds of advice to manager they can request to manager. Manager can take his/her steps respect to their request or advice.

Use cases of the system:
Our MMS is just not a management system; it’s also a utility to the manager as well as to the boarder of the Mess which provides various types of information related to the Mess Management.
 	Account Creation: Initially manager for a month of the Mess will create an account of manager using username, Mess name, Building owner name, Location, Contact number and password.

 	Managing Mess: There will be several pages or forms to manage meals, bazaar schedule, deposit, extra bills and some utility pages which can be accessed only from the manager account and manager can delete, insert, and update the information. Meal rate and other cost of the mess will be updated daily basis. And at the end of the month a summary page will be created to look at a glance overall statistics of the management.

 	Ranking of Mess’s: Some summary information will be used to rank the mess. Manager can look after the current bazaar rate for the various items before creating a bazaar list. Also manager can contribute to the current bazaar rate to rank up him in a contributor list. Ranking of the mess based on some criteria will provide how well a manager has managed the Mess at the current month and top in the rank list. Mess and manager of the month will be evaluated from this list.

Al well as at the end of the month contributor of the month will be evaluated.
Making a prize for the Mess, manager, contributor will be possible.

 	Continuity: Software will retain only database for the current month since after one month manager is changed and management is monthly basis. Also management for different duration with various dates is possible. This software can share some data to the next manager with this software as needed via Internet.
 	Mess Search: For the people, who are looking for a Mess, a search option based on Mess location, Mess type (male, female), no. of boarder, seat rent will be provided and which is based on web service using the internet.
Technology:
Android APIs (for Android OS)
Servlet/JSP (for Website)
Build Tools:
	Gradle
Web Server:
	Apache Tomcat
Database:
	SQLite for Android
	MySQL for Website
