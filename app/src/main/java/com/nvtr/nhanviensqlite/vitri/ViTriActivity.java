package com.nvtr.nhanviensqlite.vitri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nvtr.nhanviensqlite.R;
import com.nvtr.nhanviensqlite.data.DataBaseHelper;
import com.nvtr.nhanviensqlite.model.NhanVien_B18DCCN672;
import com.nvtr.nhanviensqlite.model.ViTri_B18DCCN672;
import com.nvtr.nhanviensqlite.nhanvien.AddNVActivity;
import com.nvtr.nhanviensqlite.nhanvien.NVAdapter;
import com.nvtr.nhanviensqlite.nhanvien.NhanVienActivity;

import java.util.ArrayList;

public class ViTriActivity extends AppCompatActivity {
    Button bt1;
    RecyclerView rcv;
    DataBaseHelper dataBaseHelper;
    ArrayList<ViTri_B18DCCN672> arr = new ArrayList<>();
    VTAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi_tri);
        bt1 = findViewById(R.id.btn1);
        rcv = findViewById(R.id.rcv);
        dataBaseHelper = new DataBaseHelper(this);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViTriActivity.this, AddViTriActivity.class));
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        arr.clear();
        arr.addAll(dataBaseHelper.getAllVt());
        adapter = new VTAdapter(arr, this);
        rcv.setLayoutManager( new LinearLayoutManager(this));
        rcv.setAdapter(adapter);
    }
}