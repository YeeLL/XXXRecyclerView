package com.jph.xxxrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.xxxrecylcerview.XXXRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试界面
 * Created by jph on 2016/4/20.
 */
public class MainActivity extends AppCompatActivity {

    private MyAdapter mMyAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final XXXRecyclerView recyclerView = (XXXRecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLoadMoreView(View.inflate(this, R.layout.layout_load_more, null));
        mMyAdapter = new MyAdapter(generateData(0, 20));
        recyclerView.setAdapter(mMyAdapter);
        recyclerView.setOnLoadMoreListener(new XXXRecyclerView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mMyAdapter.addList(generateData(mMyAdapter.getRealItemCount(), 20));
                recyclerView.stopLoadMore();
            }
        });
    }

    private List<String> generateData(int beginIndex, int count) {
        List<String> list = new ArrayList<>();
        for (int i = beginIndex; i < beginIndex + count; i++) {
            list.add("XXX : " + i);
        }
        return list;
    }
}
