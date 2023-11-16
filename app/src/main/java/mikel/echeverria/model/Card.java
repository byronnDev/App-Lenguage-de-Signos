package mikel.echeverria.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import mikel.echeverria.app.MyApplication;

public class Card extends RealmObject {
    @PrimaryKey
    private int id;
    private int imageResource;
    private String name;
    private RealmList<String> frases;

    public Card() {} // Necesario para el Realm

    public Card(int imageResource, String name, RealmList<String> frases) {
        // Asignamos el idCard autoincremental
        this.id = MyApplication.cardID.incrementAndGet();
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

    public void setFrases(RealmList<String> frases) {
        this.frases = frases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
