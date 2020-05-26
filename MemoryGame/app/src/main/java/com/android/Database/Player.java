package com.android.Database;

//class that represents the player: The data that are being deposited into the detabase
public class Player {
    private String name;
    private int pairsOf2Wins;
    private int pairsOf3Wins;
    private int battleWins;

    //constructor of initializing a new player
    public Player(String name){
        this.name = name;
        pairsOf2Wins = 0;
        pairsOf3Wins = 0;
        battleWins = 0;
    }

    //constructor of initializing an existing from database player by giving him his updated wins
    public Player(String name, int pairsOf2Wins, int pairsOf3Wins, int battleWins){
        this.name = name;
        this.pairsOf2Wins = pairsOf2Wins;
        this.pairsOf3Wins = pairsOf3Wins;
        this.battleWins = battleWins;
    }

    //getters
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

    //setters
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

    //increments of wins
    public void winsPairsOf2() {pairsOf2Wins++;}

    public void winsPairsOf3() {pairsOf3Wins++;}

    public void winsBattle(){battleWins++;}
}
