package ro.ugal.si.model;

public class UserInfo {

	private int idUserInfo;
	private int idUser;
	private String firstName;
	private String lastName;
	private String email;
	
	
	public int getIdUserInfo() {
		return idUserInfo;
	}
	public void setIdUserInfo(int idUserInfo) {
		this.idUserInfo = idUserInfo;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	@Override
	public String toString() {
		return "UserInfo [idUserInfo=" + idUserInfo + ", idUser=" + idUser + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}
	
}
