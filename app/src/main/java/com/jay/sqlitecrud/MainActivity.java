package com.jay.sqlitecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.jay.sqlitecrud.adapter.GoodsAdapter;
import com.jay.sqlitecrud.db.DBUtils;
import com.jay.sqlitecrud.model.Goods;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText et_goods_name;
    private EditText et_goods_images;
    private List<Goods> data = new ArrayList<>();
    private ListView lv_goods;
    private GoodsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setEvent();
    }

    private void setEvent() {
        adapter = new GoodsAdapter(data);
        lv_goods.setAdapter(adapter);
    }

    private void findViews() {
        et_goods_name = (EditText) findViewById(R.id.et_goods_name);
        et_goods_images = (EditText) findViewById(R.id.et_goods_images);
        lv_goods = (ListView) findViewById(R.id.list);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_add:
                add();
                break;
            case R.id.btn_delete:
                delete();
                break;
            case R.id.btn_update:
                update();
                break;
            case R.id.btn_query:
                queryAll();
                break;
        }
    }

    private void queryAll() {
        DBUtils.getInstance(this).queryAll();
    }

    private void update() {
        Goods goods = new Goods();
        goods.setName(et_goods_name.getText().toString());
        List<String> images = new ArrayList<String>();
        images.add(et_goods_images.getText().toString());
        goods.setImages(images);

        DBUtils.getInstance(this).update(goods);
    }

    private void delete() {
        DBUtils.getInstance(this).delete(et_goods_name.getText().toString());
    }

    private void add() {
        Goods goods = new Goods();
        goods.setName(et_goods_name.getText().toString());
        List<String> images = new ArrayList<String>();
        images.add(et_goods_images.getText().toString());
        goods.setImages(images);

        DBUtils.getInstance(this).add(goods);
    }
}
