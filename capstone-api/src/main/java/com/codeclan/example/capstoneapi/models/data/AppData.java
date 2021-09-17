package com.codeclan.example.capstoneapi.models.data;

public class AppData {
    
    private int levelOneXp;
    
    private double xpMultiplier;
    
    private double xpReward;

    private int startingHealth;

    private double healthMultiplier;


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

    public void setLevelOneXp(int levelOneXp) {
        this.levelOneXp = levelOneXp;
    }

    public double getXpMultiplier() {
        return xpMultiplier;
    }

    public void setXpMultiplier(double xpMultiplier) {
        this.xpMultiplier = xpMultiplier;
    }

    public double getXpReward() {
        return xpReward;
    }

    public void setXpReward(double xpReward) {
        this.xpReward = xpReward;
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public void setStartingHealth(int startingHealth) {
        this.startingHealth = startingHealth;
    }

    public double getHealthMultiplier() {
        return healthMultiplier;
    }

    public void setHealthMultiplier(double healthMultiplier) {
        this.healthMultiplier = healthMultiplier;
    }

    public double calculateNextLevelXP(double currentXp){
        return currentXp * this.xpMultiplier;
    }
}
