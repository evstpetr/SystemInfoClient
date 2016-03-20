package ru.pes.systeminfoclient.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class SystemInformation implements Serializable {

    private LocationAndDepartment lad;
    private Inventory inventory;
    private OS os;
    private MotherBoard mb;
    private Cpu cpu;
    private ArrayList<HardDrive> arrHd;
    private Ram ram;
    private Net net;

    public SystemInformation() {
    }

    /**
     * @return the os
     */
    public OS getOS() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOS(OS os) {
        this.os = os;
    }

    /**
     * @return the cpu
     */
    public Cpu getCpu() {
        return cpu;
    }

    /**
     * @param cpu the cpu to set
     */
    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    /**
     * @return the ram
     */
    public Ram getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(Ram ram) {
        this.ram = ram;
    }

    /**
     * @return the net
     */
    public Net getNet() {
        return net;
    }

    /**
     * @param net the net to set
     */
    public void setNet(Net net) {
        this.net = net;
    }

    /**
     * @return the lad
     */
    public LocationAndDepartment getLad() {
        return lad;
    }

    /**
     * @param lad the lad to set
     */
    public void setLad(LocationAndDepartment lad) {
        this.lad = lad;
    }

    /**
     * @return the arrHd
     */
    public ArrayList<HardDrive> getArrHd() {
        return arrHd;
    }

    /**
     * @param arrHd the arrHd to set
     */
    public void setArrHd(ArrayList<HardDrive> arrHd) {
        this.arrHd = arrHd;
    }
    
    public String gerArrHdString() {
        String res = "";
        for (HardDrive arrHd1 : arrHd) {
            res = res + arrHd1.getName() + " " + arrHd1.getsystemtype() + " " 
                        + "Свободно: " + arrHd1.getFree() + "G " //Свободное место на диске 
                        + "Всего: " + arrHd1.getTotal() + "G\n"; //Размер диска
        }
        return res;
    }

    /**
     * @return the mb
     */
    public MotherBoard getMb() {
        return mb;
    }

    /**
     * @param mb the mb to set
     */
    public void setMb(MotherBoard mb) {
        this.mb = mb;
    }

    /**
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
