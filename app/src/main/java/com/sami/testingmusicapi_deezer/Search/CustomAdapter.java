package com.sami.testingmusicapi_deezer.Search;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sami.testingmusicapi_deezer.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    private List<DataItem> localDataSet;
//    AdapterView.OnItemClickListener listener;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        private final LinearLayout linearLayout2;



        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView2);
            imageView=view.findViewById(R.id.imageView2);
            linearLayout2=view.findViewById(R.id.linearLayout2);
        }

        public TextView getTextView() {
            return textView;
        }
        public ImageView getImageView(){
            return imageView;
        }
        public LinearLayout getLinearLayout2(){
            return linearLayout2;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter(List<DataItem> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);



        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet.get(viewHolder.getAdapterPosition()).getTitle().toString());
        Picasso.get().load(localDataSet.get(viewHolder.getAdapterPosition()).getAlbum().getCover()).into(viewHolder.getImageView());

        viewHolder.getLinearLayout2().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),PlaySongActivity.class);
                intent.putExtra("name",localDataSet.get(viewHolder.getAdapterPosition()).getTitle());
                intent.putExtra("image",localDataSet.get(viewHolder.getAdapterPosition()).getAlbum().getCoverBig());
                intent.putExtra("track",localDataSet.get(viewHolder.getAdapterPosition()).getPreview());
                v.getContext().startActivity(intent);
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public String getItemArtistImage(int pos) {
        return localDataSet.get(pos).getArtist().getPicture_big().toString();
    }


}
