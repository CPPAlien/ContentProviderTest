package me.pengtao.contentprovidertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import me.pengtao.contentprovidertest.provider.TestContract;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentValues contentValues = new ContentValues();
        contentValues.put(TestContract.TestEntry.COLUMN_NAME, "peng");
        contentValues.put(TestContract.TestEntry._ID, System.currentTimeMillis());
        getContentResolver().insert(TestContract.TestEntry.CONTENT_URI, contentValues);

        Cursor cursor = getContentResolver().query(TestContract.TestEntry.CONTENT_URI, null, null, null, null);

        try {
            Log.e("ContentProviderTest", "total data number = " + cursor.getCount());
            cursor.moveToFirst();
            Log.e("ContentProviderTest", "total data number = " + cursor.getString(1));
        } finally {
            cursor.close();
        }
    }
}
