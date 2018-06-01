package com.xunevermore.timelinedecor;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BaseQuickAdapter<String,BaseViewHolder> adapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_transport,
                Arrays.asList(getResources().getStringArray(R.array.transport_list))) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                TextView tvDescribe = helper.getView(R.id.tv_describe);
                TextView tvTime = helper.getView(R.id.tv_time);
                tvDescribe.setText(item);
                tvTime.setText("2018-06-01 12:00");

                int position = helper.getAdapterPosition();
                tvDescribe.setTextColor(position==0?0xff4caf65:0xff999999);
                tvTime.setTextColor(position==0?0xff4caf65:0xff999999);

            }
        };

        recyclerView.addItemDecoration(new TimelineDecoration(getDimen(R.dimen.time_line_width),
                getDimen(R.dimen.time_line_top),
                ContextCompat.getDrawable(this,R.drawable.ic_check_circle),
                getDimen(R.dimen.time_going_size),
                1));
        recyclerView.setAdapter(adapter);

    }

    private int getDimen(int dimeRes){
        return (int) getResources().getDimension(dimeRes);
    }


}
