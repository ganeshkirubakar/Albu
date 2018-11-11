package com.albums.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.albums.R;
import com.albums.model.Album;
import com.albums.view.frament.AlbumListFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.AlbumListViewHolder> {

    private String TAG = AlbumListAdapter.class.getName();

    private ArrayList<Album> mAlbumList;
    private AlbumListFragment baseActivity;

    public AlbumListAdapter(AlbumListFragment baseActivity, ArrayList<Album> albumList){
        this.baseActivity = baseActivity;
        sortByTitle(albumList);
        mAlbumList = albumList;
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
        holder.albumTitle.setText(mAlbumList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.onItemClick(mAlbumList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAlbumList.size();
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
    private void sortByTitle(ArrayList<Album> response){
        Collections.sort(response, new AlbumListComparator());
    }

    private class AlbumListComparator implements Comparator<Album> {
        @Override
        public int compare(Album o1, Album o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
