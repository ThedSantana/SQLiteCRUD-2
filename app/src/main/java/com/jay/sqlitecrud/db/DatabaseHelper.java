package com.jay.sqlitecrud.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jayli on 2017/6/29 0029.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "db_goods"; //数据库名称
    private static final int VERSION = 1; //数据库版本
    public static final String TABLE_NAME = "t_goods"; //数据表名


    public DatabaseHelper(Context context) {
        //第三个参数CursorFactory指定在执行查询时获得一个游标实例的工厂类,设置为null,代表使用系统默认的工厂类
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists " + TABLE_NAME + "(id integer primary key autoincrement, name varchar(20), images text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
}
