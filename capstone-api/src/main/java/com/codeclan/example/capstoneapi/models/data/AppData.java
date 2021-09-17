package com.codeclan.example.capstoneapi.models.data;

public class AppData {
    
    private double levelOneXp;
    
    private double xpMultiplier;
    
    private double xpReward;

    private double startingHealth;

    private double healthMultiplier;

    public AppData( double levelOneXp, double xpMultiplier, double xpReward, double startingHealth, double healthMultiplier) {
        this.levelOneXp = levelOneXp;
        this.xpMultiplier = xpMultiplier;
        this.xpReward = xpReward;
        this.startingHealth = startingHealth;
        this.healthMultiplier = healthMultiplier;
    }

    public AppData(){}
    
    public double getLevelOneXp() {
        return levelOneXp;
    }

    public void setLevelOneXp(double levelOneXp) {
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

    public double getStartingHealth() {
        return startingHealth;
    }

    public void setStartingHealth(double startingHealth) {
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
