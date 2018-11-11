package com.albums.presenter;

import android.content.Context;
import android.view.View;

import com.albums.constants.AppConstants;
import com.albums.contract.AlbumListContract;
import com.albums.service.AlbumListService;

import java.util.ArrayList;

public class AlbumListPresenter implements AlbumListContract.Presenter, AlbumListContract.Model.OnFinishedListener {

    private AlbumListContract.View albumListView;

    private AlbumListContract.Model albumListModel;

    public AlbumListPresenter(AlbumListContract.View albumListView) {
        this.albumListView = albumListView;
        albumListModel = new AlbumListService();
    }

    @Override
    public void onSuccess(ArrayList<?> response) {
        albumListView.setDataToRecyclerView(response);
        if (albumListView != null) {
            albumListView.hideProgress();
            albumListView.showEmptyView(View.GONE);
        }
    }

    @Override
    public void onDeleteSuccess() {
        if (albumListView != null) {
            albumListView.hideProgress();
            albumListView.showEmptyView(View.GONE);
        }
    }

    @Override
    public void onError(String message) {
        albumListView.onResponseFailure(message);
        if (albumListView != null) {
            albumListView.hideProgress();
            albumListView.showEmptyView(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        this.albumListView = null;
    }

    @Override
    public void requestDataFromServer(Context context, int type, int id) {
        if (albumListView != null) {
            albumListView.showProgress();
        }
        if(type == AppConstants.ALBUM_LIST) {
            albumListModel.getAlbumList(context, this);
        }else{
            if(type == AppConstants.ALBUM_SEARCH){
                albumListModel.getAlbumDetailsWitID(context, this, id);
            }else {
                albumListModel.getAlbumDetail(context, this, id);
            }
        }
    }

    @Override
    public void requestDataFromDatabase(Context context, int type, int id) {
        if (albumListView != null){
            albumListView.showProgress();
        }
        if(type == AppConstants.ALBUM_LIST) {
            albumListModel.getAlbumListFromDatabase(context, this);
        }else{
            albumListModel.getAlbumListFromDatabaseWithAlbumId(context, this, id);
        }
    }

    @Override
    public void deleteAlbum(Context context, int id) {
        if (albumListView != null){
            albumListView.showProgress();
        }
        albumListModel.deleteAlbum(context, this, id);
    }
}
