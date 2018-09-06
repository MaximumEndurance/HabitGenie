package com.example.aryan.habitgenie;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.aryan.habitgenie.helper.HabitEntryHelper;
import com.example.aryan.habitgenie.model.HabitEntryContract;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        String currentHabits[] = readFromTable();
        String currentHabits[] = { "Habit1", "Habit2" };
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.content_main,
                currentHabits);
        ListView listOfCurrentHabits = (ListView) findViewById(R.id.habitsList);
        listOfCurrentHabits.setAdapter(arrayAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void addAHabit(String habitName, String habitDescription) {
        HabitEntryHelper habitEntryHelper = new HabitEntryHelper(getApplicationContext());

        SQLiteDatabase db = habitEntryHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(HabitEntryContract.HabitEntry.COLUMN_NAME_TITLE, habitName);
        values.put(HabitEntryContract.HabitEntry.COLUMN_NAME_SUBTITLE, habitDescription);

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(HabitEntryContract.HabitEntry.TABLE_NAME, null, values);
    }

    void getAllHabits() {
        HabitEntryHelper habitEntryHelper = new HabitEntryHelper(getApplicationContext());
        SQLiteDatabase db = habitEntryHelper.getReadableDatabase();

        // projection is which columns in the DB will actually be used in this query.
        String[] projection = {
                BaseColumns._ID,
                HabitEntryContract.HabitEntry.COLUMN_NAME_TITLE,
                HabitEntryContract.HabitEntry.COLUMN_NAME_SUBTITLE
        };

        String selection = HabitEntryContract.HabitEntry.COLUMN_NAME_TITLE + " = ? ";
        String[] selectionArgs = { "My Title" };

        // get the results in descending order
        String sortOrder =
                HabitEntryContract.HabitEntry.COLUMN_NAME_SUBTITLE + " DESC";

        // finally generating the query

        Cursor cursor = db.query(
                HabitEntryContract.HabitEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );
        cursor.close();
    }
}
