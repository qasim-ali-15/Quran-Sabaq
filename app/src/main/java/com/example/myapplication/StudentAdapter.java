package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.data.MyDbHandler;
import com.example.myapplication.model.QuranTable;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    List<QuranTable> students;
    Context context;
    MyDbHandler myDbHandler;

    public StudentAdapter(List<QuranTable> students, Context context) {
        this.students = students;
        this.context = context;
        myDbHandler = new MyDbHandler(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.student_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final QuranTable quranTable = students.get(position);

        holder.textViewID.setText(Integer.toString(quranTable.getId()));
        holder.editText_name.setText(quranTable.getName());
        holder.editText_sabaq.setText(quranTable.getSabaq());
        holder.editText_sabaqi.setText(quranTable.getSabaqi());
        holder.editText_manzil.setText(quranTable.getManzil());

//        holder.button_edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewID;
        EditText editText_name;
        EditText editText_sabaq;
        EditText editText_sabaqi;
        EditText editText_manzil;
        Button button_edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.text_id);
            editText_name = itemView.findViewById(R.id.edittext_name);
            editText_sabaq = itemView.findViewById(R.id.edittext_sabaq);
            editText_sabaqi = itemView.findViewById(R.id.edittext_sabaqi);
            editText_manzil = itemView.findViewById(R.id.edittext_manzil);
            button_edit = itemView.findViewById(R.id.button_edit);
            button_delete = itemView.findViewById(R.id.button_delete);

        }
    }
}
