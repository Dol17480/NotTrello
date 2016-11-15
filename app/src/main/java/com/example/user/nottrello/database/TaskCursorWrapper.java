package com.example.user.nottrello.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.user.nottrello.Task;

import java.util.Date;
import java.util.UUID;

/**
 * Created by user on 15/11/2016.
 */

public class TaskCursorWrapper extends CursorWrapper {
    public TaskCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Task getTask() {
        String uuidString = getString(getColumnIndex(TaskDbSchema.TaskTable.Cols.UUID));
        String title = getString(getColumnIndex(TaskDbSchema.TaskTable.Cols.TITLE));
        long date = getLong(getColumnIndex(TaskDbSchema.TaskTable.Cols.DATE));
        int isCompleted = getInt(getColumnIndex(TaskDbSchema.TaskTable.Cols.COMPLETED));

        Task task = new Task(UUID.fromString(uuidString));
        task.setmTitle(title);
        task.setmDate(new Date(date));
        task.setmCompleted(isCompleted !=0);
        return task;
    }
}
