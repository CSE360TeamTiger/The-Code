import java.util.LinkedList;

public class Patient extends User {
	private int PatientiD;
	private int age;
	private String birthDate;
	private double weight;
	private double height;
	private int bmi;
	private String type;
	private LinkedList<String> doctorSugestions;
	public Address pAddress;

	public Patient(int i, String email, String fName, String lName, String password, String hint,
			Address p) {
		super(i, email, fName, lName, password, hint, "Patient");
		this.age = 0;
		this.birthDate = "";
		this.weight = 0;
		this.height = 0;
		this.bmi = 0;
		this.type = "Patient";
		this.pAddress = p;
		this.doctorSugestions = new LinkedList<String>();
	}
	
	Patient( Patient p){
		
		this.setID(p.getID());
		this.setEmail(p.getEmail());
		this.setFirstName(p.getFirstName());
		this.setLastName(p.getLastName());
		this.setPassword(p.getPassword());
		this.setHint(p.getHint());
		this.setType(p.getType());
		this.PatientiD = p.PatientiD;
		this.age = p.age;
		this.birthDate = p.birthDate;
		this.weight = p.weight;
		this.height = p.height;
		this.bmi = p.bmi;
		this.type = "Patient";
		this.pAddress = p.pAddress;
		this.doctorSugestions = p.doctorSugestions;
	}
	public Patient(int a, String bD, double w, double h, int bmi){
		this.age = a;
		this.birthDate = bD;
		this.weight = w;
		this.height = h;
		this.bmi = bmi;
		this.type = "Patient";
	}

	public Patient() {
		this.PatientiD = 0;
		this.age = 0;
		this.birthDate = "";
		this.weight = 0;
		this.height = 0;
		this.bmi = 0;
		this.type = "Patient";
		this.pAddress = null;
		this.doctorSugestions = new LinkedList<String>();
	}
	
	public String toString(){return (super.toString() + " " + age + " "+  birthDate + " "+  weight + " "+  height + " "+ bmi + " "+ pAddress.toString());	}
	
	public void addSuggestion(String d){this.doctorSugestions.add(d);}
	
	public int getAge() {	return age;	}
	public String getBirthday() {	return birthDate;	}
	public double getWeight() {	return weight;	}
	public double getHeight() {	return height;	}
	public int getBMI() {return bmi;}
	public int getPatientID(){return PatientiD;}
	public Address getAddress(){return this.pAddress;}
	public String getType(){ return type;}
	
	public void setAge(int a) {	this.age = a;	}
	public void setBirthDate(String bD) {	this.birthDate = bD;}
	public void setWeight(double w) {	this.weight = w;	}
	public void setHeight(double h) {this.height = h;}
	public void setBMI(int bmi) { this.bmi = bmi;	}//needs an algorithm	
	public void setPatientID(int i){this.PatientiD = i;}

}
