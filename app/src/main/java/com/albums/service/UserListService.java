package com.albums.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.albums.appInterface.ApiInterface;
import com.albums.constants.AppConstants;
import com.albums.contract.UserListContract;
import com.albums.model.UserList;
import com.albums.model.Users;
import com.albums.network.RestAdapter;
import com.albums.utils.RealmDatabase;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListService implements UserListContract.Model {
    private String TAG = UserListService.class.getName();
    private ApiInterface userListApi = init();

    @Override
    public void getUserDetails(final Context context, final onFinishedListener onFinishedListener) {
        Call<ArrayList<Users>> call = userListApi.getUserList();
        call.enqueue(new Callback<ArrayList<Users>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Users>> call, @NonNull Response<ArrayList<Users>> response) {
                if (response.body() != null) {
                    UserList userList = new UserList();
                    userList.setRealmList(response.body());
                    RealmDatabase.getRealmDatabase(context).addUserList(userList);
                    onFinishedListener.onSuccess(response.body());
                } else {
                    onFinishedListener.onError(AppConstants.APP_GENERIC_ERROR);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Users>> call, @NonNull Throwable t) {
                onFinishedListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getUserDetailsFromDB(Context context, onFinishedListener onFinishedListener) {
        ArrayList<Users> users =  RealmDatabase.getRealmDatabase(context).getUserList();
        if(users != null && users.size() > 0){
            onFinishedListener.onSuccess(users);
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
