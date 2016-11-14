package com.example.user.nottrello;

import java.util.Date;
import java.util.UUID;

/**
 * Created by user on 14/11/2016.
 */

public class Task {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mCompleted;

    public Task() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismCompleted() {
        return mCompleted;
    }

    public void setmCompleted(boolean mCompleted) {
        this.mCompleted = mCompleted;
    }
}
