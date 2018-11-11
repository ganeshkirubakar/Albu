package com.albums.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.albums.appInterface.ApiInterface;
import com.albums.constants.AppConstants;
import com.albums.contract.AlbumListContract;
import com.albums.model.Album;
import com.albums.model.AlbumList;
import com.albums.model.AlbumPhotoList;
import com.albums.model.AlbumPhotos;
import com.albums.network.RestAdapter;
import com.albums.utils.RealmDatabase;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumListService implements AlbumListContract.Model {

    private String TAG = AlbumListService.class.getName();
    private ApiInterface albumListApi = init();

    @Override
    public void getAlbumList(final Context context, final OnFinishedListener onFinishedListener) {

        Call<ArrayList<Album>> call = albumListApi.getAlbumList();
        call.enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Album>> call, @NonNull Response<ArrayList<Album>> response) {
                if (response.body() != null) {
                    //AppDatabase.getInstance(this).addAlbum(albumArrayList);
                    AlbumList albumList = new AlbumList();
                    albumList.setRealmList(response.body());
                    RealmDatabase.getRealmDatabase(context).addAlbumList(albumList);
                    onFinishedListener.onSuccess(response.body());
                } else {
                    onFinishedListener.onError(AppConstants.APP_GENERIC_ERROR);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Album>> call, @NonNull Throwable t) {
                onFinishedListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getAlbumDetail(final Context context, final OnFinishedListener onFinishedListener, int id) {
        Call<ArrayList<AlbumPhotos>> call = albumListApi.getAlbumDetailsWithPhoto(id);
        call.enqueue(new Callback<ArrayList<AlbumPhotos>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<AlbumPhotos>> call, @NonNull Response<ArrayList<AlbumPhotos>> response) {
                if (response.body() != null) {
                    //AppDatabase.getInstance(this).addAlbum(albumArrayList);
                    AlbumPhotoList albumPhotoList = new AlbumPhotoList();
                    albumPhotoList.setRealmList(response.body());
                    RealmDatabase.getRealmDatabase(context).addAlbumDetail(albumPhotoList);
                    onFinishedListener.onSuccess(response.body());
                } else {
                    onFinishedListener.onError(AppConstants.APP_GENERIC_ERROR);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<AlbumPhotos>> call, @NonNull Throwable t) {
                onFinishedListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getAlbumDetailsWitID(final Context context, final OnFinishedListener onFinishedListener, int id) {
        Call<ArrayList<AlbumPhotos>> call = albumListApi.getAlbumDetailsWitID(id);
        call.enqueue(new Callback<ArrayList<AlbumPhotos>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<AlbumPhotos>> call, @NonNull Response<ArrayList<AlbumPhotos>> response) {
                if (response.body() != null) {
                    //AppDatabase.getInstance(this).addAlbum(albumArrayList);
                    AlbumPhotoList albumPhotoList = new AlbumPhotoList();
                    albumPhotoList.setRealmList(response.body());
                    RealmDatabase.getRealmDatabase(context).addAlbumDetail(albumPhotoList);
                    onFinishedListener.onSuccess(response.body());
                } else {
                    onFinishedListener.onError(AppConstants.APP_GENERIC_ERROR);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<AlbumPhotos>> call, @NonNull Throwable t) {
                onFinishedListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void deleteAlbum(Context context, final OnFinishedListener onFinishedListener, int id) {
        Call<ResponseBody> call = albumListApi.deleteAlbumPhotos(id);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                onFinishedListener.onDeleteSuccess();
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                onFinishedListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getAlbumListFromDatabase(Context context, OnFinishedListener onFinishedListener) {
        //setAlbumListAdapter(AppDatabase.getInstance(this).getAlbumList());
       ArrayList<Album> albums =  RealmDatabase.getRealmDatabase(context).getAlbumList();
       if(albums != null && albums.size() > 0){
           onFinishedListener.onSuccess(albums);
       }else{
           onFinishedListener.onError(AppConstants.APP_GENERIC_ERROR);
       }
    }

    @Override
    public void getAlbumListFromDatabaseWithAlbumId(Context context, OnFinishedListener onFinishedListener, int id) {
        //setAlbumListAdapter(AppDatabase.getInstance(this).getAlbumList());
        ArrayList<AlbumPhotos> albums =  RealmDatabase.getRealmDatabase(context).getAlbumListWithId(id);
        if(albums != null && albums.size() > 0){
            onFinishedListener.onSuccess(albums);
        }else{
            onFinishedListener.onError(AppConstants.APP_GENERIC_ERROR);
        }
    }

    /**
     * Initialize AlbumList Api interface
     *
     * @return AlbumList Api Interface
     */
    private ApiInterface init() {
        return RestAdapter.getClient().create(ApiInterface.class);
    }
}
