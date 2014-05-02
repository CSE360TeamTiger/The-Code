//Address.java
//FILE COMPLETE

public class Address {
	public String street;
	public String city;
	public String state;
	public String zipCode;
	public String phone;

	public Address(String street, String city, String state, String zipCode, String phnum) {
		this.state = state;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.phone = phnum;
	}

	public Address() {
		this.state = "";
		this.street = "";
		this.city = "";
		this.zipCode = "";
		this.phone = "";
	}
	
	public String toString(){
		return (street +" "+ city  +" "+ state  +" "+ zipCode +" "+ phone + " \n");
	}

}
