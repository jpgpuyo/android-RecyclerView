package com.example.android.recyclerview.renderers.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.common.logger.Log;
import com.example.android.recyclerview.R;
import com.example.android.recyclerview.renderers.model.SampleModel;
import com.pedrogomez.renderers.Renderer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SampleRenderer extends Renderer<SampleModel> {

    private static final String TAG = "SampleRenderer";

    @BindView(R.id.textView)
    TextView text;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.text_row_item, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @Override
    public void render() {
        SampleModel sampleModel = getContent();
        Log.d(TAG, "Element " + sampleModel.getPosition() + " set.");
        this.text.setText(sampleModel.getText());
    }

    @OnClick(R.id.textView)
    void onSampleModelClicked() {
        SampleModel sampleModel = getContent();
        Log.d("Renderer", "Clicked: " + sampleModel.getText());
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
