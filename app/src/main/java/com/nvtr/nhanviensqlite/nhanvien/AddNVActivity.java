package com.nvtr.nhanviensqlite.nhanvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nvtr.nhanviensqlite.R;
import com.nvtr.nhanviensqlite.data.DataBaseHelper;
import com.nvtr.nhanviensqlite.model.NhanVien_B18DCCN672;

import java.util.ArrayList;
import java.util.List;

public class AddNVActivity extends AppCompatActivity {
    DataBaseHelper db;
    EditText ed1, ed2, ed3, ed4;
    Button bt1;
    private Spinner spinner;
    private List<String> list;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nvactivity);
        db = new DataBaseHelper(this);

        ed1 = findViewById(R.id.edit1);
        ed2 = findViewById(R.id.edit2);
        ed3 = findViewById(R.id.edit3);
        bt1 = findViewById(R.id.btn1);

        list = new ArrayList<>();
        list.add("Lập Trình Android");
        list.add("Lập Trình Java");
        list.add("Lập Trình JavaFX");
        spinner =  findViewById(R.id.spinner);
        msg = list.get(0);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);

        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 msg = list.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien_B18DCCN672 nv = new NhanVien_B18DCCN672();
                nv.setMa(db.getAllNV().size());
                nv.setName(ed1.getText().toString());
                nv.setQuequan(ed2.getText().toString());
                nv.setNamsinh(ed3.getText().toString());
                nv.setTrinhdo(msg);
                db.addNV(nv);
                finish();
            }
        });


    }
}