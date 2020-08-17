package runTracking;

public class Runs {
	
	private int runId; 
	private String runDate; 
	private double runDistance; 
	private double runTime; 
	
	public Runs(int runId, String runDate, double runDistance, double runTime) {
		this.setRunId(runId); 
		this.setRunDate(runDate);  
		this.setRunDistance(runDistance); 
		this.setRunTime(runTime); 
	}

	public int getRunId() {
		return runId;
	}

	public void setRunId(int runId) {
		this.runId = runId;
	}

	public String getRunDate() {
		return runDate;
	}

	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}

	public double getRunDistance() {
		return runDistance;
	}

	public void setRunDistance(double runDistance) {
		this.runDistance = runDistance;
	}

	public double getRunTime() {
		return runTime;
	}

	public void setRunTime(double runTime) {
		this.runTime = runTime;
	}

}
