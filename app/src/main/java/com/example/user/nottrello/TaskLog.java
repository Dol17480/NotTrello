package com.example.user.nottrello;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by user on 14/11/2016.
 */

public class TaskLog {
    private static TaskLog sTaskLog;
    private List<Task> mTasks;

    public static TaskLog get(Context context) {
        if (sTaskLog == null) {
            sTaskLog = new TaskLog(context);
        }
        return sTaskLog;
    }

    private TaskLog (Context context) {
        mTasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setmTitle("Task #" +i);
            task.setmCompleted(i % 2 == 0);
            mTasks.add(task);
        }
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
