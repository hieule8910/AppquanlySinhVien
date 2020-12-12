package com.example.asm_ps09981_qlsv.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asm_ps09981_qlsv.AddClassActivity;
import com.example.asm_ps09981_qlsv.R;
import com.example.asm_ps09981_qlsv.SinhVienInsert1;
import com.example.asm_ps09981_qlsv.dao.LopDAO;
import com.example.asm_ps09981_qlsv.model.Lop;
import com.example.asm_ps09981_qlsv.model.SinhVien;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    ArrayList<SinhVien> data;
    //List<Lop> arrLop;
    Context context;
    //public LayoutInflater inflater;
   // LopDAO lopDAO;
    DateFormatSymbols value;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public SinhVienAdapter(Context context, ArrayList<SinhVien> data) {
        super();
       // this.arrLop = arrLop;
        this.context = context;
        this.data=data;
       // this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // lopDAO = new LopDAO(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

//    public static class ViewHolder {
//        TextView tvTenSv;
//        TextView tvNgaySinh;
//        TextView tvLopFK;
//        ImageView ivDel;
//        ImageView ivAva;
//        ImageView ivEdit;
//
//    }

    class ViewHolder {
        TextView tvTenSv;
        TextView tvNgaySinh;
        TextView tvLopFK;
        ImageView ivDel;
        ImageView ivAva;
        ImageView ivEdit;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.sinhvien_item, null);
            holder.ivEdit = convertView.findViewById(R.id.ivEdit);
            holder.ivDel = convertView.findViewById(R.id.ivDel);
            holder.tvTenSv = convertView.findViewById(R.id.tvTenSv);
            holder.tvNgaySinh = convertView.findViewById(R.id.tvNgaySinh);
            holder.tvLopFK = convertView.findViewById(R.id.tvLopHocFK);
            holder.ivAva =convertView.findViewById(R.id.ivAvatar);
            convertView.setTag(holder);
        }else{
           // holder = (SinhvienAdapter.ViewHolder) convertView.getTag();
            holder = (ViewHolder)convertView.getTag();
        }
        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SinhVienInsert1.class);
                i.putExtra("sinhvien", data.get(position));
                ((Activity)context).startActivity(i);
            }
        });
        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SinhVienInsert1.class);
                i.putExtra("sinhvien",data.remove(position));
                notifyDataSetChanged();
            }
        });

        String tenHinh = data.get(position).getHinh();
        int resImg = context.getResources().getIdentifier(tenHinh,"drawable",context.getPackageName());
        holder.ivAva.setImageResource(resImg);
        holder.tvTenSv.setText(data.get(position).getTenSv());
        holder.tvNgaySinh.setText(sdf.format(data.get(position).getNgaySinh()));
        holder.tvLopFK.setText(data.get(position).getMaLopHoc());
        return convertView;
    }



//    @Override
//    public void notifyDataSetChanged() {
//        super.notifyDataSetChanged();
//    }
}

