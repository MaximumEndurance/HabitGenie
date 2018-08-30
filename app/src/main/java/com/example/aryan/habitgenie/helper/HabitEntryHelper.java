package com.example.aryan.habitgenie.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.aryan.habitgenie.helper.SQLHelper.CREATE_HABIT_TABLE;
import static com.example.aryan.habitgenie.helper.SQLHelper.DELETE_HABIT_TABLE;
import static com.example.aryan.habitgenie.helper.constants.DATABASE_NAME;
import static com.example.aryan.habitgenie.helper.constants.DATABASE_VERSION;

public class HabitEntryHelper extends SQLiteOpenHelper {
    public  HabitEntryHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // this is simply refresh and restart
        sqLiteDatabase.execSQL(DELETE_HABIT_TABLE);
        onCreate(sqLiteDatabase);
    }
}
