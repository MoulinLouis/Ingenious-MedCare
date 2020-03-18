package models;

public class PatientModel {
	
	private int id;
    private String name;
    private String firstname; 
    private String birthDate; 
    private String email;
    private String gender; 
    private String country; 
    private String profession; 
    
    
    public PatientModel(int id, String name, String firstname, String birthDate, String email, String gender,  String country, String profession)
    {
        this.id = id;
        this.name = name;
        this.firstname = firstname; 
        this.birthDate = birthDate; 
        this.email = email;
        this.gender = gender; 
        this.country = country;
        this.profession = profession;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getFirstName()
    {
        return firstname;
    }
    
    public String getBirthDate()
    {
        return birthDate;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public String getProfession()
    {
        return profession;
    }
}
