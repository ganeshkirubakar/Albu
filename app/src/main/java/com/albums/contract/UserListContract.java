package com.albums.contract;

import android.content.Context;

import com.albums.model.Users;

import java.util.ArrayList;

public interface UserListContract {

    interface Model{
        interface onFinishedListener {
            void onSuccess(ArrayList<Users> usersArrayList);
            void onError(String message);
        }

        void getUserDetails(Context context, onFinishedListener onFinishedListener);
        void getUserDetailsFromDB(Context context, onFinishedListener onFinishedListener);
    }

    interface View{

        void showProgress();
        void hideProgress();
        void showEmptyView(int visiblity);
        void showUserDetail(ArrayList<Users> usersArrayList);
        void onResponseFailure(String message);
    }

    interface Presenter{
        void onDestoryView();
        void requestDataFromServer(Context context);
        void requestDataFromDB(Context context);
    }

}
