package com.nvtr.nhanviensqlite.vitri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.nvtr.nhanviensqlite.R;
import com.nvtr.nhanviensqlite.data.DataBaseHelper;
import com.nvtr.nhanviensqlite.model.NhanVien_B18DCCN672;
import com.nvtr.nhanviensqlite.model.ViTri_B18DCCN672;

import java.util.ArrayList;
import java.util.List;

public class AddViTriActivity extends AppCompatActivity {
    DataBaseHelper db;
    EditText ed1, ed2;
    Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vi_tri);
        db = new DataBaseHelper(this);

        ed1 = findViewById(R.id.edit1);
        ed2 = findViewById(R.id.edit2);
        bt1 = findViewById(R.id.btn1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViTri_B18DCCN672 it = new ViTri_B18DCCN672();
                it.setName(ed1.getText().toString());
                it.setMota(ed2.getText().toString());
                db.addVt(it);
                finish();
            }
        });
    }
}