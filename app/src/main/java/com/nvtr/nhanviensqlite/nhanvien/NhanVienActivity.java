package com.nvtr.nhanviensqlite.nhanvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.nvtr.nhanviensqlite.MainActivity;
import com.nvtr.nhanviensqlite.R;
import com.nvtr.nhanviensqlite.data.DataBaseHelper;
import com.nvtr.nhanviensqlite.model.NhanVien_B18DCCN672;

import java.util.ArrayList;
import java.util.List;

public class NhanVienActivity extends AppCompatActivity {
    Button bt1;
    RecyclerView rcv;
    DataBaseHelper dataBaseHelper;
    ArrayList<NhanVien_B18DCCN672> arr ;
    NVAdapter nvAdapter;
    private Spinner spinner;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);
        bt1 = findViewById(R.id.btn1);
        rcv = findViewById(R.id.rcv);
        dataBaseHelper = new DataBaseHelper(this);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NhanVienActivity.this, AddNVActivity.class));
            }
        });



    }


    @Override
    protected void onStart() {
        super.onStart();
        arr = new ArrayList<>();
        arr.clear();
        arr.addAll(dataBaseHelper.getAllNV());
        nvAdapter = new NVAdapter(arr, this);
        rcv.setLayoutManager( new LinearLayoutManager(this));
        rcv.setAdapter(nvAdapter);
    }
}