package com.example.user.nottrello;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by user on 14/11/2016.
 */

public class TaskFragment extends Fragment {

    private Task mTask;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTask = new Task();
        
    }
}
