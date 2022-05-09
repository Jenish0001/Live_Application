package com.example.live_dataa_applicationsecod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.live_dataa_applicationsecod.Controller.My_Rv_Adpter;
import com.example.live_dataa_applicationsecod.Modelclass.Model_class;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView filter;
    private RecyclerView rv_view;
    private Button add_btn;
    String stats, radio;

    List<Model_class> l1 = new ArrayList<>();
    List<Model_class> mData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blinding();

        // Recycle view
        rv_fun(l1);

        //show dialog

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                add_data_dialog();

            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                filter_dialog();
//                rv_fun(mData);
            }
        });
    }


    private void blinding() {
        filter = findViewById(R.id.filter);
        rv_view = findViewById(R.id.rv_view);
        add_btn = findViewById(R.id.add_btn);
    }

    void add_data_dialog() {

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.item_dialog);
        dialog.setCancelable(false);
        dialog.show();


        EditText amount_edt = dialog.findViewById(R.id.amount_edt);
        RadioGroup rg_btn = dialog.findViewById(R.id.rg_btn);
        RadioButton rb_income_btn = dialog.findViewById(R.id.rb_income_btn);
        RadioButton rb_expense_btn = dialog.findViewById(R.id.rb_expense_btn);
        EditText data_edt = dialog.findViewById(R.id.data_edt);
        Button cus_add_btn = dialog.findViewById(R.id.cus_add_btn);

        cus_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String amount = amount_edt.getText().toString();
                String data = data_edt.getText().toString();
                String stats;

                if (rg_btn.getCheckedRadioButtonId() == R.id.rb_income_btn) {
                    stats = "Income";

                } else {
                    stats = "Expense";
                }
//                Toast.makeText(MainActivity.this, "" + amount + "\n" + stats + "\n" + data, Toast.LENGTH_SHORT).show();


                Model_class model_class = new Model_class(amount, stats, data);
                l1.add(model_class);
                rv_fun(l1);
                dialog.dismiss();

            }

        }   );


    }


    void rv_fun(List<Model_class> list) {

        My_Rv_Adpter adpter = new My_Rv_Adpter(MainActivity.this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rv_view.setLayoutManager(layoutManager);
        rv_view.setAdapter(adpter);

    }

    void filter_dialog() {

        Dialog d1 = new Dialog(MainActivity.this);
        d1.setContentView(R.layout.item_filter);
        Button filter_View_btn = d1.findViewById(R.id.filter_View_btn);
        RadioGroup rd_RG_btn = d1.findViewById(R.id.rd_RG_btn);
        RadioButton rd_income = d1.findViewById(R.id.rd_income);
        RadioButton rd_expense = d1.findViewById(R.id.rd_expense);

//        d1.setCancelable(false);
        d1.show();

//
        filter_View_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rd_RG_btn.getCheckedRadioButtonId() == R.id.rd_income) {
                    radio = "Income";
                } else if (rd_RG_btn.getCheckedRadioButtonId() == R.id.rd_expense) {
                    radio = "Expense" ;
                }


                filterData(radio);
                d1.dismiss();
                Toast.makeText(MainActivity.this, "" + stats, Toast.LENGTH_SHORT).show();
            }
        });
    }

    void filterData(String radio) {

        List<Model_class> filterList = l1;
        mData.clear();

        for (int i = 0; i < filterList.size(); i++) {
            if (filterList.get(i).getStats().equals(radio)) {
                mData.add(filterList.get(i));
            }

        }

//        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
        rv_fun(mData);
    }

}