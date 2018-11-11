package com.albums.model;

import java.util.ArrayList;

import io.realm.RealmList;

public class UserList extends RealmList {
    private ArrayList<Users> realmList;

    public ArrayList<Users> getRealmList() {
        return realmList;
    }

    public void setRealmList(ArrayList<Users> realmList) {
        this.realmList = realmList;
    }
}
