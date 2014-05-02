import java.util.LinkedList;


public class Doctor extends User {
	private String suggestions;

	private LinkedList<Patient> patientList;
	
	public Doctor() {
		this.suggestions = "";
		this.patientList = new LinkedList<Patient>();
	}
	public Doctor(int i, String email, String fName, String lName, String password, String hint
			) {
		super(i, email, fName, lName, password, hint, "Doctor");
		this.suggestions = "";
		this.patientList = new LinkedList<Patient>();
	}
	public String toString(){
		return patientList.toString();
	}
	
	public String getSugesstion(){return suggestions;}
	public void addSugesstion(String s){this.suggestions = this.suggestions + "\n\n" + s ;}
	public void setPatient( Patient p){ this.patientList.add(p);}

}
