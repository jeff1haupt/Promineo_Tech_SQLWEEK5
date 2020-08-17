package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import runTracking.Runs;

public class RunDao {
	
	private Connection connection;
	private final String GET_RUNS_QUERY = "SELECT * FROM runs_completed";
	private final String GET_RUN_QUERY = "SELECT * FROM runs_completed WHERE id=?";
	private final String ADD_RUN_QUERY = "INSERT INTO runs_completed (run_date, run_distance, time_total_minutes) VALUES(?,?,?)";
	private final String DELETE_RUN_QUERY = "DELETE FROM runs_completed WHERE id=?";
	
	public RunDao() {
		connection = DbConnection.getConnection();
	}
	
	public List<Runs> getRuns() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_RUNS_QUERY).executeQuery();
		List<Runs> runs = new ArrayList<Runs>();
		while(rs.next()) {
			runs.add( populateRuns( rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getFloat(4) ) );
		}
		return runs;
	}

	private Runs populateRuns(int int1, String string, double double1, float float1) {
		// TODO Auto-generated method stub
		return new Runs(int1, string, double1, float1);
	}

	public String getRun(String runId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement(GET_RUN_QUERY);
		ps.setString(1, runId);
		ResultSet rs = ps.executeQuery();
		String run = "";
		while(rs.next()) {
			run = "Run number: " + rs.getInt(1) + " | Date of run: "
					+ rs.getDate(2) + " | Distance of run (miles): " + rs.getDouble(3)
					+ " | Completed in " + rs.getFloat(4) + " minutes.\n";
		}

		return run;
	}

	public void addRun(String newDate, double newMiles, float newTime) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement(ADD_RUN_QUERY);
		ps.setString(1, newDate);
		ps.setDouble(2, newMiles);
		ps.setFloat(3, newTime);
		int rowsAdded = ps.executeUpdate();
		System.out.println("You have added " + rowsAdded + " row successfully.\n");
	}

	public void deleteRun(String runIdDelete) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement(DELETE_RUN_QUERY);
		ps.setString(1, runIdDelete);
		int rowDeleted = ps.executeUpdate();
		System.out.println("You have successfully deleted " + rowDeleted + " row.");
	}
	
}
	
	

	


