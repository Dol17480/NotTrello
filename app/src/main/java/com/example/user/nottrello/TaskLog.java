package com.example.user.nottrello;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.nottrello.database.TaskBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by user on 14/11/2016.
 */

public class TaskLog {
    private static TaskLog sTaskLog;
    private List<Task> mTasks;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static TaskLog get(Context context) {
        if (sTaskLog == null) {
            sTaskLog = new TaskLog(context);
        }
        return sTaskLog;
    }

    private TaskLog (Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new TaskBaseHelper(mContext).getWritableDatabase();
        mTasks = new ArrayList<>();


    }

    public void addTask(Task t) {
        mTasks.add(t);
    }

    public List<Task> getmTasks() {
        return mTasks;
    }

    public Task getTask(UUID id)  {
        for (Task task : mTasks) {
            if (task.getmId().equals(id)) {
                return task;
            }
        }
        return null;
    }
}
