package com.nvtr.nhanviensqlite.vitri;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nvtr.nhanviensqlite.R;
import com.nvtr.nhanviensqlite.model.NhanVien_B18DCCN672;
import com.nvtr.nhanviensqlite.model.ViTri_B18DCCN672;

import java.util.ArrayList;


public class VTAdapter extends RecyclerView.Adapter<VTAdapter.ViewHolder> {

    private ArrayList<ViTri_B18DCCN672> listitems;
    private Context context;

    public VTAdapter(ArrayList<ViTri_B18DCCN672> items, Context context) {
        this.listitems = items;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.itemvt,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViTri_B18DCCN672 item = listitems.get(position);
        holder.tv_1.setText(item.getName());
        holder.tv_2.setText(item.getMota());

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_1 ,tv_2, tv_3, tv_4;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_1 = itemView.findViewById(R.id.tv1);
            tv_2 = itemView.findViewById(R.id.tv2);

        }
    }
}