package ru.pes.systeminfoclient.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class SoftInformation implements Serializable {
    
    private ArrayList<String> soft;
    private ArrayList<String> soft86;

    public SoftInformation() {
    }

    /**
     * @return the soft
     */
    public ArrayList<String> getSoft() {
        return soft;
    }

    /**
     * @param soft the soft to set
     */
    public void setSoft(ArrayList<String> soft) {
        this.soft = soft;
    }

    /**
     * @return the soft86
     */
    public ArrayList<String> getSoft86() {
        return soft86;
    }

    /**
     * @param soft86 the soft86 to set
     */
    public void setSoft86(ArrayList<String> soft86) {
        this.soft86 = soft86;
    }
    
}
