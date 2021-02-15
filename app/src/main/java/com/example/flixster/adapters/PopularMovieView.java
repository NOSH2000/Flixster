//package com.example.flixster.adapters;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Configuration;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.example.flixster.DetailActivity;
//import com.example.flixster.R;
//import com.example.flixster.models.Movie;
//
//import org.parceler.Parcels;
//
//import java.util.List;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
//
//public class PopularMovieView extends RecyclerView.ViewHolder{
//
//    RelativeLayout container;
//    TextView tvTitle;
//    TextView tvOverview;
//    ImageView ivPoster;
//
//    public PopularMovieView(@NonNull View itemView) {
//        super(itemView);
//        tvTitle = itemView.findViewById(R.id.tvTitle);
//        tvOverview = itemView.findViewById(R.id.tvOverview);
//        ivPoster = itemView.findViewById(R.id.ivPoster);
//        container = itemView.findViewById(R.id.container);
//    }
//
//    public void bind(Movie movie) {
//        tvTitle.setText(movie.getTitle());
//        tvOverview.setText(movie.getOverview());
//        String imageURL;
//        if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
//            // If landscape mode, imageURL = backdrop image
//            imageURL = movie.getBackdropPath();
//        } else {
//            // else imageURL = poster image
//            imageURL = movie.getPosterPath();
//        }
//
//        // For animated loading placeholder and Rounded Corners
//        int radius = 30; // corner radius, higher value = more rounded
//        int margin = 10; // crop margin, set to 0 for corners with no crop
//
//        // pass activity name
//        Glide.with(context)
//                .load(imageURL)
//                .placeholder(R.drawable.placeholder) // Animated progress bar
//                .diskCacheStrategy(DiskCacheStrategy.NONE) // Don't store cache
//                .transform(new RoundedCornersTransformation(radius, margin))
//                .into(ivPoster);
//
//        // Glide.with(context).load(imageURL).into(ivPoster);
//
//        // 1. Register click on the whole row
//        //// To do that, we need to get the reference to the whole container containing the image and texts
//        container.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 2. Navigate to a new activity on tap
//                // first parameter is the context, second is the class of the activity to launch
//                Intent i = new Intent(context, DetailActivity.class);
//
//                // put "extras" into the bundle for access in the second activity
//                // i.putExtra("title", movie.getTitle());
//                i.putExtra("movie", Parcels.wrap(movie));
//
//                // brings up the second activity
//                context.startActivity(i);
//            }
//        });
//    }
//}
//}
