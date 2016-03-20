package ru.pes.systeminfoclient.objects;

import java.io.Serializable;


public class OS implements Serializable{
    
    private String name;
    private String arch;
    
    public OS(String name, String arch){
        this.name = name;
        this.arch = arch;
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

    /**
     * @return the arch
     */
    public String getArch() {
        return arch;
    }

    /**
     * @param arch the arch to set
     */
    public void setArch(String arch) {
        this.arch = arch;
    }
    
    
}
