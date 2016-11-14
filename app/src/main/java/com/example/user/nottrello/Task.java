package com.example.user.nottrello;

import java.util.UUID;

/**
 * Created by user on 14/11/2016.
 */

public class Task {

    private UUID mId;
    private String mTitle;

    public Task() {
        mId = UUID.randomUUID();
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
}
