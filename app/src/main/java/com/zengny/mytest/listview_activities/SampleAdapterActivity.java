package com.zengny.mytest.listview_activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.zengny.mytest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 曾南勇
 * on 2016/11/26.
 */

public class SampleAdapterActivity extends Activity {

    private ListView mListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mListview = (ListView) findViewById(R.id.listview_sample);
        SimpleAdapter adapter = new SimpleAdapter(this,
                getData(),  //数据来源
                R.layout.item_listview, //对应item view
                new String[]{"img","title","info"}, //data 中对应值
                new int[]{R.id.img,R.id.title,R.id.info});  //填充layout位置
        mListview.setHeaderDividersEnabled(true);      //是否显示头view 的分割线
        View header = View.inflate(this,R.layout.listview_header,null);
        View footer = View.inflate(this,R.layout.listview_header,null);
        mListview.addHeaderView(header);    //添加头部view
        mListview.addFooterView(footer);     //添加底部view
        mListview.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    private List<? extends Map<String,?>> getData() {
        List<Map<String,Object>> items = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 5; i++) {
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("img",R.mipmap.ic_launcher);
            item.put("title","title -- " + i );
            item.put("info","info -- " + i );
            items.add(item);
        }
        return items;
    }
}
