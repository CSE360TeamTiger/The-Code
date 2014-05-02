

import java.awt.Color;
import java.awt.EventQueue;
import java.lang.String;
import java.text.MessageFormat;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;



public class GUI extends JFrame {
	
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	
	public JTabbedPane tabs;
	
	
	//DECLARING FOR FORGOTPASSWORD FRAME
	public JFrame forgotPasswordFrame;
	public JPanel forgotPanel;
	public JTextField usernameTextField;
	public JLabel hintLabel;
	public JLabel showHint;
	public JLabel passwordLabel;
	public JTextField passwordTextField;
	public JButton btnEnter;
	public JButton btnExit_Forgot;
	
	public String username = "jo";
	public String usernameEntered;
	public String password = "no";
	public String passwordEntered;
	public String hint;
	public JButton btnEnterPassword;
	
	//DECLARING FOR LOGIN FRAME
	public JFrame login;
	public JPanel loginPanel;
	public JLabel loginLabel;
	public JTextField txtUserName_login;
	public JPasswordField passwordField_login;
	public JButton btnForgotPassowrd;
	public JButton btnCreateUser;
	public String userChoice;
	public String[] choice = {"Patient","Doctor"};
	public JButton close;
	public JComboBox choiceBox_Login;
	
	//DECLARING FOR ACTIVITIES FRAME
	public JFrame activitiesFrame;
	public JPanel welcomePanel;
	public JLabel welcomeLabel;
	public JButton logoutAccount;
	public JTextArea programSummary;
	
	public JPanel exercisePanel;
	public JTextField newWorkout;
	public String[] userWorkouts;
	public String workout;
	public JComboBox givenWorkout;
	public String[] exercise = {"CARDIO","---------","Running/Treadmil","Bicycle","Eliptical","Jumpe Rope","\n",
			"UPPER BODY","---------","Dumbbell Biceps Curl","Lying Down Tricep Extension",
			"Bosu Kneeling Pushups","Arnold Press","Kettlebell Upright Row","\n",
			"LOWER BODY","---------","Beginner Squat","Calf Raise","Machine Leg Extension",
			"Machine Leg Curl"};
	public JLabel enterExercise_label;
	public JLabel selectExercise_label;
	public String chosenExercise;
	public JLabel or_Label;
	public JLabel duration_label;
	public JTextField txtDuration;
	public String[] userDuration;
	public double workoutDuration;
	public JLabel hours_label;
	public JButton btnAdd;
	public JButton viewExercise;
	
	public JPanel healthPanel;
	public JLabel bloodPressure_label;
	public JTextField txtDiastolic;
	public int userDiastolic;
	public JTextField txtSystolic;
	public int userSystolic;
	public JLabel sleepHours_label;
	public JTextField txtHours;
	public int userSleep;
	public JLabel calories_label;
	public JTextField txtCalorieIntake;
	public int userIntake;
	public JTextField txtCaloriesBurned;
	public int userBurned;
	public JLabel dateOfEntry_label;
	public JComboBox monthBox_health;
	public String userMonth_health;
	public JComboBox dayBox_health;
	public String userDay_health;
	public JComboBox yearBox_health;
	public String userYear_health;
	public JLabel timeOfEntry_label;
	public JTextField txtEntryTime;
	public int userTimeEntry;
	public JComboBox am_pm;
	public String[] time = {"am","pm"};
	public String userAm_Pm;
	public JButton btnSubmit_health;
	public JButton btnHealthLogout;
	
	public JPanel viewPanel;
	public JPanel healthIndicator_Panel;
	public JPanel workoutSummary_Panel;
	public JPanel graphPanel;
	public JTable table;
	public String[] columnNames = {"Health Indicator","Data"};
	public Object[][] data;
	public JComboBox graphChoice;
	public String[] chooseGraph = { "Choose a Graph","Blood Pressure","Calories","Hours Slept","Exercise Summary"};
	public JTable healthTable;
	

	
	public JPanel editPanel;
	public JTextField txtFirstName;
	public String first;
	public JTextField txtLastName;
	public String last;
	public JTextField txtStreetAddress;
	public String address;
	public JTextField txtZipCode;
	public String zipCode;
	public JTextField txtCity;
	public String city;
	public JTextField txtPhoneNumber;
	public String number;
	public JTextField txtHeight;
	public String height;
	public JTextField txtWeight;
	public Double weight;
	public JLabel birthLabel;
	public JComboBox monthBox_birth;
	public String birthMonth;
	public JComboBox dayBox_birth;
	public String birthDay;
	public JComboBox yearBox_birth;
	public String birthYear;
	public String userGender;
	public JTextField txtPassword;
	public JTextField txtVerifyPassword;
	public String verify;
	public JTextField txtPasswordHint;
	public JButton btnSubmit_edit;	
	
	
	public JPanel notesForUserPanel;
	
	
	//DECLARE FOR CREATE USER FRAME
	public JFrame createUser;
	public JPanel createUserPanel;
	public JLabel createUserLabel;
	public JTextField txtUsername;
	public JLabel securityInfo_label;
	public JButton submitCreated;
	public JButton btnExit;
	


	//DECLARING VIEW EXERCISE FRAME
	public JFrame viewExerciseFrame;
	public JPanel viewExercisePanel;
	public JScrollPane scroll_viewExercise;
	public JButton backToExercise;
	
	//DECLARING DOCTOR FRAME
	public JFrame Doctor;
	public JPanel patientInfoPanel;
	public JScrollPane scrollPane;
	public JTextArea patients;
	public JComboBox data_graphBox;
	public JTextArea txtSuggestions;
	public String data_graphChoice;
	public String suggestions;
	public JButton btnSubmit_Doctor;
	public JTextArea noteFromDoctor;
	
	//Delcaring JComboBoxes used in multiple frames
	public JComboBox genderBox;
	public JComboBox stateBox;
	public String chosenState;
	public JComboBox choiceBox;
	
	//declare and initialize array of genders for gender combo box used by edit panel and create user frame
	public String[] gender = {"Female","Male"};
	
