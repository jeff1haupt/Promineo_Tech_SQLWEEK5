package sql_week_5;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.RunDao;
import runTracking.Runs;

public class Menu {
	
	private RunDao runDao = new RunDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display all runs", 
			"Display a run", 
			"Create a run",
			"Delete a run");
	
	public void start() {
		String selection = "";
		
		do {
			
			printMenu();
			selection = scanner.nextLine();
			try {
				if ( selection.equals("1")) {
	
					displayWorkouts();
	
				} else if (selection.contentEquals("2")) {
					
					displayWorkout();
					
				} else if (selection.contentEquals("3")) {
					
					createRun();
					
				} else if (selection.contentEquals("4")) {
					deleteRun();
				} 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			System.out.println("Press enter to continue....\n or enter '-1' to exit");
			scanner.nextLine();
			
		} while (!selection.contentEquals("-1"));
	}




	private void printMenu() {
		System.out.println("Select an option: \n------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println((i+1) + ") " + options.get(i));
		}
	}
	
	private void displayWorkouts() throws SQLException {
		List<Runs> runs = runDao.getRuns();
		System.out.println( "Run number:     " + 
				"Date of run:     " + 
				"Distance (miles):     " + 
				"Time (minutes): ");
		for ( int i = 0; i < runs.size(); i++ ) {
			System.out.printf("%5d %20s %15.2f %19.2f \n",runs.get(i).getRunId(), runs.get(i).getRunDate(), runs.get(i).getRunDistance(), runs.get(i).getRunTime());
		}
	}
	
	private void displayWorkout() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("What run record are you looking for?\n");
		String runId = scanner.nextLine();
		String run = runDao.getRun(runId);
		
		System.out.println(run);
		
	}
	

	private void createRun() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Please enter the date of your run (yyyy-mm-dd): \n");
		String newDate = scanner.next();
		System.out.println("Please enter the distance of your run in miles (xx.xx): \n");
		double newMiles = scanner.nextDouble();
		System.out.println("Please enter the time of your run in minues (xxx.xx): \n");
		float newTime = scanner.nextFloat();
		runDao.addRun(newDate, newMiles, newTime);
		
	}


	private void deleteRun() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("What run record do you want to delete?\n");
		String runIdDelete = scanner.nextLine();
		runDao.deleteRun(runIdDelete);
	}


	
}
