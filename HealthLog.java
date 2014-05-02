public class HealthLog {
	private int iD;
	private String date;
	private double sleep;
	private int caloriesBrunt;
	private int caloriesIntake;
	private double sysBloodPressure;
	private double diaBloodPressure;
	private String type;

	// construtor
	public HealthLog(int i, String date, double s, int cals, int incals, double sbp,
			double dbp) {
		this.iD = i;
		this.date = date;
		this.sleep = s;
		this.caloriesBrunt = cals;
		this.caloriesIntake = incals;
		this.diaBloodPressure = dbp;
		this.sysBloodPressure = sbp;
		this.type = "HealthLog";
	}
	
	public HealthLog(){
		this.date = "";
		this.sleep = 0;
		this.caloriesBrunt = 0;
		this.caloriesIntake = 0;
		this.diaBloodPressure = 0;
		this.sysBloodPressure = 0;
		this.type = "HealthLog";
	}
	
	public String toString(){
		return (type +" "+ iD +" "+ date + " "  + sleep + " " + caloriesBrunt + " " + diaBloodPressure +" "+ sysBloodPressure +" \n");
	}
	
	public String getDate(){return date;}
	public double getSleep(){return sleep;}
	public int getCalsBurned() {return caloriesBrunt;}
	public int getCalsIntake() {return caloriesIntake;}
	public double getSBP() {return sysBloodPressure;}
	public double getDBP() {return diaBloodPressure;}
	public int getID(){return iD;}
	public String getType(){ return type;}
	
	public void setDate(String d){this.date = d;}
	public void setSleep(double s){this.sleep = s;}
	public void setCalsBurned(int c) {this.caloriesBrunt = c;}
	public void setCalsIntake(int c) {this.caloriesIntake = c;}
	public void setSBP(double s) {this.sysBloodPressure = s;}
	public void setDBP(double d) { this.diaBloodPressure = d;}
	public void setID(int i){this.iD = i;}

}
