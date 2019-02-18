package com.axxess.challenge.persistence.localdatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ImageEntity.class}, version = 1)
public abstract class ImageRoomDatabase extends RoomDatabase {
    public abstract ImageDao imageDao();

    private static volatile ImageRoomDatabase INSTANCE;

    public static ImageRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ImageRoomDatabase.class) {
                // Create database here
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        ImageRoomDatabase.class, "imgur_database")
                        .build();
            }
        }
        return INSTANCE;
    }
}
