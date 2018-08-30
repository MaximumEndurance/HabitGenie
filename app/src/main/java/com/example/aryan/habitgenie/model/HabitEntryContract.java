package com.example.aryan.habitgenie.model;

import android.provider.BaseColumns;

public final class HabitEntryContract {
    private HabitEntryContract() {}

    public static class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "HabitsList";
        public static final String COLUMN_NAME_TITLE = "Title";
        public static final String COLUMN_NAME_SUBTITLE = "Description";
    }
}
