package com.example.asm_ps09981_qlsv.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.asm_ps09981_qlsv.AddClassActivity;
import com.example.asm_ps09981_qlsv.EditClassActivity;
import com.example.asm_ps09981_qlsv.R;
import com.example.asm_ps09981_qlsv.dao.LopDAO;
import com.example.asm_ps09981_qlsv.model.Lop;

import java.util.ArrayList;

public class LopAdapter extends BaseAdapter {
    ArrayList<Lop> data;
    Context context;
    //    public LayoutInflater inflater;
    LopDAO lopDAO;

    public LopAdapter(Context context, ArrayList<Lop> data) {
//        super();
//        this.arrLop = arrLop;
        this.context = context;
        this.data = data;
        lopDAO = new LopDAO(context);
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

    class ViewHolder {
        TextView tvMalop;
        TextView tvtenLop;
        ImageView imgDelete;
        ImageView imgEdit;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_sach, null);
            holder.imgEdit = convertView.findViewById(R.id.ivEdit);
            holder.tvMalop = convertView.findViewById(R.id.tvMalop);
            holder.tvtenLop = convertView.findViewById(R.id.tvTenlop);
            holder.imgDelete = convertView.findViewById(R.id.imgDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //sua du lieu hien tai
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddClassActivity.class);
                i.putExtra("lophoc",data.get(position));
                ((Activity)context).startActivity(i);
                Toast.makeText(context, "đã click sửa", Toast.LENGTH_SHORT).show();

            }
        });

       // xoa du lieu hien tai
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, EditClassActivity.class);
                i.putExtra("lophoc",data.remove(position));
                notifyDataSetChanged();
                Toast.makeText(context, "đã xóa", Toast.LENGTH_SHORT).show();
            }
        });

//        Lop _entry = (Lop) data.get(position);
        holder.tvMalop.setText(data.get(position).getMalop());
        holder.tvtenLop.setText(data.get(position).getTenlop());
        return convertView;

    }
        @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}






//        public boolean update(String ma,String tenlop){
//            SQLiteDatabase db=helper.getWritableDatabase();
//            ContentValues values= new ContentValues();
//            values.put("Tenlop",tenlop);
//            int row=db.update("LOP",values,"Malop=?",new String[]{ma});
//            return row>0;
//        }



//        public boolean delete(String ma) {
//            SQLiteDatabase db = helper.getWritableDatabase();
//            ContentValues values = new ContentValues();
//
//            int row = db.delete("LOP", "MaLop=?", new String[]{ma});
//            if (row > 0) {
//                return true;
//
//            } else {
//                return false;
//            }
//        }





//
//        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    lopDAO.deleteLop(data.get(position).getMalop());
//                    data.remove(position);
//                    notifyDataSetChanged();
//                }
//            });
//            holder.imgEdit.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                   Intent intent = new Intent(context,);
////                    intent.putExtra("lophoc",lop);
//                }
//            });

//    @Override
//    public void notifyDataSetChanged() {
//        super.notifyDataSetChanged();
//    }

