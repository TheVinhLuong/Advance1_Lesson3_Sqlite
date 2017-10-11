package com.example.android.recyclerviewexample.sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.recyclerviewexample.sqlite.data.model.Word;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "contactsManager";
	private static final String TABLE_WORDS = "words";
	private static final String KEY_ID = "id";
	private static final String KEY_WORD = "name";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_WORDS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_WORD + " TEXT)";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);
		onCreate(db);
	}
	
	public void resetTable(){
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);
		onCreate(db);
	}
	
	public void addWord(Word word) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_WORD, word.getWord()); // Contact Name
		db.insert(TABLE_WORDS, null, values);
		db.close();
	}


	public Word getWord(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_WORDS, new String[] { KEY_ID,
				KEY_WORD}, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, 
				null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
		Word word = new Word(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
		return word;
	}
	
	public List<Word> getAllWords() {
		List<Word> wordList = new ArrayList<Word>();
		String selectQuery = "SELECT  * FROM " + TABLE_WORDS;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Word word = new Word();
				word.setId(Integer.parseInt(cursor.getString(0)));
				word.setWord(cursor.getString(1));
				wordList.add(word);
			} while (cursor.moveToNext());
		}
		return wordList;
	}
}