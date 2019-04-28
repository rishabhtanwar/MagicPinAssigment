package com.rishabh.magicpinassigment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.rishabh.magicpinassigment.R;
import com.rishabh.magicpinassigment.model.VideoInfo;
import com.rishabh.magicpinassigment.ui.BaseViewHolder;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<BaseViewHolder> {

  public static final int VIEW_TYPE_EMPTY = 0;
  public static final int VIEW_TYPE_NORMAL = 1;

  private List<VideoInfo> mInfoList;

  public VideoAdapter(List<VideoInfo> infoList) {
    mInfoList = infoList;
  }

  @NonNull @Override
  public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    switch (viewType) {
      case VIEW_TYPE_NORMAL:
        return new ViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
      case VIEW_TYPE_EMPTY:
        return new EmptyViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_empty_view, parent, false));
      default:
        return null;
    }
  }

  @Override public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
    holder.onBind(position);
  }

  @Override public int getItemViewType(int position) {
    if (mInfoList != null && mInfoList.size() > 0) {
      return VIEW_TYPE_NORMAL;
    } else {
      return VIEW_TYPE_EMPTY;
    }
  }

  @Override public int getItemCount() {
    if (mInfoList != null && mInfoList.size() > 0) {
      return mInfoList.size();
    } else {
      return 1;
    }
  }

  public void onRelease() {
    if (mInfoList != null) {
      mInfoList.clear();
      mInfoList = null;
    }
  }

  public class ViewHolder extends BaseViewHolder {
    @BindView(R.id.video_layout) public FrameLayout videoLayout;
    @BindView(R.id.progressBar) public ProgressBar mProgressBar;
    @BindView(R.id.place_holder) public ImageView placeHolder;
    public final View parent;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      parent = itemView;
    }

    protected void clear() {

    }

    public void onBind(int position) {
      super.onBind(position);
      parent.setTag(this);
      VideoInfo videoInfo = mInfoList.get(position);
    }
  }

  public class EmptyViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_message) TextView messageTextView;

    public EmptyViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
