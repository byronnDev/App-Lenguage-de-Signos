package mikel.echeverria.model;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Card extends RealmObject {
    @PrimaryKey
    private int idCard;
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
