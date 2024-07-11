package com.nataliemontesino.mycontactlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String CREATE_TABLE_CONTACT =
            "create table contact (_id integer primary key autoincrement, "
                    + "contactname text not null, streetaddress text, "
                    + "city text, state text, zipcode text, "
                    + "phonenumber text, cellnumber text, "
                    + "email text, birthday text);";

    public ContactDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(ContactDBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }

}
/*
 * The ContactDBHelper class extends SQLiteOpenHelper to manage database creation and version management for the Contact List app.
 *
 * Key functionalities include:
 * - Defining the database name (mycontacts.db) and version (1).
 * - Creating the contact table with columns for ID, contact name, street address, city, state, zip code, phone number, cell number, email, and birthday.
 *
 * Key methods include:
 * - onCreate(SQLiteDatabase db): This method is called when the database is first created. It executes the SQL statement defined in CREATE_TABLE_CONTACT to create the contact table.
 * - onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion): This method is called when the database needs to be upgraded. It logs a message about the upgrade, drops the existing contact table, and calls onCreate() to recreate the table.
 *
 * The CREATE_TABLE_CONTACT string defines the SQL statement to create the contact table with appropriate columns and data types.
 * The onUpgrade method ensures that the database schema is updated appropriately when the database version changes. In this example, it simply drops the old table and creates a new one, which results in the loss of all existing data.
 *
 * The class provides a centralized way to manage the SQLite database for the Contact List app, ensuring that the table schema is correctly defined and maintained.
 */

