package models;

public class UserModel {
    
	private int id;
    private String login;
    private String email; 
    private String password; 
    private String name;
    private String firstname; 
    private int idRole; 
    
    
    public UserModel(int id, String login, String email, String password, String name, String firstname, int idRole)
    {
        this.id = id;
        this.login = login;
        this.login = email; 
        this.email = password; 
        this.password = name;
        this.name = firstname; 
        this.idRole = idRole;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getLogin()
    {
        return login;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getFirstname()
    {
        return firstname;
    }
    
    public int getIdRole()
    {
        return idRole;
    }
}