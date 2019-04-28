package com.rishabh.magicpinassigment.DataFeed;

import com.rishabh.magicpinassigment.model.VideoInfo;
import java.util.ArrayList;

public class VideoDataFeed {
  private ArrayList<VideoInfo> videoInfoArrayList = new ArrayList<>();

  private void prepareVideoList() {
    VideoInfo videoInfo = new VideoInfo();
    videoInfo.setUrl(
        "https://player.vimeo.com/external/286837767.m3u8?s=42570e8c4a91b98cdec7e7bfdf0eccf54e700b69");

    VideoInfo videoInfo2 = new VideoInfo();
    videoInfo2.setUrl(
        "https://player.vimeo.com/external/286837810.m3u8?s=610b4fee49a71c2dbf22c01752372ff1c6459b9e");

    VideoInfo videoInfo3 = new VideoInfo();
    videoInfo3.setUrl(
        "https://player.vimeo.com/external/286837723.m3u8?s=3df60d3c1c6c7a11df4047af99c5e05cc2e7ae96");

    VideoInfo videoInfo4 = new VideoInfo();
    videoInfo4.setUrl(
        "https://player.vimeo.com/external/286837649.m3u8?s=9e486e9b932be72a8875afc6eaae21bab124a35a");

    VideoInfo videoInfo5 = new VideoInfo();
    videoInfo5.setUrl(
        "https://player.vimeo.com/external/286837529.m3u8?s=20f83af6ea8fbfc8ce0c2001f32bf037f8b0f65f");

    VideoInfo videoInfo6 = new VideoInfo();
    videoInfo5.setUrl(
        "https://player.vimeo.com/external/286837402.m3u8?s=7e01c398e2f01c29ecbd46e5e2dd53e0d6c1905d");

    videoInfoArrayList.add(videoInfo);
    videoInfoArrayList.add(videoInfo2);
    videoInfoArrayList.add(videoInfo3);
    videoInfoArrayList.add(videoInfo4);
    videoInfoArrayList.add(videoInfo5);
    videoInfoArrayList.add(videoInfo6);
  }

  public ArrayList<VideoInfo> getVideoInfoArrayList() {
    prepareVideoList();
    return videoInfoArrayList;
  }
}
