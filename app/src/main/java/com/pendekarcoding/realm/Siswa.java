package com.pendekarcoding.realm;

import io.realm.RealmObject;

/**
 * Created by Gilang Ramadhan on 24/12/2016.
 */

public class Siswa extends RealmObject {
    private int id;
    private String nama, alamat;

    //modeling siswa
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
