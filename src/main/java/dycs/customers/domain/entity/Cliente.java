package dycs.customers.domain.entity;



public class Cliente {
	
	private long id;
	private String firstName;
	private long lastName;
	private long rol;
	private long isActive;
	
		
	public Cliente() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public long getLastName() {
		return lastName;
	}
	public void setLastName(long lastName) {
		this.lastName = lastName;
	}
	public long getRol() {
		return rol;
	}
	public void setRol(long rol) {
		this.rol = rol;
	}
	public long getIsActive() {
		return isActive;
	}
	public void setIsActive(long isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
    
    
    

}
