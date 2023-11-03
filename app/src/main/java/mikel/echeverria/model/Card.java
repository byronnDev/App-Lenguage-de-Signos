package mikel.echeverria.model;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import mikel.echeverria.app.MyApplication;

public class Card extends RealmObject {
    @PrimaryKey
    private int idCard;
    private int imageResource;
    private String name;
    private List<String> frases;

    public Card() {
        // Necesario para el Realm
    }

    public Card(int imageResource, String name, List<String> frases) {
        this.idCard = MyApplication.cardID.getAndIncrement();
        this.imageResource = imageResource;
        this.name = name;
        this.frases = frases;

    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }
    public List<String> getFrases() {
        return frases;
    }

    public void setFrases(List<String> frases) {
        this.frases = frases;
    }

}
