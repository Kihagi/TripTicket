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
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name = "name")
	private String name;
    
	@Column(name = "descr")
	private String Descr;

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

}
