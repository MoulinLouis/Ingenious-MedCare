package constructor;

public class Patient {
	private int id, postalCode, phoneNumber, homePhoneNumber, socialSecurityNumber, mutualNumber;
	private String name, firstName, birthDate, email, gender, address, city, country, profession, civilStatus, bloodGroup, pathology, note, familyDoctor;
	
	public Patient(int id, String name, String firstName, String birthDate, String email, String gender, String address, String city, int postalCode, 
			int phoneNumber, int homePhoneNumber, String country, String profession, String civilStatus, int socialSecurityNumber, int mutualNumber, 
			String bloodGroup, String pathology, String note, String familyDoctor) {
		
	}
	public int id() {
		return id;
	}
	public String name() {
		return name;
	}
	public String firstName() {
		return firstName;
	}
	public String birthDate() {
		return birthDate;
	}
	public String email() {
		return email;
	}
	public String gender() {
		return gender;
	}
	public String address() {
		return address;
	}
	public String city() {
		return city;
	}
	public int postalCode() {
		return postalCode;
	}
	public int phoneNumber() {
		return phoneNumber;
	}
	public int homePhoneNumber() {
		return homePhoneNumber;
	}
	public String country() {
		return country;
	}
	public String profession() {
		return profession;
	}
	public String civilStatus() {
		return civilStatus;
	}
	public int socialSecurityNumber() {
		return socialSecurityNumber;
	}
	public int mutualNumber() {
		return mutualNumber;
	}
	public String bloodGroup() {
		return bloodGroup;
	}
	public String pathology() {
		return pathology;
	}
	public String note() {
		return note;
	}
	public String familyDoctor() {
		return familyDoctor;
	}
}