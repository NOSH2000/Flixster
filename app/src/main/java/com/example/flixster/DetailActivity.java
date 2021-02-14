package com.example.flixster;

import okhttp3.Headers;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixster.models.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.parceler.Parcels;

public class DetailActivity extends YouTubeBaseActivity {

    // created with sayara email
    public static final String YOUTUBE_API_KEY = "AIzaSyClrzWPVaqql0-Px6wUuvvNt9p9XUjtkXo";
    public static final String VIDEOS_URL = "https://api.themoviedb.org/3/movie/%d/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG = "DetailActivity";
    TextView tvTitle;
    TextView tvOverview;
    RatingBar ratingBar;
    YouTubePlayerView youTubePlayerView;
    static double rating = Movie.getRating();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        ratingBar = findViewById(R.id.ratingBar);
        youTubePlayerView = findViewById(R.id.player);

        // DetailActivity.java (subactivity) can access any extras passed in
        // String title = getIntent().getStringExtra("title");
        // tvTitle.setText(title);
        Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        ratingBar.setRating((float)movie.getRating());

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(String.format(VIDEOS_URL, movie.getMovieID()), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                try {
                    JSONArray results = json.jsonObject.getJSONArray("results");
                    if (results.length() == 0) {
                        return;
                    }
                    String site = results.getJSONObject(0).getString("site");
                    if(site.equalsIgnoreCase("YouTube")){
                        String youtubeKey = results.getJSONObject(0).getString("key");
                        Log.d("TAG", "youtubeKey " + youtubeKey + " site: " + site);
                        initializeYoutube(youtubeKey);
                    } else {
                        Log.e("TAG", "The site is not YouTube");
                        return;
                    }
                } catch (JSONException e) {
                    Log.e("TAG", "Failed to parse JSON", e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String response, Throwable throwable) {
                Log.d("TAG", "onFailure");
            }
        });
    }

    private void initializeYoutube(String youtubeKey) {
        youTubePlayerView.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            /*
                wasRestored: Whether the player was restored from a previously saved state,
                as part of the YouTubePlayerView or YouTubePlayerFragment restoring its state.
                true usually means playback is resuming from where the user expects it would,
                and that a new video should not be loaded.
             */
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                Log.d("TAG", "onInitializationSuccess");
                // do any work here to cue video, play video, etc.
                if(wasRestored){
                    // Resume from where it stopped
                    youTubePlayer.play();
                } else {
                    youTubePlayer.cueVideo(youtubeKey);
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    youTubePlayer.addFullscreenControlFlag(youTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);
                }

//                if(rating > 5.0){
//                    Log.i("TAG", "Rating: " + rating);
//                }
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("TAG", "onInitializationFailure");
            }
        });
    }
}