package com.zengny.mytest.listview_activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zengny.mytest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 曾南勇
 * on 2016/11/26.
 */

public class CustomizeAdapterActivity extends Activity {
    private ListView mListview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
    }

    private void initView() {
        mListview = (ListView) findViewById(R.id.listview_sample);
        MyAdapter myAdapter = new MyAdapter(CustomizeAdapterActivity.this,getData());
        mListview.setDivider(new ColorDrawable(Color.BLUE));
        mListview.setDividerHeight(1);
        mListview.setAdapter(myAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }
    private List<Map<String,Object>> getData() {
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
class MyAdapter extends BaseAdapter{
    private List<Map<String,Object>> data;
    private LayoutInflater mInflater;
    private Context mContext;
    public MyAdapter(Context context,List<Map<String,Object>> list) {
        mContext = context;
        data = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder mHolder = null;
        if (view == null) {
            mHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.item_listview,null);
            mHolder.img = (ImageView) view.findViewById(R.id.img);
            mHolder.title = (TextView) view.findViewById(R.id.title);
            mHolder.info = (TextView) view.findViewById(R.id.info);
            view.setTag(mHolder);
        }else {
            mHolder = (ViewHolder) view.getTag();
        }
        mHolder.img.setBackgroundResource((Integer) data.get(i).get("img"));
        mHolder.title.setText((String) data.get(i).get("title"));
        mHolder.info.setText((String) data.get(i).get("info"));
        return view;
    }
}
class ViewHolder{
    ImageView img;
    TextView title;
    TextView info;
}