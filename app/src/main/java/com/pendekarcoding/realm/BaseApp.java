package com.pendekarcoding.realm;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by Gilang Ramadhan on 24/12/2016.
 */

public class BaseApp extends Application {
    // untuk membuat database
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration configuration =
                new RealmConfiguration.Builder(this)
                .schemaVersion(0)
                .migration(new DataMigration())
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
    private class DataMigration implements
            RealmMigration{

        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
            RealmSchema schema = realm.getSchema();
            if(oldVersion == 0){
                schema.create("siswa")
                        .addField("id", int.class)
                        .addField("nama", String.class)
                        .addField("alamat", String.class);
                oldVersion++;

            }
        }
    }
}
