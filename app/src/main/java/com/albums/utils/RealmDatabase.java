package com.albums.utils;

import android.content.Context;

import com.albums.constants.AppConstants;
import com.albums.model.Album;
import com.albums.model.AlbumList;
import com.albums.model.AlbumPhotoList;
import com.albums.model.AlbumPhotos;
import com.albums.model.UserList;
import com.albums.model.Users;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class RealmDatabase {

    private static final String TAG = RealmDatabase.class.getName();

    private static RealmDatabase realmDatabase;
    private static RealmConfiguration realmConfiguration;

    /**
     * Initialization of the Realm Object
     * @param context Activity Context
     */
    private RealmDatabase(Context context){
        Realm.init(context);
        realmConfiguration = new RealmConfiguration.Builder().name(AppConstants.DATABASE_NAME)
                            .schemaVersion(0).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static RealmDatabase getRealmDatabase(Context context){
        if(realmDatabase == null){
            realmDatabase = new RealmDatabase(context);
            return realmDatabase;
        }
        return realmDatabase;
    }

    /**
     * Add or Update Album Data
     * @param album update the AlbumList table
     */
    public void addAlbumList(AlbumList album) {
        Realm.getInstance(realmConfiguration).beginTransaction();
        Realm.getInstance(realmConfiguration).copyToRealmOrUpdate(album.getRealmList());
        Realm.getInstance(realmConfiguration).commitTransaction();
    }

    /**
     * Add or Update Album Data
     * @param album update the AlbumDetailView table
     */
    public void addAlbumDetail(AlbumPhotoList album) {
        Realm.getInstance(realmConfiguration).beginTransaction();
        Realm.getInstance(realmConfiguration).copyToRealmOrUpdate(album.getRealmList());
        Realm.getInstance(realmConfiguration).commitTransaction();
    }

    /**
     * Add or Update Users Data
     * @param userList update the UserList table
     */
    public void addUserList(UserList userList) {
        Realm.getInstance(realmConfiguration).beginTransaction();
        Realm.getInstance(realmConfiguration).copyToRealmOrUpdate(userList.getRealmList());
        Realm.getInstance(realmConfiguration).commitTransaction();
    }

    /**
     * Get Available Album List in DB
     */
    public ArrayList<Album> getAlbumList(){
        ArrayList<Album> albumList = new ArrayList<>();
        Realm realm = Realm.getInstance(realmConfiguration);
        RealmResults<Album> realmResults = realm.where(Album.class).findAll();
        albumList.addAll(realmResults.subList(0, realmResults.size()));
        return albumList;
    }

    /**
     * Get Available Album List in DB
     */
    public ArrayList<AlbumPhotos> getAlbumListWithId(int id){
        ArrayList<AlbumPhotos> albumList = new ArrayList<>();
        Realm realm = Realm.getInstance(realmConfiguration);
        RealmResults<AlbumPhotos> realmResults = realm.where(AlbumPhotos.class).equalTo("albumId",id).findAll();
        albumList.addAll(realmResults.subList(0, realmResults.size()));
        return albumList;
    }

    /**
     * Get Available Users List in DB
     */
    public ArrayList<Users> getUserList(){
        ArrayList<Users> usersArrayList = new ArrayList<>();
        Realm realm = Realm.getInstance(realmConfiguration);
        RealmResults<Users> realmResults = realm.where(Users.class).findAll();
        usersArrayList.addAll(realmResults.subList(0, realmResults.size()));
        return usersArrayList;
    }

}
