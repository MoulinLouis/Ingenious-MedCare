package constructor;

public class User {
	private int id, idRole;
	private String login, email, password, name, firstName;
	
	public User(int id, String login, String email, String password, String name, String firstName, int idRole) {
		this.id=id;
		this.login = login;
		this.email = email;
		this.password = name;
		this.firstName = firstName;
		this.idRole = idRole;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getFirstName() {
		return firstName;
	}
	public int getIdRole() {
		return idRole;
	}
}
