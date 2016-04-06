package com.lukassos.example.sugarormlistofitems.dummy;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample name for user interfaces created by
 * Android template wizards.
 * <p/>
 */
public class DummyContent {

    public DummyContent(){

    }


    /**
     * An array of sample (dummy) items.
     */
    private List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    private Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    public void refresh(){
        ITEMS = DummyItem.listAll(DummyItem.class ); // TODO : sort it
    }

    private void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore lastname information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of name.
     */
    public static class DummyItem   extends SugarRecord {

        public final String name;
        public final String lastname;

        public DummyItem( String content, String details) {

            this.name = content;
            this.lastname = details;
        }

        @Override
        public String toString() {
            return name+" "+lastname;
        }
    }

    public Map<String, DummyItem> getITEM_MAP() {
        refresh();
        return ITEM_MAP;
    }

    public void setITEM_MAP(Map<String, DummyItem> ITEM_MAP) {
        this.ITEM_MAP = ITEM_MAP;
    }

    public List<DummyItem> getITEMS() {
        refresh();
        return ITEMS;
    }

    public void setITEMS(List<DummyItem> ITEMS) {
        this.ITEMS = ITEMS;
    }

    public String getNewID(){
        Long id = -1l;
        for (DummyItem item :
                ITEMS) {
            Long current = item.getId();
            if(id < current){
                id = current;
            }
        }
        return String.valueOf(id+1);
    }
}
