package mikel.echeverria.app;

import android.app.Application;
import java.util.concurrent.atomic.AtomicInteger;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import mikel.echeverria.model.Card;

public class MyApplication extends Application {

    public static AtomicInteger cardID = new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build());

        Realm realm = Realm.getDefaultInstance();
        cardID = getIdByTable(realm, Card.class);
        realm.close();
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();
        return new AtomicInteger(results.size() > 0 ? results.max("id").intValue() : 0);
    }
}