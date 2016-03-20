package ru.pes.systeminfoclient.objects;

import java.io.Serializable;


public class Ram implements Serializable{
    
    private String total;
    
    public Ram(String total){
        this.total = total;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }
    
}
