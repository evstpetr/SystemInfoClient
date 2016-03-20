package ru.pes.systeminfoclient.objects;

import java.io.Serializable;


public class Cpu implements Serializable{

    private String vendor;
    private String model;
    private String cores;
    private String mhz;
    
    public Cpu(String vendor, String model, String cores, String mhz){
        this.vendor = vendor;
        this.model = model;
        this.cores = cores;
        this.mhz = mhz;
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
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the cores
     */
    public String getCores() {
        return cores;
    }

    /**
     * @param cores the cores to set
     */
    public void setCores(String cores) {
        this.cores = cores;
    }

    /**
     * @return the mhz
     */
    public String getMhz() {
        return mhz;
    }

    /**
     * @param mhz the mhz to set
     */
    public void setMhz(String mhz) {
        this.mhz = mhz;
    }
    
}
