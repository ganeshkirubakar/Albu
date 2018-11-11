package com.albums.model;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AlbumPhotoList extends RealmList{
    private ArrayList<AlbumPhotos> realmList;

    public ArrayList<AlbumPhotos> getRealmList() {
        return realmList;
    }

    public void setRealmList(ArrayList<AlbumPhotos> realmList) {
        this.realmList = realmList;
    }
}
