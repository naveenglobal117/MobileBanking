package com.imobilepoc.recyclview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.imobilepoc.R;

import java.util.ArrayList;

public class DynamicRecyclerActivity extends Activity {
    private RecyclerView mRecyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_recycler);
        mContext = DynamicRecyclerActivity.this;
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerDataAdapter recyclerDataAdapter = new RecyclerDataAdapter(getDummyDataToPass());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(recyclerDataAdapter);
        mRecyclerView.setHasFixedSize(true);
    }

    private ArrayList<DummyParentDataItem> getDummyDataToPass() {
        ArrayList<DummyParentDataItem> arrDummyData = new ArrayList<>();
        ArrayList<DummyChildDataItem> childDataItems;
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("A Child 1"));
        childDataItems.add(new DummyChildDataItem("A Child 2"));
        childDataItems.add(new DummyChildDataItem("A Child 3"));
        arrDummyData.add(new DummyParentDataItem("Transactions", R.drawable.ic_transaction,"View your last transactions",childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("B Child 1"));
        arrDummyData.add(new DummyParentDataItem("Quick Balance",R.drawable.ic_save_money,"View your balance" ,childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("C Child 1"));
        childDataItems.add(new DummyChildDataItem("C Child 2"));
        arrDummyData.add(new DummyParentDataItem("Locate Us",R.drawable.ic_pin,"Find your nearest branch and atm", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("D Child 1"));
        childDataItems.add(new DummyChildDataItem("D Child 2"));
        arrDummyData.add(new DummyParentDataItem("Bill Payments",R.drawable.ic_invoice,"Bill payment history", childDataItems));
        /////////

        ////////
        return arrDummyData;
    }
}
