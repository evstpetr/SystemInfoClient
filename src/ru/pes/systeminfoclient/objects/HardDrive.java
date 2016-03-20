package ru.pes.systeminfoclient.objects;

import java.io.Serializable;

public class HardDrive implements Serializable {

    private String name;
    private String systemtype;
    private String free;
    private String total;

    public HardDrive(String name, String systemtype, String free, String total) {
        this.name = name;
        this.systemtype = systemtype;
        this.free = free;
        this.total = total;
    }

    /**
     * @return the free
     */
    public String getFree() {
        return free;
    }

    /**
     * @param free the free to set
     */
    public void setFree(String free) {
        this.free = free;
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
     * @return the systemtype
     */
    public String getsystemtype() {
        return systemtype;
    }

    /**
     * @param systemtype the systemtype to set
     */
    public void setsystemtype(String systemtype) {
        this.systemtype = systemtype;
    }

}
