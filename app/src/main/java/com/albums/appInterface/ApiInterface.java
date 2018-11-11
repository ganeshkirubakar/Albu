package com.albums.appInterface;

import com.albums.constants.ApiConstants;
import com.albums.model.Album;
import com.albums.model.AlbumPhotos;
import com.albums.model.Users;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET(ApiConstants.GET_ALBUMS)
    Call<ArrayList<Album>> getAlbumList();
    @GET(ApiConstants.GET_ALBUM_DETAIL_PHOTOS)
    Call<ArrayList<AlbumPhotos>> getAlbumDetailsWithPhoto(@Path("id") int id);
    @GET(ApiConstants.GET_ALBUM_DETAIL_WITH_ALBUMID)
    Call<ArrayList<AlbumPhotos>> getAlbumDetailsWitID(@Query("albumId") int id);
    @DELETE(ApiConstants.DELETE_ALBUM)
    Call<ResponseBody> deleteAlbumPhotos(@Path("id") int id);
    @GET(ApiConstants.GET_USERS)
    Call<ArrayList<Users>> getUserList();
}
