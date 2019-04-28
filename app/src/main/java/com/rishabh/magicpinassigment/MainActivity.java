package com.rishabh.magicpinassigment;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rishabh.magicpinassigment.DataFeed.VideoDataFeed;
import com.rishabh.magicpinassigment.adapter.VideoAdapter;
import com.rishabh.magicpinassigment.model.VideoInfo;
import com.rishabh.magicpinassigment.ui.VideoRecyclerView;
import com.rishabh.magicpinassigment.util.Utils;
import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.recycler_view) VideoRecyclerView recyclerViewFeed;

  private ArrayList<VideoInfo> videoInfoList = new ArrayList<>();
  private VideoAdapter mAdapter;
  private VideoDataFeed videoDataFeed;
  private boolean restart;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    videoDataFeed = new VideoDataFeed();
    if (Utils.isNetworkAvailable(this)) {
      videoInfoList = videoDataFeed.getVideoInfoArrayList();
    }
    recyclerViewFeed.setVideoInfoList(videoInfoList);
    mAdapter = new VideoAdapter(videoInfoList);
    recyclerViewFeed.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
    recyclerViewFeed.setAdapter(mAdapter);
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        recyclerViewFeed.playVideo();
      }
    }, 1000);

    recyclerViewFeed.scrollToPosition(0);
  }

  @Override protected void onResume() {
    super.onResume();
    if (recyclerViewFeed != null && restart) {
      recyclerViewFeed.onRestartPlayer();
      restart = false;
    }
  }

  @Override protected void onPause() {
    super.onPause();
    if (recyclerViewFeed != null) {
      recyclerViewFeed.onPausePlayer();
      restart = true;
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (recyclerViewFeed != null) recyclerViewFeed.onRelease();
  }
}
