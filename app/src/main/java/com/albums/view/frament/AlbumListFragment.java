package com.albums.view.frament;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.albums.R;
import com.albums.adapter.AlbumListAdapter;
import com.albums.appInterface.ActivityInterface;
import com.albums.appInterface.AlbumListItemClickListener;
import com.albums.appInterface.FragmentInterface;
import com.albums.constants.AppConstants;
import com.albums.contract.AlbumListContract;
import com.albums.model.Album;
import com.albums.presenter.AlbumListPresenter;
import com.albums.utils.DialogUtils;

import java.util.ArrayList;

public class AlbumListFragment extends Fragment implements AlbumListContract.View, AlbumListItemClickListener, ActivityInterface {

    private final String TAG = AlbumListFragment.class.getName();

    private RecyclerView mAlbumView;
    private ProgressBar mProgressBar;
    private TextView mUnavailableText;
    public AlbumListPresenter albumListPresenter;
    private FragmentInterface fragmentInterface;

    public static AlbumListFragment newInstance(){
        return new AlbumListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.album_list, container, false);
        mAlbumView  = view.findViewById(R.id.album_list);
        mProgressBar = view.findViewById(R.id.album_progress);
        mUnavailableText = view.findViewById(R.id.items_unavailable);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mAlbumView.setLayoutManager(mLayoutManager);
        fragmentInterface.setActivityInterfaceFromFragment(this);
        albumListPresenter = new AlbumListPresenter(this);
        getAlbumList();
        return view;
    }

    /**
     * Get Album List from Api
     */
    private void getAlbumList(){
        if(fragmentInterface.checkNetworkConnection()) {
            albumListPresenter.requestDataFromServer(getContext(), AppConstants.ALBUM_LIST, -1);
        }else{
            albumListPresenter.requestDataFromDatabase(getContext(), AppConstants.ALBUM_LIST, -1);
        }
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyView(int visibility) {
        mUnavailableText.setVisibility(visibility);
    }

    @Override
    public void setDataToRecyclerView(ArrayList<?> albumArrayList) {
        setAlbumListAdapter((ArrayList<Album>) albumArrayList);
    }

    @Override
    public void onResponseFailure(String message) {
        mProgressBar.setVisibility(View.GONE);
        DialogUtils.getInstance().showAlertDialog(getContext(), message);
    }

    /**
     * Set Album List based on Availability Of network
     * @param albumArrayList Retrieved from DB if offline, else from API call
     */
    private void setAlbumListAdapter(ArrayList<Album> albumArrayList){
        RecyclerView.Adapter mRecyclerAdapter = new AlbumListAdapter(this, albumArrayList);
        mAlbumView.setAdapter(mRecyclerAdapter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentInterface = (FragmentInterface) context;
        } catch (ClassCastException e) {
           Log.d(TAG, e.toString());
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentInterface = (FragmentInterface) activity;
        } catch (ClassCastException e) {
            Log.d(TAG, e.toString());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        albumListPresenter.onDestroyView();
    }

    @Override
    public void onItemClick(int position) {
        fragmentInterface.addFragment(AlbumDetailFragment.newInstance(position));
    }

    @Override
    public void onRefresh() {
        getAlbumList();
    }
}
