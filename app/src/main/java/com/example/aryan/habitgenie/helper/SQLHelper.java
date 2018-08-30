package com.example.aryan.habitgenie.helper;

import com.example.aryan.habitgenie.model.HabitEntryContract.HabitEntry;

public class SQLHelper {
    private static final String CREATE_HABIT_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME +
            " (" +     HabitEntry._ID + " INTEGER PRIMARY KEY," +
            HabitEntry.COLUMN_NAME_TITLE + " TEXT," +
            HabitEntry.COLUMN_NAME_SUBTITLE + " TEXT)";


    private static final String DELETE_HABIT_TABLE =
            "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME;
}
