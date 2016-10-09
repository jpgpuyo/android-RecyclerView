/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.recyclerview.renderers.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.common.logger.Log;
import com.example.android.recyclerview.R;
import com.example.android.recyclerview.renderers.model.Video;
import com.pedrogomez.renderers.Renderer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoRenderer extends Renderer<Video> {

    private static final String TAG = "VideoRenderer";

    @BindView(R.id.tv_title)
    TextView title;

    @BindView(R.id.iv_thumbnail)
    ImageView thumbnail;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.video_renderer, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @Override
    public void render() {
        Video video = getContent();
        Log.d(TAG, "Element " + video.getPosition() + " set.");

        this.title.setText(video.getTitle());
        Glide.with(getContext()).load(video.getThumbnail()).into(thumbnail);
    }

    @OnClick(R.id.tv_title)
    void onVideoTitleClicked() {
        Video video = getContent();
        Log.d("Renderer", "Clicked: " + video.getTitle());
    }

    @OnClick(R.id.iv_thumbnail)
    void onVideoThumnailClicked() {
        Video video = getContent();
        Log.d("Renderer", "Clicked: " + video.getThumbnail());
    }

    //If you don't use ButterKnife you have to implement these methods.

    /**
     * Maps all the view elements from the xml declaration to members of this renderer.
     */
    @Override
    protected void setUpView(View rootView) {
        /*
         * Empty implementation substituted with the usage of ButterKnife library by Jake Wharton.
         */
    }

    /**
     * Insert external listeners in some widgets.
     */
    @Override
    protected void hookListeners(View rootView) {
        /*
         * Empty implementation substituted with the usage of ButterKnife library by Jake Wharton.
         */
    }
}
