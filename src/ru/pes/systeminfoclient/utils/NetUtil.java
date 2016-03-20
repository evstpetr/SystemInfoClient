package ru.pes.systeminfoclient.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.xml.bind.DatatypeConverter;


public class NetUtil {

    
    public static String getPcName() throws SocketException, UnknownHostException {
        InetAddress localMachine = InetAddress.getLocalHost();
        return localMachine.getHostName();       
    }
    
    public static String getIpAddress() throws UnknownHostException {
        InetAddress localMachine = InetAddress.getLocalHost();
        return localMachine.getHostAddress();
    }
    
    public static String getMACAddress() throws SocketException, UnknownHostException {
       InetAddress localMachine = InetAddress.getLocalHost();
        NetworkInterface ni = NetworkInterface.getByInetAddress(localMachine);
        StringBuilder strb = new StringBuilder(DatatypeConverter.printHexBinary(ni.getHardwareAddress()));
        int n = strb.length();
        for (int i = 2; i < n; i=i+2) {
            strb.insert(i, ":");
            i++;
            n++;
            
        }
        return strb.toString();
    }
    
}
