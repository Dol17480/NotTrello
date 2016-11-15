package com.example.user.nottrello;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.nottrello.database.TaskBaseHelper;
import com.example.user.nottrello.database.TaskCursorWrapper;
import com.example.user.nottrello.database.TaskDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by user on 14/11/2016.
 */

public class TaskLog {
    private static TaskLog sTaskLog;

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

    }

    public void addTask(Task t) {
        ContentValues values = getContentValues(t);
        mDatabase.insert(TaskDbSchema.TaskTable.NAME, null, values);
    }

    public List<Task> getmTasks() {
        List<Task> tasks = new ArrayList<>();
        TaskCursorWrapper cursor = queryTasks(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                tasks.add(cursor.getTask());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return tasks;
    }

    public Task getTask(UUID id)  {
        TaskCursorWrapper cursor = queryTasks(TaskDbSchema.TaskTable.Cols.UUID + " = ?",
                new String [] { id.toString() }
        );

    try {
        if (cursor.getCount() == 0) {
            return null;
        }

        cursor.moveToFirst();
        return cursor.getTask();
    } finally {
        cursor.close();
    }

}

    public void updateTask(Task task) {
        String uuidString = task.getmId().toString();
        ContentValues values = getContentValues(task);

        mDatabase.update(TaskDbSchema.TaskTable.NAME, values,
                TaskDbSchema.TaskTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }

    public void deleteTask(UUID taskId)
    {
        String uuidString = taskId.toString();
        mDatabase.delete(TaskDbSchema.TaskTable.NAME, TaskDbSchema.TaskTable.Cols.UUID + " = ?", new String[] {uuidString});
    }

    private static ContentValues getContentValues(Task task) {
        ContentValues values = new ContentValues();
        values.put(TaskDbSchema.TaskTable.Cols.UUID, task.getmId().toString());
        values.put(TaskDbSchema.TaskTable.Cols.TITLE, task.getmTitle());
        values.put(TaskDbSchema.TaskTable.Cols.DATE, task.getmDate().getTime());
        values.put(TaskDbSchema.TaskTable.Cols.COMPLETED, task.ismCompleted() ? 1 : 0);

        return values;
    }

    private TaskCursorWrapper queryTasks(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                TaskDbSchema.TaskTable.NAME,
                null,
        whereClause,
        whereArgs,
        null,
        null,
        null
        );
        return new TaskCursorWrapper(cursor);
    }
}
