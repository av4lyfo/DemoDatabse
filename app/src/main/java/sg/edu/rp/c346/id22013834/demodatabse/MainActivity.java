package sg.edu.rp.c346.id22013834.demodatabse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "tasks.db";

    private static final String TABLE_TASK = "task";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_DATE = "date";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_TASK +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT )";
        db.execSQL(createTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        // Create table(s) again
        onCreate(db);

        // You can implement the necessary logic for handling database upgrades here
        // This method will be called when the database version changes
        // You can drop tables, modify table structure, or perform any other necessary updates
    }
}
