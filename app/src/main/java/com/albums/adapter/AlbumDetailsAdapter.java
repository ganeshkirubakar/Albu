package com.albums.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.albums.R;
import com.albums.model.AlbumPhotos;
import com.albums.view.frament.AlbumDetailFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlbumDetailsAdapter extends RecyclerView.Adapter<AlbumDetailsAdapter.AlbumListDetailsViewHolder> {

    private String TAG = AlbumDetailsAdapter.class.getName();

    private ArrayList<AlbumPhotos> mAlbumDetailsList;
    private AlbumDetailFragment baseActivity;
    private int position;

    public AlbumDetailsAdapter(AlbumDetailFragment baseActivity, ArrayList<AlbumPhotos> albumDetailsList){
        this.baseActivity = baseActivity;
        sortByTitle(albumDetailsList);
        mAlbumDetailsList = albumDetailsList;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    @NonNull
    @Override
    public AlbumListDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.album_detail_item, parent, false);
        return new AlbumListDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumListDetailsViewHolder holder, final int position) {
        holder.albumTitle.setText(mAlbumDetailsList.get(position).getTitle());
        Picasso.get()
                .load(mAlbumDetailsList.get(position).getThumbnailUrl())
                .error(R.mipmap.ic_launcher)
                .into(holder.albumImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.onItemClick(mAlbumDetailsList.get(position).getAlbumId());
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setPosition(mAlbumDetailsList.get(position).getAlbumId());
                return false;
            }
        });
    }

    @Override
    public void onViewRecycled(@NonNull AlbumListDetailsViewHolder holder) {
        holder.itemView.setOnLongClickListener(null);
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return mAlbumDetailsList.size();
    }

    /**
     * ViewHolder Items for AlbumList Inflated to RecyclerView
     */
    class AlbumListDetailsViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private TextView albumTitle;
        private ImageView albumImage;
        AlbumListDetailsViewHolder(View itemView) {
            super(itemView);
            albumTitle = itemView.findViewById(R.id.album_title);
            albumImage = itemView.findViewById(R.id.album_image);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle(R.string.action_select);
            menu.add(0, 0, 0, R.string.delete);
        }
    }

    /**
     * Sort ArrayList by Title from response
     * @param response Api retrieved response
     */
    private void sortByTitle(ArrayList<AlbumPhotos> response){
        Collections.sort(response, new AlbumDetailsAdapter.AlbumListComparator());
    }

    private class AlbumListComparator implements Comparator<AlbumPhotos> {
        @Override
        public int compare(AlbumPhotos o1, AlbumPhotos o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
