package com.acquisio.basic.java.question05;

public class Sulfuras extends Item {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    public void updateQuality() {
        --sellIn;
        if (quality > 0) {
            --quality;
        }
    }
}