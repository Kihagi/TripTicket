package tripticket.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class User {
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String usertype;

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
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

}
