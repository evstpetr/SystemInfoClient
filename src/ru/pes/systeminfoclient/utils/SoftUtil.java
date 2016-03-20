package ru.pes.systeminfoclient.utils;

import java.io.File;
import java.util.ArrayList;

public class SoftUtil {   
    
    public static ArrayList<String> getSoft(String str) {
        String dirname = "C:\\Program Files" + str; // имя каталога 
        ArrayList<String> softNames = new ArrayList<>();
        File file = new File(dirname);
        String subdirs[] = file.list();
        
        for (String item : subdirs) {
            File subfile = new File(dirname + "\\" + item);
            if (subfile.isDirectory()) {
                String subs[] = subfile.list();
                if (subs.length > 0) {
                    File subf = new File(subfile.getAbsolutePath() + "\\" + subs[0]);
                    if (subf.isDirectory()) {
                        softNames.add(subfile.getName() + ", " + subf.getName());
                    }
                }
            }
        }        
        return softNames;
    }
    
    
}
