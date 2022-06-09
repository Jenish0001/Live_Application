package com.example.live_dataa_applicationsecod.Controller;


import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.live_dataa_applicationsecod.MainActivity;
import com.example.live_dataa_applicationsecod.Modelclass.Model_class;
import com.example.live_dataa_applicationsecod.R;

import java.util.ArrayList;
import java.util.List;

public class My_Rv_Adpter extends RecyclerView.Adapter<My_Rv_Adpter.ViewData> {
    Activity activity;
    List<Model_class> l1;

    public My_Rv_Adpter(MainActivity mainActivity, List<Model_class> l1) {
        activity = mainActivity;
        this.l1 = l1;

    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.recycle_view, parent, false);

        return new ViewData(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ViewData holder, int position) {


        holder.amount_rv_view.setText(l1.get(position).getAmount());
        holder.stats_rv_view.setText(l1.get(position).getStats());
        holder.data_rv_view.setText(l1.get(position).getData());

        if(l1.get(position).getStats().equals("Income"))
        {
            holder.amount_rv_view.setTextColor(activity.getColor(R.color.green));
            holder.stats_rv_view.setTextColor(activity.getColor(R.color.green));
            holder.data_rv_view.setTextColor(activity.getColor(R.color.green));

        }
        else
        {
            holder.amount_rv_view.setTextColor(activity.getColor(R.color.red));
            holder.stats_rv_view.setTextColor(activity.getColor(R.color.red));
            holder.data_rv_view.setTextColor(activity.getColor(R.color.red));

        }

    }

    @Override
    public int getItemCount() {
        return l1.size();
    }

    class ViewData extends RecyclerView.ViewHolder {

        private final TextView amount_rv_view;
        private final TextView stats_rv_view;
        private final TextView data_rv_view;


        public ViewData(@NonNull View itemView) {

            super(itemView);

            amount_rv_view = itemView.findViewById(R.id.amount_rv_view);
            stats_rv_view = itemView.findViewById(R.id.stats_rv_view);
            data_rv_view = itemView.findViewById(R.id.data_rv_view);

        }
    }

}
