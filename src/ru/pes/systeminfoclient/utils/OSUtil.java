package ru.pes.systeminfoclient.utils;

import java.lang.reflect.InvocationTargetException;


public class OSUtil {

   
    public static String getName() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        String name = WinRegistry.readString(
                WinRegistry.HKEY_LOCAL_MACHINE, //HKEY
                "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion", //Key
                "ProductName");            //ValueName
        return name;
    }
    
    public static String getArch() throws IllegalAccessException, InvocationTargetException{
        String arch = WinRegistry.readString(
                WinRegistry.HKEY_LOCAL_MACHINE, //HKEY
                "SOFTWARE\\Microsoft\\Windows\\CurrentVersion", //Key
                "ProgramFilesDir (x86)");            //ValueName
        if (arch != null) {
            arch = "x64";
        } else {
            arch = "x86";
        }
        return arch;
    }
    
}
