package com.codeclan.example.capstoneapi.models.data;

public class AppData {
    
    private static int levelOneXp = 10;
    
    private static double xpMultiplier = 1.2;
    
    private static double xpReward = 1;

    private static int startingHealth = 100;

    private static double healthMultiplier = 1.1;


    public AppData( int levelOneXp, double xpMultiplier, double xpReward, int startingHealth, double healthMultiplier) {
        this.levelOneXp = levelOneXp;
        this.xpMultiplier = xpMultiplier;
        this.xpReward = xpReward;
        this.startingHealth = startingHealth;
        this.healthMultiplier = healthMultiplier;
    }

    public AppData(){}
    
    public int getLevelOneXp() {
        return levelOneXp;
    }

    public double getXpMultiplier() {
        return xpMultiplier;
    }

    public double getXpReward() {
        return xpReward;
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public double getHealthMultiplier() {
        return healthMultiplier;
    }

    public double calculateNextLevelXP(double currentXp){
        return currentXp * this.xpMultiplier;
    }
}
