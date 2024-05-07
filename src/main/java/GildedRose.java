class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        if (item.name.equals("Aged Brie")) {
            updateAgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePasses(item);
        } else {
            updateNormalItem(item);
        }

        item.sellIn--;
    }

    private void updateNormalItem(Item item) {
        item.quality--;
        if (item.sellIn <= 0) {
            item.quality--;
        }
        item.quality = Math.max(0, item.quality);
    }

    private void updateAgedBrie(Item item) {
        item.quality++;
        if (item.sellIn <= 0) {
            item.quality++;
        }
        item.quality = Math.min(50, item.quality);
    }

    private void updateBackstagePasses(Item item) {
        item.quality++;
        if (item.sellIn < 11) {
            item.quality++;
        }
        if (item.sellIn < 6) {
            item.quality++;
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
        }
        item.quality = Math.min(50, item.quality);
    }
}