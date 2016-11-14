package com.example.user.nottrello;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by user on 14/11/2016.
 */

public class TaskPagerActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private List<Task> mTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_pager);

        mViewPager = (ViewPager) findViewById(R.id.activity_task_pager_view_pager);

        mTasks = TaskLog.get(this).getmTasks();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Task task = mTasks.get(position);
                return TaskFragment.newInstance(task.getmId());
            }

            @Override
            public int getCount() {
                return mTasks.size();
            }
        });
    }
}
