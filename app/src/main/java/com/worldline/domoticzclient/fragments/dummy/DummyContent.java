package com.worldline.domoticzclient.fragments.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
//        ITEM_MAP.put(item.id, item);
        ITEM_MAP.put(item.deviceName, item);
    }

    private static DummyItem createDummyItem(int position) {
//        return new DummyItem("Device "+ position, "20°", "20,1° / 46%", String.valueOf(position), "Item " + position, makeDetails(position));
        return new DummyItem("Device "+ position, "20°", "20,1° / 46%");
    }

/*
    private static String makeDeviceName(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Device ").append(position);
    }
*/

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String deviceName;
        public final String temp_set;
        public final String temp_hum;
/*
        public final String id;
        public final String content;
        public final String details;
*/

//        public DummyItem(String deviceName, String temp_set, String temp_hum, String id, String content, String details) {
        public DummyItem(String deviceName, String temp_set, String temp_hum) {
            this.deviceName = deviceName;
            this.temp_set = temp_set;
            this.temp_hum = temp_hum;
/*
            this.id = id;
            this.content = content;
            this.details = details;
*/
        }

        @Override
        public String toString() {
//            return content;
            return temp_hum;
        }
    }
}