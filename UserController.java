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
	    	fileRead();
	    }catch(FileNotFoundException e){
	    	
	    }	
    }
    
    public void fileRead(){
    	Scanner line = input;
    	String temp = null;
    	while((line != null) && (line.hasNextLine())){
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
    	String tempStr = null;
    	LinkedList<Object> searchList = theData;

    	for(int i = 0 ; i < searchList.size(); i++){
    		listItem = searchList.get(i);
    		if(type.equalsIgnoreCase("user")){
    			tempStr = ((User)listItem).getEmail();
    		}else if (type.equalsIgnoreCase("patient")){
    			tempStr = ((Patient)listItem).getEmail();
    		}else if (type.equalsIgnoreCase("healthLog")){
    			tempStr = Integer.toString(((HealthLog)listItem).getID());
    		}else if (type.equalsIgnoreCase("workout")){
    			tempStr = ((Workout)listItem).getName();
    		}
    		if(searchFor.equalsIgnoreCase(tempStr))
    				return true;
    	}
    	return false;
    }
    
    public static Object search(String type, String searchFor){
    	Object listItem;
    	String tempStr = null;
    	LinkedList<Object> searchList = theData;

    	for(int i = 0 ; i < searchList.size(); i++){
    		listItem = searchList.get(i);
    		if(type.equalsIgnoreCase("user")){
    			tempStr = ((User)listItem).getEmail();
    		}else if (type.equalsIgnoreCase("patient")){
    			tempStr = ((Patient)listItem).getEmail();
    		}else if (type.equalsIgnoreCase("healthLog")){
    			tempStr = Integer.toString(((HealthLog)listItem).getID());
    		}else if (type.equalsIgnoreCase("workout")){
    			tempStr = ((Workout)listItem).getName();
    		}
    		if(searchFor.equalsIgnoreCase(tempStr))
    				return listItem;
    	}
    	return null;
    }
    
    public static double[] graphData(int id, String chartType, String type){
    	LinkedList<Object>  searchList = theData;
    	int i = 0;
    	Object listItem;
    	double[] foundData = null;
    	
    	
    	do{
    		listItem = search(type, Integer.toString(id));
    		if( (((HealthLog)listItem).getID() == id) && (chartType.equalsIgnoreCase("DBP")) ){
    			foundData[i] = ((HealthLog)listItem).getDBP();
    		}else if ( (((HealthLog)listItem).getID() == id) && (chartType.equalsIgnoreCase("SBP")) ){
    			foundData[i] = ((HealthLog)listItem).getSBP();
    		}else if ( (((HealthLog)listItem).getID() == id) && (chartType.equalsIgnoreCase("Caloriesbrunt")) ){
    			foundData[i] = ((HealthLog)listItem).getCalsBurned();
    		}else if ( (((HealthLog)listItem).getID() == id) && (chartType.equalsIgnoreCase("Caloriesintake")) ){
    			foundData[i] = ((HealthLog)listItem).getCalsBurned();
    		}else if ( (((HealthLog)listItem).getID() == id) && (chartType.equalsIgnoreCase("sleep")) ){
    			foundData[i] = ((HealthLog)listItem).getSleep();
    		}else if ( (((HealthLog)listItem).getID() == id) && (chartType.equalsIgnoreCase("exercise")) ){
    			foundData[i] = ((HealthLog)listItem).getSleep();
    		}
    		i++;
    	}while(i < searchList.size());
    	return foundData;
    }
}
