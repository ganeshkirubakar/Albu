package com.albums.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.albums.R;
import com.albums.model.Users;
import com.albums.view.frament.UserFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.AlbumListViewHolder> {

    private String TAG = UserListAdapter.class.getName();

    private ArrayList<Users> mUsersList;
    private UserFragment baseActivity;

    public UserListAdapter(UserFragment baseActivity, ArrayList<Users> userLists){
        this.baseActivity = baseActivity;
        sortByTitle(userLists);
        mUsersList = userLists;
    }
    @NonNull
    @Override
    public AlbumListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.album_list_item, parent, false);
        return new AlbumListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumListViewHolder holder, final int position) {
        holder.albumTitle.setText(mUsersList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsersList.size();
    }

    /**
     * ViewHolder Items for AlbumList Inflated to RecyclerView
     */
    class AlbumListViewHolder extends RecyclerView.ViewHolder{
        private TextView albumTitle;
        AlbumListViewHolder(View itemView) {
            super(itemView);
            albumTitle = itemView.findViewById(R.id.album_title);
        }
    }

    /**
     * Sort ArrayList by Title from response
     * @param response Api retrieved response
     */
    private void sortByTitle(ArrayList<Users> response){
        Collections.sort(response, new AlbumListComparator());
    }

    private class AlbumListComparator implements Comparator<Users> {
        @Override
        public int compare(Users o1, Users o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
