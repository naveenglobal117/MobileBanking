package com.imobilepoc.recyclview;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.imobilepoc.R;

import java.util.ArrayList;


class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.MyViewHolder> {
    private ArrayList<DummyParentDataItem> dummyParentDataItems;

    RecyclerDataAdapter(ArrayList<DummyParentDataItem> dummyParentDataItems) {
        this.dummyParentDataItems = dummyParentDataItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent_child_listing, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DummyParentDataItem dummyParentDataItem = dummyParentDataItems.get(position);
        holder.textView_parentName.setText(dummyParentDataItem.getParentName());
        holder.submessage.setText(dummyParentDataItem.getSub());
        holder.ic_transection.setImageResource(dummyParentDataItem.getRec());
        //
        int noOfChildTextViews = holder.linearLayout_childItems.getChildCount();
        for (int index = 0; index < noOfChildTextViews; index++) {
            LinearLayout currentTextView = (LinearLayout) holder.linearLayout_childItems.getChildAt(index);
            currentTextView.setVisibility(View.VISIBLE);

            if(position==0){
                currentTextView.findViewById(R.id.view1).setVisibility(View.VISIBLE);
                currentTextView.findViewById(R.id.view2).setVisibility(View.GONE);
            }else if(position==1){
                currentTextView.findViewById(R.id.view1).setVisibility(View.GONE);
                currentTextView.findViewById(R.id.view2).setVisibility(View.VISIBLE);
            }else {
                currentTextView.findViewById(R.id.view1).setVisibility(View.VISIBLE);
                currentTextView.findViewById(R.id.view2).setVisibility(View.GONE);
            }
        }

        int noOfChild = dummyParentDataItem.getChildDataItems().size();
        if (noOfChild < noOfChildTextViews) {
            for (int index = noOfChild; index < noOfChildTextViews; index++) {
                LinearLayout currentTextView = (LinearLayout) holder.linearLayout_childItems.getChildAt(index);
                currentTextView.setVisibility(View.GONE);
            }
        }
        for (int textViewIndex = 0; textViewIndex < noOfChild; textViewIndex++) {
            LinearLayout currentTextView = (LinearLayout) holder.linearLayout_childItems.getChildAt(textViewIndex);
            // currentTextView.setText(dummyParentDataItem.getChildDataItems().get(textViewIndex).getChildName());
                /*currentTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "" + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });*/
        }
    }

    @Override
    public int getItemCount() {
        return dummyParentDataItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Context context;
        private TextView submessage, textView_parentName;
        private LinearLayout linearLayout_childItems;
        private ImageView ic_transection, downarrow;

        MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView_parentName = itemView.findViewById(R.id.txt_transection);
            submessage = itemView.findViewById(R.id.submessage);
            downarrow = itemView.findViewById(R.id.downarrow);
            ic_transection = itemView.findViewById(R.id.ic_transection);
            linearLayout_childItems = itemView.findViewById(R.id.ll_child_items);
            linearLayout_childItems.setVisibility(View.GONE);
            int intMaxNoOfChild = 0;
            for (int index = 0; index < dummyParentDataItems.size(); index++) {
                int intMaxSizeTemp = dummyParentDataItems.get(index).getChildDataItems().size();
                if (intMaxSizeTemp > intMaxNoOfChild) intMaxNoOfChild = intMaxSizeTemp;
            }
             for (int indexView = 0; indexView < intMaxNoOfChild; indexView++) {
                 addLayout(context,linearLayout_childItems);

             }
            textView_parentName.setOnClickListener(this);
            downarrow.setOnClickListener(this);
            ic_transection.setOnClickListener(this);
            submessage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.txt_transection || view.getId() == R.id.submessage || view.getId() == R.id.ic_transection || view.getId() == R.id.downarrow) {
                if (linearLayout_childItems.getVisibility() == View.VISIBLE) {
                    linearLayout_childItems.setVisibility(View.GONE);
                    downarrow.setImageResource(R.drawable.ic_down_arrow);
                } else {
                    linearLayout_childItems.setVisibility(View.VISIBLE);
                    downarrow.setImageResource(R.drawable.ic_up_chevron);
                }
            } else {
                TextView textViewClicked = (TextView) view;
                Toast.makeText(context, "" + textViewClicked.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        }


        private void addLayout(Context context, LinearLayout linearLayout) {
            View layout2 = LayoutInflater.from(context).inflate(R.layout.item2_view, linearLayout, false);
            linearLayout.addView(layout2);


        }
    }
}