	//declare and initialize array of states for state combo box used by edit panel and create user frame
	public String[] state = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado",
			"Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho",
			"Illinoise","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine",
			"Maryland","Massachusetts","Michigan","Minnesota","Mississippi",
			"Missouri","Montana","Nebraska","Nevada","New Hampshire",
			"New Jersey","New Mexico","New York","North Carolina","North Dakota",
			"Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina",
			"South Dakota","Tennessee","Texas","Utah","Vermont","Virginia",
			"Washington","West Virginia","Wisconsin","Wyoming"};
	
	//declare and initialize array of the months for the month combo box used by edit panel, create user frame, track health info panel
	public String[] month = {"January","February","March","April","May","June",
			"July","August","September","October","November","December"};
	
	//declare and initialize array of numbers from 1-31 for the day combo box used by edit panel, create user frame, track health info panel
	public String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
							"16","17","18","19","20","21","22","23","24","25","26","27","28",
							"29","30","31"};
	
	//declare and initialize array of years from 1900-2040 for year combo box used by edit panel, create user frame, track health info panel
	public String[] year = {"1900","1901","1902","1903","1904","1905","1906","1907","1908","1909","1910",
							"1911","1912","1913","1914","1915","1916","1917","1918","1919","1920","1921",
							"1922","1923","1924","1925","1926","1927","1928","1929","1930","1931","1932",
							"1933","1934","1935","1936","1937","1938","1939","1940","1941","1942","1943",
							"1944","1945","1946","1947","1948","1949","1950","1951","1952","1953","1954",
							"1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965",
							"1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976",
							"1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987",
							"1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998",
							"1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
							"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020",
							"2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031",
							"2032","2033","2034","2035","2036","2037","2038","2039","2040"};
	
	UserController controller;
	User guiCurrentUser;
	Doctor guiDoctor;
	Patient guiPatient;
	HealthLog guiHealthLog;
	Workout guiWorkout;
	Address guiAddress;
	boolean contains = false;
	int idCounter = 0;	//counter for ids
	int foundIndex = 0; //int for indexsearch results
	String foundString = null;


	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		controller = new UserController();
		guiCurrentUser = new User();
		guiDoctor = new Doctor();
		guiPatient = new Patient();
		guiHealthLog = new HealthLog();
		guiWorkout = new Workout();
		guiAddress =new Address();
		initialize1();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	@SuppressWarnings("deprecation")
	public void initialize1() throws IOException {
		controller = new UserController();

		//TABS
		tabs = new JTabbedPane();
		
		//Creates LOGIN FRAME and all its contents
		login = new JFrame();
		login.setBounds(100, 100, 615, 383);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);
		
		//creates login panel
		loginPanel = new JPanel();
		loginPanel.setBounds(6, 6, 603, 349);
		login.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		//creates a label for the login frame
		loginLabel = new JLabel("Fitness Tracker 2014");
		loginLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		loginLabel.setBounds(175,6,300,30);
		loginPanel.add(loginLabel);
		
		//creates text field for user input
		txtUserName_login = new JTextField();
		txtUserName_login.setBounds(228, 87, 134, 28);
		txtUserName_login.setText("Username");
		loginPanel.add(txtUserName_login);
		txtUserName_login.setColumns(10);
		
		//creates text field for user input
		passwordField_login = new JPasswordField();
		passwordField_login.setBounds(228, 116, 134, 28);
		passwordField_login.setToolTipText("password");
		loginPanel.add(passwordField_login);
		
		//creates forgot password button
		btnForgotPassowrd = new JButton("Forgot Passowrd?");
		btnForgotPassowrd.setBounds(223, 235, 151, 29);
		btnForgotPassowrd.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		loginPanel.add(btnForgotPassowrd);
		
		//adds action to forgot password button
		btnForgotPassowrd.addActionListener(new ActionListener() {
			//when button is clicked, saves user's input and screen changes to forgot password frame
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//saving user input
				usernameEntered = txtUserName_login.getText();
				passwordEntered = passwordField_login.getText();
				
				//hides menu frame
				login.setVisible(false);
				//shows forgot password frame
				forgotPasswordFrame.setVisible(true);
			
			}
		});
		
		//creates button to create a new user
		btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(238, 276, 117, 29);
		btnCreateUser.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		loginPanel.add(btnCreateUser);
		
		//adds action to create user button
		btnCreateUser.addActionListener(new ActionListener() {
			//when Back button is clicked, it takes the user to create user frame
			public void actionPerformed(ActionEvent arg0) {
			// hides login frame
			login.setVisible(false);
			//shows create user frame
			createUser.setVisible(true);
			}
		});
		
		//combo box to choose if patient or doctor
		choiceBox_Login = new JComboBox(choice);
		choiceBox_Login.setBounds(228, 156, 134, 27);
		loginPanel.add(choiceBox_Login);
		
		//creates login button
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(238, 194, 117, 29);
		btnLogin.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		loginPanel.add(btnLogin);
		
		
		
		//adds action to the Login button
		btnLogin.addActionListener(new ActionListener() {
			//when button is clicked, screen changes to activities frame
			@Override
			public void actionPerformed(ActionEvent arg0) {

				//saving user input
				usernameEntered = txtUserName_login.getText();
				passwordEntered = passwordField_login.getText();
				//saves user selection from combo box
				userChoice = (String)choiceBox_Login.getSelectedItem();
				
				if(userChoice.equalsIgnoreCase("patient"))
					contains = UserController.listSearch("patient", usernameEntered);
				else if(userChoice.equalsIgnoreCase("doctor"))
					contains = UserController.listSearch("doctor", usernameEntered);

				
				//if the inputed username, password match in the database AND 
				//user is a patient
				if((contains) && ( userChoice.equalsIgnoreCase("Patient"))){	
					guiCurrentUser = (User)UserController.search("patient", usernameEntered);
					//hides login frame
					login.setVisible(false);
					//makes activities frame visible
					activitiesFrame.setVisible(true);
					tabs.setSelectedIndex(0);
				}
				else if((contains) && (userChoice.equalsIgnoreCase("Doctor"))){
					guiCurrentUser = (User)UserController.search("Doctor", usernameEntered);
					//hides login frame
					login.setVisible(false);
					//makes doctor frame visible
					Doctor.setVisible(true);
				}
			  	
			  	else if (!contains){
			  		JOptionPane.showMessageDialog(login, "Username or password is invalid","A plain message",
    				JOptionPane.PLAIN_MESSAGE);
			  	}
				
				txtUserName_login.setText(null);
				passwordField_login.setText(null);
			}
		});
		
		close = new JButton("Exit");
		close.setBounds(238, 316, 117, 29);
		loginPanel.add(close);
		
		//adds action to the close button
		close.addActionListener(new ActionListener() {
			//when close button is clicked by user, the application is close
			public void actionPerformed(ActionEvent arg0) {
			
				
				System.exit(0);
				
			}
		});
		
		
