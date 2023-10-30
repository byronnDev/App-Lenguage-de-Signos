package mikel.echeverria.model;

import android.graphics.Color;

public class Card {
    private int imageResource;
    private String name;
    private String description;
    private int color;
    private int colorClaro;

    public Card() {
        // Necesario para el Realm
    }

    public Card(int imageResource, String name, int color, int colorClaro) {
        this.imageResource = imageResource;
        this.name = name;
        this.color = color;
        this.colorClaro = colorClaro;
    }

    public Card(int imageResource, String name) {
        this.imageResource = imageResource;
        this.name = name;
        // Default color
        this.color = 0;
        this.colorClaro = 0;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getColor() {
        return color;
    }

    public int getColorClaro() {
        return colorClaro;
    }
}
