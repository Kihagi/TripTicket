package trioticket.location.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loc_location")
public class Location {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name = "name")
	private String name;
    
	@Column(name = "descr", columnDefinition = "TEXT")
	private String Descr;
	
	@Column(name = "loc_number", unique = true)
	private String locNo;
	
	public String getLocNo() {
		return locNo;
	}

	public void setLocNo(String locNo) {
		this.locNo = locNo;
	}

	public String getDescr() {
		return Descr;
	}

	public void setDescr(String descr) {
		Descr = descr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}
	
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"name\": \"").append(getName()).append("\",")
			.append("\"descr\": \"").append(getDescr()).append("\",")
			.append("\"loc_number\": \"").append(getLocNo()).append("\"");
		sb.append("}");
		
		return sb.toString();
		
	}

}
