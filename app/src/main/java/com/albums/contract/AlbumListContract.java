package com.albums.contract;

import android.content.Context;

import java.util.ArrayList;

public interface AlbumListContract {

    interface Model{
        interface OnFinishedListener{
            void onSuccess(ArrayList<?> response);
            void onDeleteSuccess();
            void onError(String message);
        }
        void getAlbumList(Context context, OnFinishedListener onFinishedListener);
        void getAlbumDetail(Context context, OnFinishedListener onFinishedListener, int  id);
        void getAlbumDetailsWitID(Context context, OnFinishedListener onFinishedListener, int id);
        void getAlbumListFromDatabase(Context context, OnFinishedListener onFinishedListener);
        void getAlbumListFromDatabaseWithAlbumId(Context context, OnFinishedListener onFinishedListener, int id);
        void deleteAlbum(Context context, OnFinishedListener onFinishedListener, int id);
    }

    interface View {

        void showProgress();

        void hideProgress();

        void showEmptyView(int visibility);

        void setDataToRecyclerView(ArrayList<?> albumArrayList);

        void onResponseFailure(String message);

    }

    interface Presenter {

        void onDestroyView();

        void requestDataFromServer(Context context, int type, int id);

        void requestDataFromDatabase(Context context, int type, int id);

        void deleteAlbum(Context context, int id);
    }
}