//----------------------------------------------------------------------------------------
		
		//Initialize the ACTIVITIES FRAME and all its contents
		activitiesFrame = new JFrame();
		activitiesFrame.setBounds(100, 100, 615, 383);
		activitiesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		activitiesFrame.getContentPane().setLayout(null);
		
		//Creating WELCOME PANEL	
		welcomePanel = new JPanel();
		welcomePanel.setBounds(6, 6, 603, 349);
		activitiesFrame.setContentPane(tabs);
		welcomePanel.setLayout(null);
		tabs.addTab("Welcome", welcomePanel);
		
		//Creates welcome label
		welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		welcomeLabel.setBounds(238, 20, 117, 60);
		welcomePanel.add(welcomeLabel);
		
		//creates summary of program for user
		programSummary = new JTextArea("                The purpose of this software, Fitness Tracker 360, is to collect data on the \n"
										+ "             patients daily health information, for the patient and doctor to review. \n"
										+ "             The patient will be able to create an account that stores and manages the \n"
										+ "             daily data entered. Also, the patient and doctor will be able to view the \n"
										+ "             history of previous days information in order to track progress against set goals.\n" );
		programSummary.setFont(new Font("Lucida GRande", Font.PLAIN, 12));
		programSummary.setBounds(6,99,589,98);
		programSummary.setBackground(UIManager.getColor("Button.background"));
		welcomePanel.add(programSummary);
		
		//creates button for user to logout of account
		logoutAccount = new JButton("Logout");
		logoutAccount.setBounds(238, 250, 117, 29);
		welcomePanel.add(logoutAccount);
		
		//adds action to logout account button
		//adds action to create user button
		logoutAccount.addActionListener(new ActionListener() {
			//when Back button is clicked, it takes the user to create user frame
			public void actionPerformed(ActionEvent arg0) {
			// hides login frame
			activitiesFrame.setVisible(false);
			//shows create user frame
			login.setVisible(true);
			
			}
		});

		
		
		//Creating Track EXERCISE PANEL and all contents
		exercisePanel = new JPanel();
		exercisePanel.setBounds(6, 6, 603, 349);
		activitiesFrame.setContentPane(tabs);
		exercisePanel.setLayout(null);
		tabs.addTab("Track Exercise", exercisePanel);
		
		//creates label to prompt user to enter a new exercise
		enterExercise_label = new JLabel("Enter a New Exercise");
		enterExercise_label.setHorizontalAlignment(SwingConstants.CENTER);
		enterExercise_label.setBounds(81, 65, 157, 16);
		exercisePanel.add(enterExercise_label);
		
		//creates text field for user to input new work outs
		newWorkout = new JTextField();
		newWorkout.setHorizontalAlignment(SwingConstants.CENTER);
		newWorkout.setBounds(95, 93, 134, 28);
		exercisePanel.add(newWorkout);
		newWorkout.setColumns(10);
		
		//creates label that prompts user to select a given workout
		selectExercise_label = new JLabel("Select a Given Exercise");
		selectExercise_label.setHorizontalAlignment(SwingConstants.CENTER);
		selectExercise_label.setBounds(345, 65, 166, 16);
		exercisePanel.add(selectExercise_label);		
		
		//displays given work outs in jcombobox
		givenWorkout = new JComboBox(exercise);
		givenWorkout.setBounds(341, 93, 181, 28);
		exercisePanel.add(givenWorkout);
		
		//creates or label
		or_Label = new JLabel("OR");
		or_Label.setBounds(278, 93, 33, 16);
		exercisePanel.add(or_Label);
		
		//creates duration label
		duration_label = new JLabel("Duration of Exercise");
		duration_label.setBounds(99, 142, 144, 16);
		exercisePanel.add(duration_label);
		
		//creates text field for user to input duration of workout
		txtDuration = new JTextField();
		txtDuration.setHorizontalAlignment(SwingConstants.CENTER);
		txtDuration.setText("00:00");
		txtDuration.setBounds(99, 180, 66, 28);
		exercisePanel.add(txtDuration);
		txtDuration.setColumns(10);
		
		//creates hours label
		hours_label = new JLabel("hours");
		hours_label.setBounds(180, 185, 219, 16);
		exercisePanel.add(hours_label);	
		
		//creates button for user to add an exercise to their log
		btnAdd = new JButton("Add");
		btnAdd.setBounds(100, 225, 117, 29);
		exercisePanel.add(btnAdd);
		
		//adds action to the add button
		btnAdd.addActionListener(new ActionListener() {
			//when Back button is clicked, it saves the exercise and duration user chose/inputed
			@Override
			public void actionPerformed(ActionEvent arg0) {
				workoutDuration = Double.parseDouble(txtDuration.getText());
				//saves work outs to an array of work outs
				if (newWorkout.getText() != null){
					workout = newWorkout.getText();
				}else{
					workout = (String)givenWorkout.getSelectedItem();
				}
				
				guiWorkout = new Workout(guiCurrentUser.getID(),workout,workoutDuration);
				UserController.theData.add(guiWorkout);
			}
		});
		
		//creates a jbutton so user can view how to do the given work outs
		viewExercise = new JButton("View Given Exercises");
		viewExercise.setBounds(345, 225, 170, 29);
		exercisePanel.add(viewExercise);
		
		//VIEW EXERCISES FRAME
		viewExerciseFrame = new JFrame();
		viewExerciseFrame.setBounds(100, 100, 615, 383);
		viewExerciseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewExerciseFrame.getContentPane().setLayout(null);
		
		
		//creates view exercise panel
		viewExercisePanel = new JPanel();
		viewExercisePanel.setBounds(6, 6, 603, 349);
		viewExerciseFrame.getContentPane().add(viewExercisePanel);
		viewExercisePanel.setLayout(null);
		
		//creates button for user to return to main screen
		backToExercise = new JButton("Back");
		backToExercise.setBounds(558, 368, 117, 29);
		viewExercisePanel.add(backToExercise);
				
		//adds action to the logout button
		backToExercise.addActionListener(new ActionListener() {
			//when logout button is clicked, it takes the user back to login page
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				//hide the activities frame
				viewExerciseFrame.setVisible(false);
				//shows the login frame
				exercisePanel.setVisible(true);
			}
		});		
        
		//COMPILES BUT DOES NOT WORK
		// Create an RTF editor window
        RTFEditorKit exerciseDescription = new RTFEditorKit();
        JEditorPane editorPane = new JEditorPane();
        editorPane.setBounds(6, 6, 545, 445);
        editorPane.setEditorKit(exerciseDescription);
        editorPane.setBackground(Color.white);
        
        // This text could be big so add a scroll pane
        JScrollPane scrollPane_Description = new JScrollPane();
        scrollPane_Description.getViewport().add(editorPane);
        viewExercisePanel.add(scrollPane_Description);

        // Load an RTF file into the editor
        try {
          FileInputStream myFile = new FileInputStream("C:\\exerciseDescription.rtf");
          exerciseDescription.read(myFile, editorPane.getDocument(), 0);
        } catch (FileNotFoundException e) {
          System.out.println("File not found");
        } catch (IOException e) {
          System.out.println("I/O error");
        } catch (BadLocationException e) {
        }
		
		//adds action to the viewExercise button
		viewExercise.addActionListener(new ActionListener() {
			//when viewExercise is clicked by user, it takes user to a frame
			//that shows how to do each work out that was given in combo box
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				
				//shows viewExerciseFrame to the user
				viewExerciseFrame.setVisible(true);
			}
		});
		
		//Creating Track HEALTH INFO PANEL and all contents
		healthPanel = new JPanel();
		healthPanel.setBounds(6, 6, 603, 349);
		activitiesFrame.setContentPane(tabs);
		healthPanel.setLayout(null);
		tabs.addTab("Track Health Info", healthPanel);
		
		//creates blood pressure label to primpt user to enter blood pressures
		bloodPressure_label = new JLabel("Blood Pressure");
		bloodPressure_label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		bloodPressure_label.setBounds(96, 66, 107, 16);
		healthPanel.add(bloodPressure_label);
		
		//creates text field for user to input their diastolic blood pressure
		txtDiastolic = new JTextField();
		txtDiastolic.setText("Diastolic");
		txtDiastolic.setBounds(74, 82, 134, 28);
		healthPanel.add(txtDiastolic);
		txtDiastolic.setColumns(10);

		//creates text field for user to input their systolic blood pressure
		txtSystolic = new JTextField();
		txtSystolic.setText("Systolic");
		txtSystolic.setBounds(74, 110, 134, 28);
		healthPanel.add(txtSystolic);
		txtSystolic.setColumns(10);

		//creates label for sleep hours
		sleepHours_label = new JLabel("Sleep Hours");
		sleepHours_label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		sleepHours_label.setBounds(107, 150, 86, 16);
		healthPanel.add(sleepHours_label);
		
		//creates hours label
		hours_label = new JLabel("hours");
		hours_label.setBounds(96, 169, 58, 28);
		healthPanel.add(hours_label);		
		
		//creates text field for user to input hours slept the night before
		txtHours = new JTextField("00:00");
		txtHours.setBounds(157, 178, 53, 16);
		healthPanel.add(txtHours);
		txtHours.setColumns(10);

		//creates calories label
		calories_label = new JLabel("Calories");
		calories_label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		calories_label.setBounds(107, 209, 78, 16);
		healthPanel.add(calories_label);
		
		//creates text field for user to enter amount of calories burned
		txtCaloriesBurned = new JTextField();
		txtCaloriesBurned.setText("Enter Calories Burned");
		txtCaloriesBurned.setBounds(74, 227, 155, 28);
		healthPanel.add(txtCaloriesBurned);
		txtCaloriesBurned.setColumns(10);

		//creates text field for user to enter amount of calories they ate that day
		txtCalorieIntake = new JTextField();
		txtCalorieIntake.setText("Enter Calorie Intake");
		txtCalorieIntake.setBounds(74, 255, 155, 28);
		healthPanel.add(txtCalorieIntake);
		txtCalorieIntake.setColumns(10);		

		//creates label for date entry
		dateOfEntry_label = new JLabel("Date of Entry");
		dateOfEntry_label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		dateOfEntry_label.setBounds(383, 66, 93, 16);
		healthPanel.add(dateOfEntry_label);
	
		//creates combo box for the month
		monthBox_health = new JComboBox(month);
		monthBox_health.setToolTipText("");
		monthBox_health.setBounds(300, 84, 100, 27);
		healthPanel.add(monthBox_health);		

		//creates combo box for the day
		dayBox_health = new JComboBox(day);
		dayBox_health.setBounds(393, 84, 63, 26);
		healthPanel.add(dayBox_health);
		
		//creates combo box for the year
		yearBox_health = new JComboBox(year);
		yearBox_health.setBounds(453, 84, 88, 27);
		healthPanel.add(yearBox_health);
		
		//creates label for time of entry
		timeOfEntry_label = new JLabel("Time of Entry");
		timeOfEntry_label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		timeOfEntry_label.setBounds(383, 116, 93, 16);
		healthPanel.add(timeOfEntry_label);
		
		//creates text field for user to input time of entry
		txtEntryTime = new JTextField();
		txtEntryTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntryTime.setText("00:00");
		txtEntryTime.setColumns(10);
		txtEntryTime.setBounds(350, 144, 53, 28);
		healthPanel.add(txtEntryTime);

		//creates combo box to choose if time is am or pm
		am_pm = new JComboBox(time);
		am_pm.setBounds(453, 146, 76, 27);
		healthPanel.add(am_pm);	

		//creates button that saves user entry when clicked
		btnSubmit_health = new JButton("Submit");
		btnSubmit_health.setBounds(369, 204, 117, 29);
		healthPanel.add(btnSubmit_health);	
		
		//adds action to the submit button
		btnSubmit_health.addActionListener(new ActionListener() {
			//when Back button is clicked, it saves all the health information inputed by user.
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//saves all user's inputs
				userDiastolic = Integer.parseInt(txtDiastolic.getText());
				userSystolic = Integer.parseInt(txtSystolic.getText());
				userSleep = Integer.parseInt(txtHours.getText());
				userBurned = Integer.parseInt(txtCaloriesBurned.getText());
				userIntake = Integer.parseInt(txtCalorieIntake.getText());
				userMonth_health = (String)monthBox_health.getSelectedItem();
				userDay_health = (String)dayBox_health.getSelectedItem();
				userYear_health = (String)yearBox_health.getSelectedItem();
				userTimeEntry = Integer.parseInt(txtEntryTime.getText());
				userAm_Pm = (String)am_pm.getSelectedItem();
				
				
				guiHealthLog = new HealthLog(guiCurrentUser.getID(),"userMonth_health+userDay_health+userYear_health",
						userSleep,userBurned,userIntake,userSystolic,userDiastolic);
				UserController.theData.add(guiHealthLog);
				
				/** if (health info submitted properly)
				 * {
				 * 		//displays success message if account created
				 * 		JOptionPane.showMessageDialog(createUser, "Health Indicator Saved!","A plain message",
    							JOptionPane.PLAIN_MESSAGE);
    				}
    				else
    				{
    					//displays error message
    					JOptionPane.showMessageDialog(createUser, "Health Indicators were not properly saved","Inane error",
    							JOptionPane.ERROR_MESSAGE);
    				}
				 */
				
			}
		});
		
		
		
		//--------------------------------------------------------------------------------
		
		
		
		viewPanel = new JPanel();
		viewPanel.setBounds(6, 6, 603, 349);
		activitiesFrame.setContentPane(tabs);
		viewPanel.setLayout(null);
		tabs.addTab("View Summary", viewPanel);
		
		//creates combo box for user to select the graph they wish to view
		graphChoice = new JComboBox(chooseGraph);
		graphChoice.setBounds(370, 6, 186, 27);
		viewPanel.add(graphChoice);
		
		
		graphChoice.addActionListener(new ActionListener() {
			//when button is clicked, screen changes to activities frame
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//saves doctor's choice for what to view
				data_graphChoice = (String)graphChoice.getSelectedItem();
				
				//if data table is selected
				if("Calories".equals(data_graphChoice))
				{
					calorieGraph calorieChart = new calorieGraph(null, "Calorie Summary");
				    calorieChart.pack();
				    calorieChart.setVisible(true);
				}
				//if blood pressure is selected
				else if("Blood Pressure".equals(data_graphChoice))
				{
				      bloodPressureGraph pressureChart = new bloodPressureGraph(null, "Blood Pressure Summary");
				      pressureChart.pack();
				      pressureChart.setVisible(true);
				}
				//if exercise is selected
				else if("Exercise Summary".equals(data_graphChoice))
				{
					exerciseGraph workoutChart = new exerciseGraph(null, "Work Out Summary");
				    workoutChart.pack();
				    workoutChart.setVisible(true);
				}
				//if calories was selected
				else
				{
					sleepGraph sleepChart = new sleepGraph(null, "Sleep Summary");
				    sleepChart.pack();
				    sleepChart.setVisible(true);
				}
		
			}
		});
		
				
		//panel for the health indicator table 
		healthIndicator_Panel = new JPanel(null);
		healthIndicator_Panel.setBounds(6, 61, 302, 214);
		viewPanel.add(healthIndicator_Panel);
				
		//sets rows and columns for health indicator table						
		Object rowInfo[][] = { {"Weight (lbs)", weight},
				   {"Dystolic Blood Pressure", userDiastolic},
				   {"Systolic Blood Pressure", userSystolic},
				   {"Calorie Intake", userIntake},
				   {"Calories Burned", userBurned},
				   {"Hours Slept", userSleep} };
		Object columnNames [] = { "Health Indicator","Data"};

		//creates health table
		healthTable = new JTable(rowInfo, columnNames);
		healthTable.getColumnModel().getColumn(0).setPreferredWidth(145);
		healthTable.setFillsViewportHeight(true);
		healthTable.setBounds(6,24,232,132);
		healthTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
	    //creates scroll pane for health table to be in
		JScrollPane scrollHealthTable = new JScrollPane(healthTable);
	    scrollHealthTable.setBounds(0,0,284,214);
	    healthIndicator_Panel.add(scrollHealthTable);

	    //creates panel for work out summary table
	    workoutSummary_Panel = new JPanel(null);
	    workoutSummary_Panel.setBounds(311, 61, 280, 214);
		viewPanel.add(workoutSummary_Panel);	
		
		
		//creates rows and columns for workout table
		//using this data for NOW but changing to users chosen exercises
		Object rowData[][] = { {"Weight (lbs)", weight},
				   {"Dystolic Blood Pressure", userDiastolic},
				   {"Systolic Blood Pressure", userSystolic},
				   {"Calorie Intake", userIntake},
				   {"Calories Burned", userBurned},
				   {"Hours Slept", userSleep} };
		Object columnHeaders [] = { "Exercises","Duration (hrs)"};
		
			
		
		
		//creates table for workout summary
		JTable workoutSumarry_Table = new JTable(rowData, columnHeaders);
		workoutSumarry_Table.getColumnModel().getColumn(0).setPreferredWidth(130);
		workoutSumarry_Table.setFillsViewportHeight(true);
		workoutSumarry_Table.setBounds(0, 0, 236, 132);
		workoutSumarry_Table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		//creates scroll pane for work out summary table
		JScrollPane scrollWorkouts = new JScrollPane(workoutSumarry_Table);
		scrollWorkouts.setBounds(0, 0, 298, 214);
		workoutSummary_Panel.add(scrollWorkouts);
		
		JButton printButton = new JButton("Print ");
		printButton.setBounds(21, 5, 186, 29);
		viewPanel.add(printButton);
		
		//adds action to the viewExercise button
		printButton.addActionListener(new ActionListener() {
		//when viewExercise is clicked by user, it takes user to a frame
		//that shows how to do each work out that was given in combo box
			@Override
			public void actionPerformed(ActionEvent arg0) {		
						
				MessageFormat header = new MessageFormat("Page {0,number,integer}");
				try {
				    healthTable.print(JTable.PrintMode.FIT_WIDTH, header, null);
				} catch (java.awt.print.PrinterException e) {
				    System.err.format("Cannot print %s%n", e.getMessage());
				}
		}});
		
				//neeeeeeed to finish print
				
				//try {
				    //boolean complete = healthTable.print();
				    //if (complete) {
				        /* show a success message  */
				        
				    //} else {
				        /*show a message indicating that printing was cancelled */
				       
				  //  }
				//} catch (PrinterException pe) {
				    /* Printing failed, report to the user */
				   
				//}
		
		
		
	//-----------------------------------------------------------------------------------
		//Patient to load users current info
		guiPatient = new Patient((Patient)UserController.search(guiCurrentUser.getType(), guiCurrentUser.getEmail()));
		//Create EDIT ACCOUNT PANEL and all contents
		editPanel = new JPanel();
		editPanel.setBounds(6, 6, 603, 349);
		activitiesFrame.setContentPane(tabs);
		editPanel.setLayout(null);
		tabs.addTab("Edit Account", editPanel);

		//creates text field for user to input first name
		txtFirstName = new JTextField();
		txtFirstName.setText(guiPatient.getFirstName());
		txtFirstName.setBounds(65, 66, 94, 28);
		editPanel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		//creates text field for user to input last name
		txtLastName = new JTextField();
		txtLastName.setText(guiPatient.getLastName());
		txtLastName.setBounds(161, 66, 88, 28);
		editPanel.add(txtLastName);
		txtLastName.setColumns(10);
			
		//Creates text field for user to input address
		txtStreetAddress = new JTextField();
		txtStreetAddress.setText(guiPatient.getAddress().street);
		txtStreetAddress.setBounds(63, 92, 134, 28);
		editPanel.add(txtStreetAddress);
		txtStreetAddress.setColumns(10);
		
		
		//creates text field for user to input zipcode
		txtZipCode = new JTextField();
		txtZipCode.setText(guiPatient.getAddress().zipCode);
		txtZipCode.setBounds(198, 92, 69, 28);
		editPanel.add(txtZipCode);
		txtZipCode.setColumns(10);
				
		//creates text field for user to input city
		txtCity = new JTextField();
		txtCity.setText(guiPatient.getAddress().city);
		txtCity.setBounds(65, 120, 88, 28);
		editPanel.add(txtCity);
		txtCity.setColumns(10);
		
		//creates combo box for user to select the state
		stateBox = new JComboBox(state);
		stateBox.setBounds(161, 122, 117, 27);
		editPanel.add(stateBox);
				
		//creates text field for user to input phone number
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText(guiPatient.getAddress().phone);
		txtPhoneNumber.setBounds(65, 153, 134, 28);
		editPanel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
			
		//creates text field for user's inputed height 
		txtHeight = new JTextField("0'00''");
