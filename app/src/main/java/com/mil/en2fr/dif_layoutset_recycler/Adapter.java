package com.mil.en2fr.dif_layoutset_recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter{
    ArrayList<DataModel> list;

    public Adapter(ArrayList<DataModel> list1) {
        this.list=list1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_1,parent,false);
                return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        DataModel model=list.get(position);
        ViewHolder1 holder1= (ViewHolder1) holder;
        if (position %2==0){
                holder1.checkBox.setText(model.getText());
                holder1.radioButton.setVisibility(View.GONE);
        }else{
            holder1.radioButton.setText(model.getText());
            holder1.checkBox.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder1 extends RecyclerView.ViewHolder {
        private CheckBox checkBox;
        private RadioButton radioButton;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.checkbox);
            radioButton=itemView.findViewById(R.id.radio);
        }
    }
}
