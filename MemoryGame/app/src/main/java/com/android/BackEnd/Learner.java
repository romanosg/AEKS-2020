package com.android.BackEnd;

public class Learner {
    private String name1;
    private String name2;
    private boolean isAI;
    private Sector sector;

    public boolean isAI() {
        return isAI;
    }

    public void setAI(boolean AI) {
        isAI = AI;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name) {
        this.name1 = name;
    }

    public String getName2(){return name2;}

    public void setName2(String name){this.name2=name;}

}
