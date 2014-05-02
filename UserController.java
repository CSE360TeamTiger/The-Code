//Used for file i/o
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class UserController {
	
	User inputUser;
	Patient inputPatient;
	HealthLog inputHlog;
	Workout inputWorkout;
	Doctor inputDoctor;
	static LinkedList<Object> theData;
	
	Scanner input = null;
    PrintWriter output = null;
    
    public UserController(){
    	inputUser = new User();
    	inputPatient = new Patient();
    	inputHlog = new HealthLog();
    	inputWorkout = new Workout();
    	inputDoctor = new Doctor();
    	theData = new LinkedList<Object>();
	    try{
	    	input = new Scanner(new BufferedReader(new FileReader("\\src\\FT360_Data.txt")));
	    	fileRead(input);
	    }catch(FileNotFoundException e){
	    	
	    }	
    }
    
    public void fileRead(Scanner line){
    	String temp = null;
    	while(line.hasNextLine()){
    		if(line.hasNext("User")){
				inputUser.setType(line.next());
				inputUser.setID(line.nextInt());
				inputUser.setEmail(line.next());
				inputUser.setPassword(line.next());
				inputUser.setFirstName(line.next());
				inputUser.setLastName(line.next());
				theData.add(inputUser);	
    		}else if(line.hasNext("Patient")){
    			temp = line.next();
    			inputPatient.setID(line.nextInt());	
    			inputPatient.setAge(line.nextInt());
    			inputPatient.setBirthDate(line.next());
    			inputPatient.setWeight(line.nextDouble());
    			inputPatient.setHeight(line.nextDouble());
    			inputPatient.setBMI(line.nextInt());
    			inputPatient.pAddress.street = line.next();
    			inputPatient.pAddress.city = line.next();
    			inputPatient.pAddress.state = line.next();
    			inputPatient.pAddress.zipCode = line.next();
    			inputPatient.pAddress.phone = line.next();
    			theData.add(inputPatient);
    		}else if(line.hasNext("HealthLog")){
    			temp = line.next();
    			inputHlog.setID(line.nextInt());
    			inputHlog.setDate(line.next());
    			inputHlog.setSleep(line.nextDouble());
    			inputHlog.setCalsBurned(line.nextInt());
    			inputHlog.setCalsIntake(line.nextInt());
    			inputHlog.setDBP(line.nextDouble());
    			inputHlog.setSBP(line.nextDouble());
    			theData.add(inputHlog);
    		}else if(line.hasNext("Workout")){
    			temp = line.next();
    			inputWorkout.setID(line.nextInt());
    			inputWorkout.setName(line.next());
    			inputWorkout.setDuration(line.nextDouble());
    			theData.add(inputWorkout);
    		}else if(line.hasNext("Doctor")){
    			temp = line.next();
    			inputDoctor.addSugesstion(line.next());
    			
    		}
    	}
    	temp = null;
    }
    
    public void fileWrite(){
    	Object tempOut;
	    try{
	    	output = new PrintWriter ("/src/FT360_Data.txt");
	    }catch(FileNotFoundException e){
	    	
	    }
    	do{
    		tempOut = theData.remove();
			output.write( tempOut.toString());
    	}while( !theData.isEmpty());

    }
    
    public static boolean listSearch(String type, String searchFor){
    	Object listItem;
    	LinkedList<Object> searchList = theData;

    	for(int i = 0 ; i < searchList.size(); i++){
    		listItem = searchList.peek();
    		if(type.equalsIgnoreCase("user")){
    			type = ((User)listItem).getEmail();
    		}else if (type.equalsIgnoreCase("patient")){
    			type = ((Patient)listItem).getEmail();
    		}else if (type.equalsIgnoreCase("healthLog")){
    			type = ((HealthLog)listItem).getDate();
    		}else if (type.equalsIgnoreCase("workout")){
    			type = ((Workout)listItem).getName();
    		}
    		if(searchFor.equalsIgnoreCase(type))
    				return true;
    	}
    	return false;
    }
    
    public static Object search(String type, String searchFor){
    	Object listItem;
    	LinkedList<Object> searchList = theData;

    	for(int i = 0 ; i < searchList.size(); i++){
    		listItem = searchList.peek();
    		if(type.equalsIgnoreCase("user")){
    			type = ((User)listItem).getEmail();
    		}else if (type.equalsIgnoreCase("patient")){
    			type = ((Patient)listItem).getEmail();
    		}else if (type.equalsIgnoreCase("healthLog")){
    			type = ((HealthLog)listItem).getDate();
    		}else if (type.equalsIgnoreCase("workout")){
    			type = ((Workout)listItem).getName();
    		}
    		if(searchFor.equalsIgnoreCase(type))
    				return listItem;
    	}
    	return null;
    }
    
}