//		txtHeight.setText(guiPatient.getHeight());
		txtHeight.setBounds(65, 179, 88, 28);
		editPanel.add(txtHeight);
		txtHeight.setColumns(10);
				
		//creates text field for user to input weight
		txtWeight = new JTextField();
//		txtWeight.setText(guiPatient.getWeight());
		txtWeight.setBounds(65, 203, 88, 28);
		editPanel.add(txtWeight);
		txtWeight.setColumns(10);		
		
		//creates label to prompt user to select their birth date
		birthLabel = new JLabel("Select Birthday");
		birthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		birthLabel.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		birthLabel.setBounds(371, 54, 134, 16);
		editPanel.add(birthLabel);
		
		//creates combo box of months for user to choose 
		monthBox_birth = new JComboBox(month);
		monthBox_birth.setToolTipText("");
		monthBox_birth.setBounds(310, 68, 100, 27);
		editPanel.add(monthBox_birth);		
		
		//creates combo box of days in a month for user to select
		dayBox_birth = new JComboBox(day);
		dayBox_birth.setBounds(403, 68, 63, 26);
		editPanel.add(dayBox_birth);
				
		//Creates combo box for user to select the year they were born
		yearBox_birth = new JComboBox(year);
		yearBox_birth.setBounds(458, 68, 99, 27);
		editPanel.add(yearBox_birth);		
		
		//creates combo box for user to choose a gender
		genderBox = new JComboBox(gender);
		genderBox.setBounds(65, 233, 117, 27);
		editPanel.add(genderBox);
		
		//creates label to prompt user to enter security info
		securityInfo_label = new JLabel("Security Info");
		securityInfo_label.setHorizontalAlignment(SwingConstants.CENTER);
		securityInfo_label.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		securityInfo_label.setBounds(388, 104, 106, 16);
		editPanel.add(securityInfo_label);
		
		//creates text field for user to enter a new password
		txtPassword = new JTextField();
		txtPassword.setText(guiPatient.getPassword());
		txtPassword.setBounds(371, 121, 134, 28);
		editPanel.add(txtPassword);
		txtPassword.setColumns(10);		
		
		//creates text field for user to verify password
		txtVerifyPassword = new JTextField();
		txtVerifyPassword.setText(guiPatient.getPassword());
		txtVerifyPassword.setBounds(371, 179, 134, 28);
		editPanel.add(txtVerifyPassword);
		txtVerifyPassword.setColumns(10);		
		
		//creates text field for user to enter password hint
		txtPasswordHint = new JTextField();
		txtPasswordHint.setText(guiPatient.getHint());
		txtPasswordHint.setBounds(371, 153, 134, 28);
		editPanel.add(txtPasswordHint);
		txtPasswordHint.setColumns(10);
		
		//creates button for user to submit edited account info
		btnSubmit_edit = new JButton("Submit");
		btnSubmit_edit.setBounds(371, 243, 117, 29);
		editPanel.add(btnSubmit_edit);
		
		//adds action to the submit button
		btnSubmit_edit.addActionListener(new ActionListener() {
			//when Back button is clicked, it takes the user back to login page
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				//SAVES ALL PERSONAL INFO TO USERS ACCOUNT IN DATABASE
				password = txtPassword.getText();
				verify = txtVerifyPassword.getText();
				hint = txtPasswordHint.getText();
				
				contains = UserController.listSearch(guiCurrentUser.getType(), guiCurrentUser.getEmail());

				//checks password verification
				// if password matches the verification then adds user inputs to account
				if((contains)&&(password.equals(verify)))
				{
					guiPatient.setFirstName(txtFirstName.getText());
					guiPatient.setLastName(txtLastName.getText());
					guiPatient.pAddress.street = txtStreetAddress.getText();
					guiPatient.pAddress.zipCode = txtZipCode.getText();
					guiPatient.pAddress.city = txtCity.getText();
					guiPatient.pAddress.state = (String)stateBox.getSelectedItem();
					guiPatient.pAddress.phone = txtPhoneNumber.getText();
					guiPatient.setHeight(Double.parseDouble(txtHeight.getText()));
					guiPatient.setWeight(Double.parseDouble(txtWeight.getText()));
					guiPatient.setBirthDate((String)monthBox_birth.getSelectedItem()+(String)dayBox_birth.getSelectedItem()+(String)yearBox_birth.getSelectedItem());
					userGender = (String)genderBox.getSelectedItem();
				}
				else{
					JOptionPane.showMessageDialog(activitiesFrame,
						    "Entered password did not match the password verification",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		
		
		//creates DOCTOR SUGGESTIONS FRAME
		notesForUserPanel = new JPanel();
		notesForUserPanel.setBounds(6, 6, 603, 349);
		activitiesFrame.setContentPane(tabs);
		notesForUserPanel.setLayout(null);
		tabs.addTab("Doctor Suggestions", notesForUserPanel);

		//creates text area to display doctor's notes/suggestions
		noteFromDoctor = new JTextArea();
		noteFromDoctor.setText("Doctor Suggestions");
		noteFromDoctor.setRows(10);
		noteFromDoctor.setBounds(6, 6, 603, 349);
		notesForUserPanel.add(noteFromDoctor);
		
		
		//declare and initialize CREATE USER FRAME and all its contents
		createUser = new JFrame();
		createUser.setBounds(100, 100, 615, 383);
		createUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUser.getContentPane().setLayout(null);
		
		//creates create user panel
		createUserPanel = new JPanel();
		createUserPanel.setBounds(6, 6, 603, 349);
		createUser.getContentPane().add(createUserPanel);
		createUserPanel.setLayout(null);
		
		//creates create user label
		createUserLabel = new JLabel("Create a User");
		createUserLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		createUserLabel.setBounds(198, 26, 201, 28);
		createUserPanel.add(createUserLabel);
		
		//text field to get user's first name
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(65, 66, 94, 28);
		createUserPanel.add(txtFirstName);
		txtFirstName.setColumns(10);		
		
		//text field to get user's last name
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setBounds(161, 66, 88, 28);
		createUserPanel.add(txtLastName);
		txtLastName.setColumns(10);
		
		//text field for user's address
		txtStreetAddress = new JTextField();
		txtStreetAddress.setText("Street Address");
		txtStreetAddress.setBounds(63, 92, 134, 28);
		createUserPanel.add(txtStreetAddress);
		txtStreetAddress.setColumns(10);

		//text field to get user's zipcode
		txtZipCode = new JTextField();
		txtZipCode.setText("Zip Code");
		txtZipCode.setBounds(198, 92, 69, 28);
		createUserPanel.add(txtZipCode);
		txtZipCode.setColumns(10);
		
		//text field to get user's city
		txtCity = new JTextField();
		txtCity.setText("City");
		txtCity.setBounds(65, 120, 88, 28);
		createUserPanel.add(txtCity);
		txtCity.setColumns(10);
		
		//text field to get user's phone number
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText("Phone Number");
		txtPhoneNumber.setBounds(65, 153, 134, 28);
		createUserPanel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);   

	    //creates combo box for user to choose if patient or doctor
	    choiceBox = new JComboBox(choice);
	    choiceBox.setBounds(65, 185, 117, 27);
	    createUserPanel.add(choiceBox);
		
		//creates text field for user to enter desired username
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(371, 66, 117, 28);
		createUserPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		//text field for user to enter desired password
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(371, 92, 117, 28);
		createUserPanel.add(txtPassword);
		txtPassword.setColumns(10);
		
		//text field for user to input a password hint
		txtPasswordHint = new JTextField();
		txtPasswordHint.setText("Password Hint");
		txtPasswordHint.setBounds(371, 120, 117, 28);
		createUserPanel.add(txtPasswordHint);
		txtPasswordHint.setColumns(10);
		
		//saves user's hint
		hint = txtPasswordHint.getText();
		
		//button for user to click when wanting to create the account
		submitCreated = new JButton("Submit");
		submitCreated.setBounds(371, 245, 117, 29);
		createUserPanel.add(submitCreated);
		

		//adds action to the Submit button
		submitCreated.addActionListener(new ActionListener() {
			//when submit button is clicked it created the user
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				//CREATES USER
				username = txtUsername.getText();
				password = txtPassword.getText();
				hint = txtPasswordHint.getText();
					first = txtFirstName.getText();
					last = txtLastName.getText();
					guiAddress.street = txtStreetAddress.getText();
					guiAddress.zipCode = txtZipCode.getText();
					guiAddress.city = txtCity.getText();
					guiAddress.state = (String)stateBox.getSelectedItem();
					guiAddress.phone = txtPhoneNumber.getText();
					userChoice = (String)choiceBox.getSelectedItem();
					
					
					if(userChoice.equalsIgnoreCase("patient"))
						contains = UserController.listSearch("patient", username);
					else if(userChoice.equalsIgnoreCase("doctor"))
						contains = UserController.listSearch("doctor", username);
					
					//ADD USER INPUTS TO DATABASE, CHECK IF ADDED, show jdialog
					 if (contains){
		  					//displays error message if account was not created
	 					JOptionPane.showMessageDialog(createUser, "Account was not created, Username already exist, please try again","Inane error",
	 							JOptionPane.ERROR_MESSAGE);
					 }else{
						if(userChoice.equalsIgnoreCase("patient")){
							 guiPatient = new Patient(++idCounter, username, first, last, password, hint, guiAddress);
							 UserController.theData.add(guiPatient);
						}else if(userChoice.equalsIgnoreCase("doctor")){
							guiDoctor = new Doctor(++idCounter, username, first, last, password, hint);
							UserController.theData.add(guiDoctor);
						}
						 
					 		//displays success message if account created
					 		JOptionPane.showMessageDialog(createUser, "Account as successfully created!","A plain message",
	 							JOptionPane.PLAIN_MESSAGE);
							//hides the createUser frame
							createUser.setVisible(false);
							//shows the login frame
							login.setVisible(true);
		//					controller.fileWrite(theGuiData);
					 }
			}
		});
		
		//Exit button for user to go back to login page if decide to
		//not create an account
		btnExit = new JButton("Exit");
		btnExit.setBounds(371, 272, 117, 29);
		createUserPanel.add(btnExit);
		
		//adds action to Back button
		btnExit.addActionListener(new ActionListener() {
			//when exit button is clicked, it takes the user back to login page
			@Override
			public void actionPerformed(ActionEvent arg0){		
				//hides the createUser frame
				createUser.setVisible(false);
				//shows the login frame
				login.setVisible(true);
			}
		});
	
		//creates FORGOTPASSWORD FRAME
		forgotPasswordFrame = new JFrame();
		forgotPasswordFrame.setBounds(100, 100, 615, 383);
		forgotPasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forgotPasswordFrame.getContentPane().setLayout(null);

		//creates the forgotPanel JPanel
		forgotPanel = new JPanel();
		forgotPanel.setBounds(6, 6, 603, 349);
		forgotPasswordFrame.getContentPane().add(forgotPanel);
		forgotPanel.setLayout(null);
		
		//creates enter username label
		JLabel usernameLabel = new JLabel("Enter UserName");
		usernameLabel.setBounds(161, 69, 107, 16);
		forgotPanel.add(usernameLabel);
		
		//creates text field for user to input username
		usernameTextField = new JTextField();
		usernameTextField.setBounds(271, 63, 159, 28);
		forgotPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		//creates label for chosen hint
		hintLabel = new JLabel("Chosen Hint:");
		hintLabel.setBounds(179, 109, 89, 16);
		forgotPanel.add(hintLabel);
		
		//creates label that will show the hint if username entered is found
		showHint = new JLabel(" ");
		showHint.setBounds(271, 109, 254, 16);
		forgotPanel.add(showHint);
		showHint.setVisible(false);
		
		//creates the enter button for the user's username
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(430, 64, 117, 29);
		forgotPanel.add(btnEnter);
		
		//adds action to btnEnter
		btnEnter.addActionListener(new ActionListener(){
			//when Enter button is clicked, it saves the user's input and compares to others in database
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   
				first = txtFirstName.getText();
				last = txtLastName.getText();
				usernameEntered = usernameTextField.getText();
				
				contains = UserController.listSearch("Patient", usernameEntered);

				//CHANGE TO FIND "username" from database
				//if the username inputed by user matches a username in the database
				if(contains)
				{
					guiPatient = (Patient) UserController.search("patient", usernameEntered);
					guiPatient.setAuthenticate(true);
					//shows the hint chosen by the user
					showHint.setText(guiPatient.getHint());
					showHint.setVisible(true);
					passwordLabel.setVisible(true);
					passwordTextField.setVisible(true);
					btnEnterPassword.setVisible(true);
					
				}
				//the username was not found in the database
				else
				{
					//shows error message
					JOptionPane.showMessageDialog(forgotPanel, "Username was not found","A plain message",
		    				JOptionPane.PLAIN_MESSAGE);
					//hides the hint
					showHint.setVisible(false);
				}
			
			}
		});
		
		//creates label to prompt user to enter password
		passwordLabel = new JLabel("Enter Password");
		passwordLabel.setBounds(161, 164, 107, 16);
		forgotPanel.add(passwordLabel);
		passwordLabel.setVisible(false);
		
		//creates text field for user to input password
		passwordTextField = new JTextField();
		passwordTextField.setBounds(271, 158, 159, 28);
		forgotPanel.add(passwordTextField);
		passwordTextField.setColumns(10);
		passwordTextField.setVisible(false);
		
		//creates button for user to enter password
		btnEnterPassword = new JButton("Enter");
		btnEnterPassword.setBounds(430, 159, 117, 29);
		forgotPanel.add(btnEnterPassword);
		btnEnterPassword.setVisible(true);
		
		//adds action to the btnEnterPassword button
		btnEnterPassword.addActionListener(new ActionListener(){
			//when button is clicked, it saves and checks password inputed by user
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//saves user input
				usernameEntered = usernameTextField.getText();
				passwordEntered = passwordTextField.getText();
				contains = UserController.listSearch("Patient", usernameEntered);
			
				//HAVE TO CHECK DATABASE NOT SURE HOW TO DO THAT?
				//checks to see if the password entered matches the username in the database
				if(contains && (guiPatient.getAuthenticate()))
				{
					guiCurrentUser = (User)UserController.search("patient", usernameEntered);
					//hides forgot password frame
					forgotPasswordFrame.setVisible(false);
					//logs user into system and shows activity frame
					activitiesFrame.setVisible(true);
				}
				//the enterd password did not match the entered username in the database
				else 
				{
					JOptionPane.showMessageDialog(forgotPanel, "Password entered is incorrect","A plain message",
		    				JOptionPane.PLAIN_MESSAGE);
				}
			
			}});
		
		//creates button to exit back to login screen
		btnExit_Forgot = new JButton("Exit");
		btnExit_Forgot.setBounds(238, 316, 117, 29);
		forgotPanel.add(btnExit_Forgot);
		
		//adds action to exit button in forgot password panel
		btnExit_Forgot.addActionListener(new ActionListener() {
		//when exit button is clicked, it takes the user back to login page
			public void actionPerformed(ActionEvent arg0){		
				//hides the forgot password frame
				forgotPasswordFrame.setVisible(false);
				//shows the login frame
				login.setVisible(true);
			}
		});		
		
		
		//creates DOCTOR FRAME and all of its content
		Doctor = new JFrame();
		Doctor.setBounds(100, 100, 681, 479);
		Doctor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Doctor.getContentPane().setLayout(null);
		Doctor.setVisible(false);
		
		//PRINT PATIENTS NAME IN TEXTAREA
		//creates JTextArea and JScrollPane
		patients = new JTextArea();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 195, 445);
		Doctor.getContentPane().add(scrollPane);
		
		//creates panel for graph and data
		patientInfoPanel = new JPanel();
		patientInfoPanel.setBounds(213, 37, 462, 272);
		Doctor.getContentPane().add(patientInfoPanel);
		
	
		
		healthIndicator_Panel = new JPanel(null);
		healthIndicator_Panel.setBounds(6, 6, 236, 132);
		Doctor.add(healthIndicator_Panel);

		//creates health table
		healthTable = new JTable(rowInfo, columnNames);
		healthTable.getColumnModel().getColumn(0).setPreferredWidth(145);
		healthTable.setFillsViewportHeight(true);
		healthTable.setBounds(6,24,236,132);
		healthTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
	    //creates scroll pane for health table to be in
		scrollHealthTable = new JScrollPane(healthTable);
	    scrollHealthTable.setBounds(0,0,236,132);
	    healthIndicator_Panel.add(scrollHealthTable);

	    //creates panel for work out summary table
	    workoutSummary_Panel = new JPanel(null);
	    workoutSummary_Panel.setBounds(6, 140, 236, 183);
	    Doctor.add(workoutSummary_Panel);	
		
		
		//doctors needs specific patients info
		//sets rows and columns for work out summary table
		//need to make it take in info from user
		//Object rowData[][] = { userWorkouts, userDuration  };
		//Object columnHeaders [] = { "Exercise","Duration (hrs)"};
		
		//neeeeeeed to finish print
		
		//try {
		    //boolean complete = healthTable.print();
		    //if (complete) {
		        /* show a success message  */
		        
		    //} else {
		        /*show a message indicating that printing was cancelled */
		       
		  //  }
		//} catch (PrinterException pe) {
		    /* Printing failed, report to the user */
		   
		//}
			
		
		
		//creates table for workout summary
		workoutSumarry_Table = new JTable(rowData, columnHeaders);
		workoutSumarry_Table.getColumnModel().getColumn(0).setPreferredWidth(130);
		workoutSumarry_Table.setFillsViewportHeight(true);
		workoutSumarry_Table.setBounds(0, 0, 236, 132);
		workoutSumarry_Table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		//creates scroll pane for work out summary table
		scrollWorkouts = new JScrollPane(workoutSumarry_Table);
		scrollWorkouts.setBounds(0, 0, 236, 177);
		workoutSummary_Panel.add(scrollWorkouts);	
		
		data_graphBox = new JComboBox(chooseGraph);
		data_graphBox.setBounds(418, 6, 257, 27);
		Doctor.getContentPane().add(data_graphBox);
		
		txtSuggestions = new JTextArea();
		txtSuggestions.setText("Enter notes for patient");
		txtSuggestions.setRows(10);
		txtSuggestions.setBounds(213, 318, 338, 133);
		Doctor.getContentPane().add(txtSuggestions);
		
		data_graphBox.addActionListener(new ActionListener() {
			//when button is clicked, screen changes to activities frame
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//saves doctor's choice for what to view
				data_graphChoice = (String)data_graphBox.getSelectedItem();
				
				//if data table is selected
				if("Calories".equals(data_graphChoice))
				{
					calorieGraph calorieChart = new calorieGraph(null, "Calorie Summary");
				    calorieChart.pack();
				    calorieChart.setVisible(true);
				}
				//if blood pressure is selected
				else if("Blood Pressure".equals(data_graphChoice))
				{
				      bloodPressureGraph pressureChart = new bloodPressureGraph(null, "Blood Pressure Summary");
				      pressureChart.pack();
				      pressureChart.setVisible(true);
				}
				//if exercise is selected
				else if("Exercise Summary".equals(data_graphChoice))
				{
					exerciseGraph workoutChart = new exerciseGraph(null, "Work Out Summary");
				    workoutChart.pack();
				    workoutChart.setVisible(true);
				}
				//if calories was selected
				else
				{
					sleepGraph sleepChart = new sleepGraph(null, "Sleep Summary");
				    sleepChart.pack();
				    sleepChart.setVisible(true);
				}
		
			}
		});

		//creates button for doctor to submit suggestions
		btnSubmit_Doctor = new JButton("Submit");
		btnSubmit_Doctor.setBounds(558, 368, 117, 29);
		Doctor.getContentPane().add(btnSubmit_Doctor);

		//adds action to the submit button
		btnSubmit_Doctor.addActionListener(new ActionListener() {
			//when button is clicked, suggestions are saved for patient to view
			@Override
			public void actionPerformed(ActionEvent arg0) {
			//saves doctor's suggestions for specific patient
			suggestions = txtSuggestions.getText();
			noteFromDoctor = new JTextArea(suggestions);
			
			/** if (suggestions saved properly to user)
			 * {
			 * 		//displays success message if account created
			 * 		JOptionPane.showMessageDialog(createUser, "Suggestions were submitted!","A plain message",
							JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					//displays error message if account was not created
					JOptionPane.showMessageDialog(createUser, "Error: did not submit","Inane error",
							JOptionPane.ERROR_MESSAGE);
				}
			 */
			
			}
		});				
		
		
		
		

		
		
	}
}

