package com.acquisio.basic.java.question05;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        --sellIn;
        if (quality < 50) {
            ++quality;
        }
        //Quality increases by 2
        if (sellIn < 0) {
            if (quality < 50) {
                ++quality;
            }
        }
    }
}
