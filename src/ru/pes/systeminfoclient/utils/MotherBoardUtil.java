package ru.pes.systeminfoclient.utils;

import java.lang.reflect.InvocationTargetException;


public class MotherBoardUtil {
    public static String getVendor() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        String vendor = WinRegistry.readString(WinRegistry.HKEY_LOCAL_MACHINE,
                                                "HARDWARE\\DESCRIPTION\\System\\BIOS",
                                                "BaseBoardManufacturer");
        return vendor;
    }
    
    public static String getName() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        String name = WinRegistry.readString(WinRegistry.HKEY_LOCAL_MACHINE,
                                                "HARDWARE\\DESCRIPTION\\System\\BIOS",
                                                "BaseBoardproduct");
        
        return name;
    }
}
