package com.axxess.challenge.persistence.localdatabase;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ImageEntity imageEntity);

    @Query("SELECT * from image_table")
    List<ImageEntity> getAllImages();

    @Query("SELECT * FROM image_table WHERE mId = :id ")
    ImageEntity getImage(String id);
}
