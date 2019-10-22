package com.ntes.demo;

import android.app.Activity;
import android.os.Bundle;

import com.ntes.demo.paint.SplitView;
import com.ntes.demo.paint.XfermodeEraserView;
import com.ntes.demo.paint.XfermodeView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SplitView(this));

    }
}
