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

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.common.fragments.SampleFragmentBase;
import com.example.android.recyclerview.R;
import com.example.android.recyclerview.renderers.data.RandomVideoCollectionGenerator;
import com.example.android.recyclerview.renderers.model.Video;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Demonstrates the use of library https://github.com/pedrovgs/Renderers,
 * created by Pedro Vicente Gómez Sánchez
 */
public class RenderersFragment extends SampleFragmentBase {

    private static final String TAG = "RenderersFragment";
    private static final int VIDEO_COUNT = 5;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private RVRendererAdapter<Video> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.renderers_fragment, container, false);
        rootView.setTag(TAG);

        ButterKnife.bind(this, rootView);

        initAdapter();
        initRecyclerView();

        return rootView;
    }

    private void initAdapter() {

        RandomVideoCollectionGenerator randomVideoCollectionGenerator = new RandomVideoCollectionGenerator();
        AdapteeCollection<Video> videoCollection = randomVideoCollectionGenerator.generateListAdapteeVideoCollection(VIDEO_COUNT);

        Renderer<Video> renderer = new VideoRenderer();
        RendererBuilder<Video> rendererBuilder = new RendererBuilder(renderer);

        adapter = new RVRendererAdapter(rendererBuilder, videoCollection);
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected int getResourceFragmentDescription() {
        return R.string.renderers_fragment_description;
    }
}
