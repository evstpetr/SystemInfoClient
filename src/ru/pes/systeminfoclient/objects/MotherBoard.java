package ru.pes.systeminfoclient.objects;

import java.io.Serializable;


public class MotherBoard implements Serializable{
    
    private String vendor;
    private String name;

    public MotherBoard(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @param vendor the vendor to set
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
