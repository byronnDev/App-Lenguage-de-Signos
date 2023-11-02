package mikel.echeverria.model;

import android.graphics.Color;

public class Card {
    private int imageResource;
    private String name;

    public Card() {
        // Necesario para el Realm
    }

    public Card(int imageResource, String name) {
        this.imageResource = imageResource;
        this.name = name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

}
