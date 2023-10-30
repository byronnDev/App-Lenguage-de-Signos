package mikel.echeverria.model;

public class Card {
    private int imageResource;
    private String name;
    private String description;
    private int color;
    private int colorClaro;

    public Card() {
        // Necesario para el Realm
    }

    public Card(int imageResource, String name, String description, int color, int colorClaro) {
        this.imageResource = imageResource;
        this.name = name;
        this.description = description;
        this.color = color;
        this.colorClaro = colorClaro;
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
