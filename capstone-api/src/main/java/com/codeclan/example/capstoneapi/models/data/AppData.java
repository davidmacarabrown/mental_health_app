package com.codeclan.example.capstoneapi.models.data;

import javax.persistence.*;

@Entity
@Table(name="data")
public class AppData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="xp-multiplier")
    private double xpIncrement;

    public AppData(double xpIncrement) {
        this.xpIncrement = xpIncrement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getXpIncrement() {
        return xpIncrement;
    }

    public void setXpIncrement(double xpIncrement) {
        this.xpIncrement = xpIncrement;
    }
}
