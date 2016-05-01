package me.pengtao.contentprovidertest.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * Created by 90Chris on 2016/5/1.
 */
public class TestDBHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "test.db";

    public TestDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_CONTACT_TABLE = "CREATE TABLE " + TestContract.TestEntry.TABLE_NAME + "( "
                + TestContract.TestEntry._ID + " TEXT PRIMARY KEY, "
                + TestContract.TestEntry.COLUMN_NAME + " TEXT NOT NULL );";

        db.execSQL(SQL_CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TestContract.TestEntry.TABLE_NAME);
        onCreate(db);
    }
}
