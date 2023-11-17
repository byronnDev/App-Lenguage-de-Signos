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
    private String categoria;

    public Card() {} // Necesario para el Realm

    public Card(int imageResource, String name, String c) {
        // Asignamos el idCard autoincremental
        this.id = MyApplication.cardID.incrementAndGet();
        this.imageResource = imageResource;
        this.name = name;
        this.categoria = c;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
