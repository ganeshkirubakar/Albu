package com.albums.model;

import java.util.ArrayList;

import io.realm.RealmList;

public class AlbumList extends RealmList {
    private ArrayList<Album> realmList;

    public ArrayList<Album> getRealmList() {
        return realmList;
    }

    public void setRealmList(ArrayList<Album> realmList) {
        this.realmList = realmList;
    }
}
