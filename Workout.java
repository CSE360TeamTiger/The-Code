
public class Workout{
	private int iD;
	private double duration;
	private String name;
	private String type;
	
	public Workout(){
		this.iD = 0;
		this.duration = 0;
		this.name = "";
		this.type = "Workout";
	}
	public Workout(int i,String n, double d){
		this.iD = i;
		this.duration = d;
		this.name = n;
		this.type = "Workout";
	}
	
	public String toString(){
		return (type + " "+ iD + " " + name + " "+ duration +" \n");
	}
	
	public String getName(){return name;}
	public double getDuration(){return duration;}
	public int getID(){return iD;}
	public String getType(){ return type;}
	public void setName(String n){this.name = n;}
	public void setDuration(double d){this.duration = d;}
	public void setID(int i){this.iD = i;}

}
