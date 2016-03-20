package ru.pes.systeminfoclient.objects;

import java.io.Serializable;


public class Net implements Serializable{
    
    private String ipAddr;
    private String macAddr;
    private String pcName;
    
    public Net(String ipAddr, String macAddr, String pcName){
        this.ipAddr = ipAddr;
        this.macAddr = macAddr;
        this.pcName = pcName;
    }

    /**
     * @return the ipAddr
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * @param ipAddr the ipAddr to set
     */
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    /**
     * @return the macAddr
     */
    public String getMacAddr() {
        return macAddr;
    }

    /**
     * @param macAddr the macAddr to set
     */
    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    /**
     * @return the pcName
     */
    public String getPcName() {
        return pcName;
    }

    /**
     * @param pcName the pcName to set
     */
    public void setPcName(String pcName) {
        this.pcName = pcName;
    }
    
}
