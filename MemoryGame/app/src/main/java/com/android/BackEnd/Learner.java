package com.android.BackEnd;

public class Learner {
    private String name;
    private boolean isAI;
    private Sector sector;
    private Mode_Sector mode_sector;
    private Player_Sector player_sector;

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

    public Mode_Sector getMode_sector() {
        return mode_sector;
    }

    public void setMode_sector(Mode_Sector mode_sector) {
        this.mode_sector = mode_sector;
    }

    public Player_Sector getPlayer_sector() {
        return player_sector;
    }

    public void setPlayer_sector(Player_Sector player_sector) {
        this.player_sector = player_sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
