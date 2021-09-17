package com.codeclan.example.capstoneapi.models.data;

import javax.persistence.*;

@Entity
@Table(name="appdata")
public class AppData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="levelOneXp")
    private double levelOneXp;

    @Column(name="xpMultiplier")
    private double xpMultiplier;

    @Column(name="xpReward")
    private double xpReward;

    @Column(name="startingHealth")
    private double startingHealth;

    @Column(name="healthMultiplier")
    private double healthMultiplier;

    public AppData( double levelOneXp, double xpMultiplier, double xpReward, double startingHealth, double healthMultiplier) {
        this.levelOneXp = levelOneXp;
        this.xpMultiplier = xpMultiplier;
        this.xpReward = xpReward;
        this.startingHealth = startingHealth;
        this.healthMultiplier = healthMultiplier;
    }

    public AppData(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public double calculateNextLevelXP(double currentLevel){
        return currentLevel * this.xpMultiplier;
    }

}
