package com.acquisio.basic.java.question05;

/**
 * QUESTION 6: Refactoring
 * ======================================
 * Requirements Specification (en)
 * ======================================
 * <p>
 * Hi and welcome to the team. As you know, we are a small inn with a prime location in a
 * prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
 * Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
 * have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
 * Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
 * we can begin selling a new category of items. First an introduction to our system:
 * <p>
 * - All items have a SellIn value which denotes the number of days we have to sell the item
 * - All items have a Quality value which denotes how valuable the item is
 * - At the end of each day our system lowers both values for every item
 * <p>
 * Pretty simple, right? Well this is where it gets interesting:
 * <p>
 * - Once the sell by date has passed, Quality degrades twice as fast
 * - The Quality of an item is never negative
 * - "Aged Brie" actually increases in Quality the older it gets
 * - The Quality of an item is never more than 50
 * - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
 * - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
 * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
 * Quality drops to 0 after the concert
 * <p>
 * We have recently signed a supplier of conjured items. This requires an update to our system:
 * <p>
 * - "Conjured" items degrade in Quality twice as fast as normal items
 * <p>
 * Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
 * still works correctly. However, do not alter the Item class or Items property as those belong to the
 * goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
 * ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
 * for you).
 * <p>
 * Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
 * legendary item and as such its Quality is 80 and it never alters.
 * <p>
 * IMPORTANT: Add all missing javadoc that you think is necessary.
 */
 public class Refactoring {
    Item[] items;

    public Refactoring(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
    public void updateQualityNew() {
        for (Item tmp: items) {
            tmp.updateQuality();
        }
    }
    public static void main(String[] args) {
        /*FOR TESTING ONLY*/
        Item agedBrieOld = new Item("Aged Brie", 10, 40);
        Item itemOld = new Item("item 1", 10, 40);
        Item[] itemsOld = {agedBrieOld, itemOld};
        Refactoring refactoringOld = new Refactoring(itemsOld);
        System.out.println(agedBrieOld);
        System.out.println(itemOld);
        refactoringOld.updateQuality();
        System.out.println(agedBrieOld);
        System.out.println(itemOld);
        System.out.println("====================================================");
        Item agedBrieNew = new AgedBrie("Aged Brie", 10, 40);
        Item itemNew = new Item("item 1", 10, 40);
        Item[] itemsNew = {agedBrieNew, itemNew};
        Refactoring refactoringNew = new Refactoring(itemsNew);
        System.out.println(agedBrieNew);
        System.out.println(itemNew);
        refactoringNew.updateQualityNew();
        System.out.println(agedBrieNew);
        System.out.println(itemNew);

        System.out.println("====================================================");
        System.out.println("====================================================");

        Item SurfurasOld = new Item("Surfuras", 10, 40);
        Item itemSurfurasOld = new Item("item 1", 10, 40);
        Item[] itemsSurfurasOld = {SurfurasOld, itemSurfurasOld};
        Refactoring refactoringSurOld = new Refactoring(itemsSurfurasOld);
        System.out.println(SurfurasOld);
        System.out.println(itemSurfurasOld);
        refactoringSurOld.updateQuality();
        System.out.println(SurfurasOld);
        System.out.println(itemSurfurasOld);
        System.out.println("====================================================");
        Item SurfurasNew = new Sulfuras("Surfuras", 10, 40);
        Item itemSurNew = new Item("item 1", 10, 40);
        Item[] itemSSurNew = {SurfurasNew, itemSurNew};
        Refactoring refactoringSurfurasNew = new Refactoring(itemSSurNew);
        System.out.println(SurfurasNew);
        System.out.println(itemSurNew);
        refactoringSurfurasNew.updateQualityNew();
        System.out.println(SurfurasNew);
        System.out.println(itemSurNew);

        System.out.println("====================================================");
        System.out.println("====================================================");

        Item BackstageOld = new Item("Backstage", 12, 55);
        Item itemBackstageOld = new Item("item 1", 12, 55);
        Item[] itemSBackstageOld = {BackstageOld, itemBackstageOld};
        Refactoring refactoringBackstageOld = new Refactoring(itemSBackstageOld);
        System.out.println(BackstageOld);
        System.out.println(itemBackstageOld);
        refactoringBackstageOld.updateQuality();
        System.out.println(BackstageOld);
        System.out.println(itemBackstageOld);
        System.out.println("====================================================");
        Item BackstageNew = new Sulfuras("Backstage", 12, 55);
        Item itemBackstageNew = new Item("item 1", 12, 55);
        Item[] itemSBackstageNew = {BackstageNew, itemBackstageNew};
        Refactoring refactoringBackstageNew = new Refactoring(itemSBackstageNew);
        System.out.println(BackstageNew);
        System.out.println(itemBackstageNew);
        refactoringBackstageNew.updateQualityNew();
        System.out.println(BackstageNew);
        System.out.println(itemBackstageNew);

        System.out.println("====================================================");
        System.out.println("====================================================");

        Item ConjuredOld = new Item("Conjured", 12, 55);
        Item itemConjuredOld = new Item("item 1", 12, 55);
        Item[] itemSConjuredOld = {ConjuredOld, itemConjuredOld};
        Refactoring refactoringConjuredOld = new Refactoring(itemSConjuredOld);
        System.out.println(ConjuredOld);
        System.out.println(itemConjuredOld);
        refactoringConjuredOld.updateQuality();
        System.out.println(ConjuredOld);
        System.out.println(itemConjuredOld);
        System.out.println("====================================================");
        Item ConjuredNew = new Sulfuras("Conjured", 12, 55);
        Item itemConjuredNew = new Item("item 1", 12, 55);
        Item[] itemSConjuredNew = {ConjuredNew, itemConjuredNew};
        Refactoring refactoringConjuredNew = new Refactoring(itemSConjuredNew);
        System.out.println(ConjuredNew);
        System.out.println(itemConjuredNew);
        refactoringConjuredNew.updateQualityNew();
        System.out.println(ConjuredNew);
        System.out.println(itemConjuredNew);
    }
}