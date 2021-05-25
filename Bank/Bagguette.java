package net.matees.Bank;

public class Bagguette {
    int moisture;
    int beefyness;
    int length;
    String name;

    public Bagguette(int moisture, int beefyness, int length, String name) {
        this.moisture = moisture;
        this.beefyness = beefyness;
        this.length = length;
        this.name = name;
    }

    public void giveMeStats() {
        System.out.println("Your moisture level is " + Integer.toString(moisture) + ", your beefyness is " + Integer.toString(beefyness) + ", your length is " + Integer.toString(length) + ", and finally, your bagguette's name is " + name);
    }

    public int getMoisture() {
        return moisture;
    }

    public void setMoisture(int moisture) {
        this.moisture = moisture;
    }

    public int getBeefyness() {
        return beefyness;
    }

    public void setBeefyness(int beefyness) {
        this.beefyness = beefyness;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
