package ru.pes.systeminfoclient.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CPUUtil {
    
    public static String getVendor() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        String vendor = WinRegistry.readString(
                WinRegistry.HKEY_LOCAL_MACHINE, //HKEY
                "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0", //Key
                "VendorIdentifier");            //ValueName
        return vendor;
    }
    
    public static String getName() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        String name = WinRegistry.readString(
                WinRegistry.HKEY_LOCAL_MACHINE, //HKEY
                "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0", //Key
                "ProcessorNameString");            //ValueName
        return name;
    }
    
    public static String getMhz() throws IOException {
        String mhz = WinRegistry.readDWord("HKEY_LOCAL_MACHINE\\HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0", "~MHz"); 
        return mhz;
    }
    
    public static String getCores() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        int n = WinRegistry.readStringSubKeys(WinRegistry.HKEY_LOCAL_MACHINE,
                "HARDWARE\\DESCRIPTION\\System\\CentralProcessor").size();
        return new String().valueOf(n);
    }
}
