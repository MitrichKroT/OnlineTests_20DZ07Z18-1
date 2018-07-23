package com.acquisio.basic.java.question05;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    public void updateQuality() {
        --sellIn;
        //Quality increases by 2
        if (sellIn < 0) {
            if (quality < 50) {
                ++quality;
            }
        }
    }
}