/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
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
import com.example.android.recyclerview.renderers.model.SampleModel;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Demonstrates the use of library https://github.com/pedrovgs/Renderers,
 * created by Pedro Vicente Gómez Sánchez
 */
public class RenderersFragment extends SampleFragmentBase {

    private static final String TAG = "RenderersFragment";

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private RVRendererAdapter<SampleModel> adapter;

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
        List<SampleModel> sampleModelList = transformDatasetToSampleModelList();

        Renderer<SampleModel> renderer = new SampleRenderer();
        RendererBuilder<SampleModel> rendererBuilder = new RendererBuilder(renderer);

        adapter = new RVRendererAdapter(rendererBuilder, new ListAdapteeCollection<>(sampleModelList));
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected int getResourceFragmentDescription() {
        return R.string.renderers_fragment_description;
    }

    private List<SampleModel> transformDatasetToSampleModelList() {
        List<SampleModel> sampleModelList = new ArrayList();
        for (int i = 0; i < mDataset.length; i++) {
            String datasetElement = mDataset[i];
            SampleModel sampleModel = new SampleModel();
            sampleModel.setPosition(i);
            sampleModel.setText(datasetElement);
            sampleModelList.add(sampleModel);
        }
        return sampleModelList;
    }
}
