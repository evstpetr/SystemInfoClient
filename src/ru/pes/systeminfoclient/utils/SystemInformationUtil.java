package ru.pes.systeminfoclient.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import ru.pes.systeminfoclient.interfaces.SystemInformationInterface;
import ru.pes.systeminfoclient.objects.Cpu;
import ru.pes.systeminfoclient.objects.Inventory;
import ru.pes.systeminfoclient.objects.LocationAndDepartment;
import ru.pes.systeminfoclient.objects.MotherBoard;
import ru.pes.systeminfoclient.objects.Net;
import ru.pes.systeminfoclient.objects.OS;
import ru.pes.systeminfoclient.objects.Ram;
import ru.pes.systeminfoclient.objects.SystemInformation;


public class SystemInformationUtil implements SystemInformationInterface {

    private final String LOCATION;
    private final String DEPARTMENT;
    private final String INV_NUMBER;
    
    private final SystemInformation SI = new SystemInformation();

    public SystemInformationUtil(String loc, String dep, String invNumber) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException {
        this.LOCATION = loc;
        this.DEPARTMENT = dep;
        this.INV_NUMBER = invNumber;

        SI.setLad(new LocationAndDepartment(LOCATION, DEPARTMENT));
        SI.setInventory(new Inventory(INV_NUMBER));
        SI.setOS(new OS(OSUtil.getName(), OSUtil.getArch()));
        SI.setMb(new MotherBoard(MotherBoardUtil.getVendor(), MotherBoardUtil.getName()));
        SI.setCpu(new Cpu(CPUUtil.getVendor(), CPUUtil.getName(), CPUUtil.getCores(), CPUUtil.getMhz()));
        SI.setRam(new Ram(RamUtil.getTotal()));
        SI.setNet(new Net(NetUtil.getIpAddress(), NetUtil.getMACAddress(), NetUtil.getPcName()));
        SI.setArrHd(HDDUtil.getHDDs());
    }

    public SystemInformationUtil(SystemInformation si) {
        this.LOCATION = si.getLad().getLocation();
        this.DEPARTMENT = si.getLad().getDepartment();
        this.INV_NUMBER = si.getInventory().getNumber();

        SI.setLad(new LocationAndDepartment(LOCATION, DEPARTMENT));
        SI.setInventory(new Inventory(INV_NUMBER));
        SI.setOS(new OS(si.getOS().getName(), si.getOS().getArch()));
        SI.setMb(new MotherBoard(si.getMb().getVendor(), si.getMb().getName()));
        SI.setCpu(new Cpu(si.getCpu().getVendor(), si.getCpu().getModel(), si.getCpu().getCores(), si.getCpu().getMhz()));
        SI.setRam(new Ram(si.getRam().getTotal()));
        SI.setNet(new Net(si.getNet().getIpAddr(), si.getNet().getMacAddr(), si.getNet().getPcName()));
        SI.setArrHd(si.getArrHd());
    }
    
    @Override
    public String getLOCATION() {
        return SI.getLad().getLocation();
    }

    @Override
    public String getDEPARTMENT() {
        return SI.getLad().getDepartment();
    }

    @Override
    public String getOsName() {
        return SI.getOS().getName();
    }

    @Override
    public String getArch() {
        return SI.getOS().getArch();
    }

    @Override
    public String getCpuVendor() {
        return SI.getCpu().getVendor();
    }

    @Override
    public String getCpuModel() {
        return SI.getCpu().getModel();
    }

    @Override
    public String getCpuCores() {
        return SI.getCpu().getCores();
    }

    @Override
    public String getCpuMhz() {
        return SI.getCpu().getMhz();
    }

    @Override
    public String getRam() {
        return String.valueOf(SI.getRam().getTotal());
    }

    @Override
    public String getIpAddr() {
        return SI.getNet().getIpAddr();
    }

    @Override
    public String getMacAddr() {
        return SI.getNet().getMacAddr();
    }

    @Override
    public String getPcName() {
        return SI.getNet().getPcName();
    }

    @Override
    public ArrayList<String> getHDDs() {
        ArrayList<String> arrstr = new ArrayList<>();
        SI.getArrHd().stream().forEach((hdd) -> {
            arrstr.add(hdd.getName() + " " + hdd.getsystemtype()
                    + " Свободно: " + hdd.getFree() + "GB Всего: " + hdd.getTotal() + "GB");
        });
        return arrstr;
    }

    @Override
    public SystemInformation getSI() {
        return SI;
    }

    @Override
    public String getMotherBoardVendor() {
        return SI.getMb().getVendor();
    }

    @Override
    public String getMotherBoardName() {
        return SI.getMb().getName();
    }

    @Override
    public String getInventoryNumber() {
        return SI.getInventory().getNumber();
    }
    
    public void saveToFile() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pc.dat"));
        out.writeObject(getSI());
        out.close();
    }
    
    public static SystemInformation getSystemInformationFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("pc.dat"));
        SystemInformation sys = (SystemInformation) in.readObject();
        return sys;
    }
}
