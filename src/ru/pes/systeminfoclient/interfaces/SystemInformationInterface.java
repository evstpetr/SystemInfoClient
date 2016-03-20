package ru.pes.systeminfoclient.interfaces;

import java.util.ArrayList;
import ru.pes.systeminfoclient.objects.SystemInformation;



public interface SystemInformationInterface {
    public String getLOCATION();
    public String getDEPARTMENT();
    public String getInventoryNumber();
    public String getMotherBoardVendor();
    public String getMotherBoardName();
    public String getOsName();
    public String getArch();    
    public String getCpuVendor();
    public String getCpuModel();
    public String getCpuCores();
    public String getCpuMhz();
    public String getRam();
    public String getIpAddr();
    public String getMacAddr();
    public String getPcName();
    public ArrayList<String> getHDDs();
    public SystemInformation getSI();
}
