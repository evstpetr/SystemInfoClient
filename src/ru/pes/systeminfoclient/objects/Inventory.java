package ru.pes.systeminfoclient.objects;

import java.io.Serializable;

public class Inventory implements Serializable{

    private String number;

    public Inventory(String number) {
        this.number = number;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

}
