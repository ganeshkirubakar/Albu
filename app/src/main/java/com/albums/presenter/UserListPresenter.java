package com.albums.presenter;

import android.content.Context;
import android.view.View;

import com.albums.contract.UserListContract;
import com.albums.model.Users;
import com.albums.service.UserListService;

import java.util.ArrayList;

public class UserListPresenter  implements  UserListContract.Presenter, UserListContract.Model.onFinishedListener{
    private UserListContract.View userListView;

    private UserListContract.Model userListModel;

    public UserListPresenter(UserListContract.View userListView) {
        this.userListView = userListView;
        userListModel = new UserListService();
    }

    @Override
    public void onDestoryView() {
        this.userListView = null;
    }

    @Override
    public void requestDataFromServer(Context context) {
        if (userListView != null) {
            userListView.showProgress();
        }
        userListModel.getUserDetails(context, this);
    }

    @Override
    public void requestDataFromDB(Context context) {
        if (userListView != null) {
            userListView.showProgress();
        }
        userListModel.getUserDetailsFromDB(context, this);
    }

    @Override
    public void onSuccess(ArrayList<Users> usersArrayList) {
        userListView.showUserDetail(usersArrayList);
        if (userListView != null) {
            userListView.hideProgress();
            userListView.showEmptyView(View.GONE);
        }
    }

    @Override
    public void onError(String message) {
        userListView.onResponseFailure(message);
        if (userListView != null) {
            userListView.hideProgress();
            userListView.showEmptyView(View.VISIBLE);
        }
    }
}
