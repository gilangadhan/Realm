package com.pendekarcoding.realm;

/**
 * Created by Gilang Ramadhan on 24/12/2016.
 */

public class ModelSiswa {
    
    //variable
    int id;
    String nama, alamat;
    
    //konstruktor
    public ModelSiswa(int ids, String namas, String alamats){
        this.id = ids;
        this.nama = namas;
        this.alamat = alamats;
    }

    //setter getter
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
