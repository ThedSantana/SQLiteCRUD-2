package com.jay.sqlitecrud.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jay.sqlitecrud.model.Goods;
import com.jay.sqlitecrud.utils.JsonMananger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jayli on 2017/6/29 0029.
 */

public class DBUtils {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    public DBUtils(Context context) {
        databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
    }

    public void add(Goods goods){
        // 采用事务处理，确保数据完整性
        db.beginTransaction(); // 开始事务
        try{
            db.execSQL("insert into " + DatabaseHelper.TABLE_NAME + " values(null,?,?)",
                    new Object[]{goods.getName(),JsonMananger.beanToJson(goods.getImages())});
            db.setTransactionSuccessful(); // 设置事务成功完成
        }finally{
            db.endTransaction(); // 结束事务
        }
    }

    public void delete(int id){
        // 采用事务处理，确保数据完整性
        db.beginTransaction(); // 开始事务
        try{
            db.delete(DatabaseHelper.TABLE_NAME,"id = ?",new String[]{String.valueOf(id)});
            db.setTransactionSuccessful(); // 设置事务成功完成
        }finally{
            db.endTransaction(); // 结束事务
        }
    }

    public void update(Goods goods){
        ContentValues cv = new ContentValues();
        cv.put("name", goods.getName());
        cv.put("images",JsonMananger.beanToJson(goods.getImages()));
        db.update(DatabaseHelper.TABLE_NAME,
                cv,
                "id = ?",
                new String[]{String.valueOf(6)});
    }

    public Goods queryById(){

        return null;
    }

    public List<Goods> queryAll(){
        List<Goods> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + DatabaseHelper.TABLE_NAME, null);
        while (cursor.moveToNext()){
            Goods goods = new Goods();
            goods.setId(cursor.getInt(cursor.getColumnIndex("id")));
            goods.setName(cursor.getString(cursor.getColumnIndex("name")));
            goods.setImages(JsonMananger.jsonToList(cursor.getString(cursor.getColumnIndex("images")),String.class));
            list.add(goods);
        }
        return list;
    }

}
