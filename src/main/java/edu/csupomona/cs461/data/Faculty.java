package edu.csupomona.cs461.data;

import java.util.Date;


public class Faculty {

	/** The unique user ID */
    private String id;
    private String name;
    private String email;
    private String department;
    private String office;
    private String officeHours;
    private String updateTime;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setOffice(String office) {
		this.office = office;
	}
	
	public String getOffice() {
		return office;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	
	public String getOfficeHours() {
		return officeHours;
	}
	
	public String getUpdateTime() {
		
		return updateTime;
	}

	public void setUpdateTime() {
		updateTime = new Date(System.currentTimeMillis()).toString();
	}
}
