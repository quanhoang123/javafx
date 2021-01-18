package Login;

import java.sql.Date;

public class UserDto {

	private int id;
	private String username;
	private String password;
	private Date birthday;
	private String phoneNumber;
	private String address;

	public UserDto() {

	}

	public UserDto(String username, String password, Date birthday, String phoneNumber, String address) {
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public UserDto(int id, String username, String password, Date birthday, String phoneNumber, String address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
