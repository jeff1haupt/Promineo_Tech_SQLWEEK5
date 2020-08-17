# Promineo Tech - Back-end Program - mySQL Week 5

## Table of Contents
* [General info](#general-info)
* [Technologies](#technologies)

## General Info
The purpose of this homework assignment is to create a menu driven application that utilizes JDBC and utilizes Java to execute CRUD commands on a database.  To start the project I created a database with one table, run_training.  Run_training has four columns, an id, run_date, run_distance, and total_time_minutes. 

The Java program has five classes: Application, Menu, RunDao, DBConnection, and Runs.

* Applications is the class containing the "main" method and is rather simple as it creates a new instance of the Menu class and then runs the .start() method on the Menu class. 
* Menu creates the menu using the printMenu() method. Depending on the users selection a variety of methods can be run at this point. The first is the displayRuns() method.  The displayRuns() method connects to the RunDao to display the entire table in run_training. The displayRun() method requires the user to enter which record they would like to see and then only one record is returned. The addRun() method allows the user to enter the date of their run, the distance of the run, and the time of the run.  This data is then inserted into the database.  Finally, the deleteRun() method deletes a user-specified row in the table.  
* RunDao handles the Queries that come through the Menu methods and returns or prints the results depending on the method selected
* DBConnection handles all the initial connection between JDBC and the database. 
* Runs class is used to create instances of a record in the database


## Technologies
* mySQL 8
* Java 12
* Eclipse IDE
* dBeaver 7
