package com.axxess.challenge.persistence.localdatabase;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image_table")
public class ImageEntity {
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "mId")
    private String mId;

    @ColumnInfo(name = "mComment")
    private String mComment;


    public String getId() {
        return mId;
    }

    public String getComment() {
        return mComment;
    }

    public ImageEntity(@NonNull String id, String comment) {
        this.mId = id;
        this.mComment = comment;
    }

}
