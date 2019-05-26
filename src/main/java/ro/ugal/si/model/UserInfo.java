package ro.ugal.si.model;

public class UserInfo {

	private int id_userInfo;
	private int id_user;
	private String firstName;
	private String lastName;
	private String email;
	
	public int getId_userInfo() {
		return id_userInfo;
	}
	public void setId_userInfo(int id_userInfo) {
		this.id_userInfo = id_userInfo;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
