package ru.pes.systeminfoclient.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.pes.systeminfoclient.interfaces.SoftInformationInterface;
import ru.pes.systeminfoclient.objects.SoftInformation;

public class SoftInformationUtil implements SoftInformationInterface {

    private final SoftInformation SOFT = new SoftInformation();

    public SoftInformationUtil(String str) {
        SOFT.setSoft(SoftUtil.getSoft(""));
        if (str.equals("")) {
            SOFT.setSoft86(null);
        } else {
            SOFT.setSoft86(SoftUtil.getSoft(" (x86)"));
        }
    }

    @Override
    public SoftInformation getSoft() {
        return SOFT;
    }

    public void saveToFile() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("soft.dat"));
        out.writeObject(getSoft());
        out.close();
    }
    
    public static SoftInformation getSoftInformationFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("soft.dat"));
        SoftInformation soft = (SoftInformation) in.readObject();
        return soft;
    }

}
