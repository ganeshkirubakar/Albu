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
import com.albums.adapter.UserListAdapter;
import com.albums.appInterface.ActivityInterface;
import com.albums.appInterface.FragmentInterface;
import com.albums.contract.UserListContract;
import com.albums.model.Users;
import com.albums.presenter.UserListPresenter;
import com.albums.utils.DialogUtils;

import java.util.ArrayList;

public class UserFragment extends Fragment implements UserListContract.View, ActivityInterface{
    private final String TAG = UserFragment.class.getName();

    private RecyclerView mUsersView;
    private ProgressBar mProgressBar;
    private TextView mUnavailableText;
    public UserListPresenter userListPresenter;
    private FragmentInterface fragmentInterface;

    public static UserFragment newInstance(){
        return new UserFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.users_list, container, false);
        mUsersView  = view.findViewById(R.id.user_list);
        mProgressBar = view.findViewById(R.id.user_progress);
        mUnavailableText = view.findViewById(R.id.items_unavailable);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mUsersView.setLayoutManager(mLayoutManager);
        fragmentInterface.setActivityInterfaceFromFragment(this);
        userListPresenter = new UserListPresenter(this);
        getUsersList();
        return view;
    }

    /**
     * Get User List from Api
     */
    private void getUsersList(){
        if(fragmentInterface.checkNetworkConnection()) {
            userListPresenter.requestDataFromServer(getContext());
        }else{
            userListPresenter.requestDataFromDB(getContext());
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
    public void showUserDetail(ArrayList<Users> usersArrayList) {
        setUsersListAdapter(usersArrayList);
    }


    @Override
    public void onResponseFailure(String message) {
        mProgressBar.setVisibility(View.GONE);
        DialogUtils.getInstance().showAlertDialog(getContext(), message);
    }

    /**
     * Set Users List based on Availability Of network
     * @param UsersArrayList Retrieved from DB if offline, else from API call
     */
    private void setUsersListAdapter( ArrayList<Users> UsersArrayList){
        RecyclerView.Adapter mRecyclerAdapter = new UserListAdapter(this, UsersArrayList);
        mUsersView.setAdapter(mRecyclerAdapter);
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
        userListPresenter.onDestoryView();
    }
    @Override
    public void onRefresh() {
        getUsersList();
    }
}
