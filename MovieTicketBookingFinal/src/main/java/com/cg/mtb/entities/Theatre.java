package com.cg.mtb.entities;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "theatre")
public class Theatre {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Min(value=1,message="TheatreId cannot be zero or negative")
	private int theatreId;
	@NotEmpty
	private String theatreName;
	@NotEmpty
	private String theatreCity;
	@NotEmpty
	private String managerName;
	@Min(value=10)
	private int managerContact;
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreCity() {
		return theatreCity;
	}
	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(int managerContact) {
		this.managerContact = managerContact;
	}
	public Theatre(){
		
	}
	public Theatre(int theatreId, String theatreName, String theatreCity, String managerName, int managerContact) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}
	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreCity=" + theatreCity
				+ ", managerName=" + managerName + ", managerContact=" + managerContact + "]";
	}
   
	
	
}


