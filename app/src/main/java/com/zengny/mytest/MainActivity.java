package com.zengny.mytest;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    ListView listview;
    private Resources res;
    private String[] titles;
    private String[] classNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        titles = res.getStringArray(R.array.classes_title);
        classNames = res.getStringArray(R.array.classes_name);

    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }

    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
        listview.setDivider(new ColorDrawable(Color.BLUE));
        listview.setDividerHeight(1);
        listview.setAdapter(new ArrayAdapter<String>(this,R.layout.item_arrayadapter,R.id.title,titles));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String className = classNames[i];
                String allName = MainActivity.this.getPackageName() + ".listview_activities." + className;
//                Log.e("zengny","allName>>" + allName);
                ComponentName componentName = new ComponentName(MainActivity.this.getPackageName(),allName);

                Intent mIntent = new Intent();
                mIntent.setClassName(MainActivity.this,allName);
//                mIntent.setComponent(componentName);
                startActivity(mIntent);
            }
        });
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
