package com.sami.testingmusicapi_deezer.Search;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sami.testingmusicapi_deezer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter_ArtistList extends RecyclerView.Adapter<CustomAdapter_ArtistList.ViewHolder> {


    private ArrayList<String> localDataSet;
    private ArrayList<String> Artlists;



    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;



        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView4);
            imageView=view.findViewById(R.id.imageView);

        }

        public TextView getTextView() {
            return textView;
        }
        public ImageView getImageView(){
            return imageView;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter_ArtistList(ArrayList<String> dataSet, ArrayList<String> artists) {
        localDataSet = dataSet;
        Artlists=artists;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_layout_list, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Picasso.get().load(localDataSet.get(position)).into(viewHolder.getImageView());

        viewHolder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(v.getContext(), SearchArtist.class);

                in.putExtra("name",Artlists.get(viewHolder.getAdapterPosition()));
                v.getContext().startActivity(in);

            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }



}
