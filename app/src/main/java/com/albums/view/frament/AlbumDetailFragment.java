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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.albums.R;
import com.albums.adapter.AlbumDetailsAdapter;
import com.albums.appInterface.ActivityInterface;
import com.albums.appInterface.AlbumListItemClickListener;
import com.albums.appInterface.FragmentInterface;
import com.albums.constants.AppConstants;
import com.albums.contract.AlbumListContract;
import com.albums.model.AlbumPhotos;
import com.albums.presenter.AlbumListPresenter;
import com.albums.utils.DialogUtils;

import java.util.ArrayList;
import java.util.Objects;

public class AlbumDetailFragment extends Fragment implements AlbumListContract.View, AlbumListItemClickListener, View.OnClickListener, ActivityInterface {

    private final String TAG = AlbumDetailFragment.class.getName();

    private RecyclerView mAlbumDetailView;
    private ProgressBar mProgressBarDetails;
    private TextView mAlbumDetailUnavailableText;
    public AlbumListPresenter albumListPresenter;
    private FragmentInterface fragmentInterface;
    private EditText searchText;
    private static final String ALBUM_ID = "albumID";

    public static AlbumDetailFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt(ALBUM_ID, id);
        AlbumDetailFragment fragment = new AlbumDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.album_detail_view, container, false);
        mAlbumDetailView = view.findViewById(R.id.album_details_list);
        mProgressBarDetails = view.findViewById(R.id.album_detail_progress);
        mAlbumDetailUnavailableText = view.findViewById(R.id.items_details_unavailable);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mAlbumDetailView.setLayoutManager(mLayoutManager);
        Button search = view.findViewById(R.id.go);
        search.setOnClickListener(this);
        searchText = view.findViewById(R.id.search_text);
        albumListPresenter = new AlbumListPresenter(this);
        registerForContextMenu(mAlbumDetailView);
        fragmentInterface.setActivityInterfaceFromFragment(this);
        getAlbumDetailsList();
        return view;
    }

    /**
     * Get Album Details List from Api
     */
    private void getAlbumDetailsList(){
        if(fragmentInterface.checkNetworkConnection()) {
            albumListPresenter.requestDataFromServer(getContext(), AppConstants.ALBUM_DETAILS,Objects.requireNonNull(getArguments()).getInt(ALBUM_ID));
        }else{
            albumListPresenter.requestDataFromDatabase(getContext(), AppConstants.ALBUM_DETAILS, Objects.requireNonNull(getArguments()).getInt(ALBUM_ID));
        }
    }

    @Override
    public void showProgress() {
        mProgressBarDetails.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBarDetails.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyView(int visibility) {
        mAlbumDetailUnavailableText.setVisibility(visibility);
    }

    @Override
    public void setDataToRecyclerView(ArrayList<?> albumArrayList) {
        setAlbumListAdapter((ArrayList<AlbumPhotos>) albumArrayList);
    }

    @Override
    public void onResponseFailure(String message) {
        ArrayList<AlbumPhotos> albumPhotos = new ArrayList<>();
        setAlbumListAdapter(albumPhotos);
        mProgressBarDetails.setVisibility(View.GONE);
        DialogUtils.getInstance().showAlertDialog(getContext(), message);
    }


    /**
     * Set Album List based on Availability Of network
     * @param albumArrayList Retrieved from DB if offline, else from API call
     */
    private void setAlbumListAdapter(ArrayList<AlbumPhotos> albumArrayList){
        RecyclerView.Adapter mRecyclerAdapter = new AlbumDetailsAdapter(this, albumArrayList);
        mAlbumDetailView.setAdapter(mRecyclerAdapter);
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
        Log.d(TAG, "position :"+position);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.go){
            fragmentInterface.hideKeyboard();
            int albumId = Integer.valueOf(searchText.getText().toString());
            if(fragmentInterface.checkNetworkConnection()) {
                albumListPresenter.requestDataFromServer(getContext(), AppConstants.ALBUM_SEARCH, albumId);
            }else{
                albumListPresenter.requestDataFromDatabase(getContext(), AppConstants.ALBUM_SEARCH, albumId);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int position = -1;
        try {
            position = ((AlbumDetailsAdapter)mAlbumDetailView.getAdapter()).getPosition();
        } catch (Exception e) {
            Log.d(TAG, e.getLocalizedMessage(), e);
            return super.onContextItemSelected(item);
        }
        switch (item.getItemId()) {
            case 0:
                albumListPresenter.deleteAlbum(getContext(), position);
                break;
        }
        return super.onContextItemSelected(item);

    }

    @Override
    public void onRefresh() {
        getAlbumDetailsList();
    }
}
