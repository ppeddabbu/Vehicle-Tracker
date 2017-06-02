package io.egen.prashanth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by imstellar on 5/31/2017.
 */

@Entity
public class TireDimension {

    @Id
    private String readingID;

    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    public String getReadingID() {
        return readingID;
    }

    public void setReadingID(String readingID) {
        this.readingID = readingID;
    }
}
