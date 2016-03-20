package ru.pes.systeminfoclient.utils;

import java.lang.management.ManagementFactory;


public class RamUtil {
    
    public static String getTotal() {
        com.sun.management.OperatingSystemMXBean mxbean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return String.valueOf(mxbean.getTotalPhysicalMemorySize()/(1024*1024));
    }
    
}
