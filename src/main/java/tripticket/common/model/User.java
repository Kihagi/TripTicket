package tripticket.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class User {
	@Column
	private String username;
	
	@Column
	private String password;

}
