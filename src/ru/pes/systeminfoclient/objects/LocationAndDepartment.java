package ru.pes.systeminfoclient.objects;

import java.io.Serializable;


public class LocationAndDepartment implements Serializable{
    
    private String location;
    private String department;
    
    public LocationAndDepartment(String location, String department){
        this.location = location;
        this.department = department;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    
}
