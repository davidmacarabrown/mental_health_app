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

    public AppData( double levelOneXp, double xpMultiplier, double xpReward) {
        this.levelOneXp = levelOneXp;
        this.xpMultiplier = xpMultiplier;
        this.xpReward = xpReward;
    }

    public AppData(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }

    public double getLevelOneXp() {
        return levelOneXp;
    }

    public void setLevelOneXp(int levelOneXp) {
        this.levelOneXp = levelOneXp;
    }

    public double calculateNextLevelXP(double currentLevel){
        return currentLevel * this.xpMultiplier;
    }

}
