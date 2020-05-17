package com.android.Database;

public class Player {
    private String name;
    private int pairsOf2Wins;
    private int pairsOf3Wins;
    private int battleWins;

    public Player(String name){
        this.name = name;
        pairsOf2Wins = 0;
        pairsOf3Wins = 0;
        battleWins = 0;
    }

    public Player(String name, int pairsOf2Wins, int pairsOf3Wins, int battleWins){
        this.name = name;
        this.pairsOf2Wins = pairsOf2Wins;
        this.pairsOf3Wins = pairsOf3Wins;
        this.battleWins = battleWins;
    }

    public int getBattleWins() {
        return battleWins;
    }

    public int getPairsOf2Wins() {
        return pairsOf2Wins;
    }

    public int getPairsOf3Wins() {
        return pairsOf3Wins;
    }

    public String getName() {
        return name;
    }

    public void setBattleWins(int battleWins) {
        this.battleWins = battleWins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPairsOf2Wins(int pairsOf2Wins) {
        this.pairsOf2Wins = pairsOf2Wins;
    }

    public void setPairsOf3Wins(int pairsOf3Wins) {
        this.pairsOf3Wins = pairsOf3Wins;
    }

    public void winsPairsOf2() {pairsOf2Wins++;}

    public void winsPairsOf3() {pairsOf3Wins++;}

    public void winsBattle(){battleWins++;}
}
