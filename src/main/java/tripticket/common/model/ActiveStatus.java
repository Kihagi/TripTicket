package tripticket.common.model;

public enum ActiveStatus {
	
	ACTIVE("Active"),
	INACTIVE("Inactive");
	
	private String name;
	
	private ActiveStatus(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
