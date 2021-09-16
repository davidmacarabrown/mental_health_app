package com.codeclan.example.capstoneapi.models.data;

import javax.persistence.*;

@Entity
@Table(name="appdata")
public class AppData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="startingXp")
    private int startingXp;

    @Column(name="xpMultiplier")
    private double xpMultiplier;

    @Column(name="xpReward")
    private int xpReward;

    public AppData( int startingXp, double xpMultiplier, int xpReward) {
        this.startingXp = startingXp;
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

    public int getXpReward() {
        return xpReward;
    }

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }
}
