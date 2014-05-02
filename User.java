

public class User {
	private int iD;
	private String accountType;
	private boolean authenticated;
	private String email;
	private String firstName;
	private String lastName;
	private String encryptedPassword;
	private String hint;
	
	public User(int i,String email, String fName, String lName, String password, String h, String acc){
		this.iD = i;
		this.email = email;
		this.accountType = acc;
		this.encryptedPassword = password;
		this.hint = h;
		this.firstName = fName;
		this.lastName = lName;
		this.authenticated = false;
	}
	public User(String user, String password , String acc){
		this.email = user;
		this.encryptedPassword = password;
		this.accountType = acc;
	}
	public User(){
		this.iD = 0;
		this.email = "";
		this.accountType = "";
		this.encryptedPassword = "";
		this.hint = "";
		this.firstName = "";
		this.lastName ="";
		this.authenticated = false;
	}

	
	public String toString(){return (accountType  + " " + iD +" "+ email + " "+ encryptedPassword + " "+ firstName + " "+ lastName + " "+ hint);}
	public String getEmail(){ return email;}
	public String getType(){ return accountType;}
	public String getFirstName(){ return firstName;}
	public String getLastName(){ return lastName;}
	public String getPassword(){ return encryptedPassword;}
	public String getHint(){return hint;}
	public boolean getAuthenticate(){ return authenticated;}
	public int getID(){return iD;}
	
	
	public void setPassword(String password){ this.encryptedPassword = password;}
	public void setType(String type){this.accountType = type;}
	public void setEmail(String email){ this.email = email;}	
	public void setFirstName(String fName){ this.firstName  = fName;}
	public void setLastName(String lName){ this.lastName = lName;}
	public void setHint(String hint){this.hint = hint;}
	public void setAuthenticate(boolean authenticate){ this.authenticated = authenticate;}
	public void setID(int i){this.iD = i;}
}

