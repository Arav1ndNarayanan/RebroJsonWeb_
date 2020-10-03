package com.example.rebrojsonweb_;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;
    View v;
    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, final int position) {
        ExampleItem currentItem = mExampleList.get(position);
        String id = currentItem.getId();
        final String name = currentItem.getfirstName();
        String gender = currentItem.getGender();
        String mail = currentItem.getmail();
        String phoneo = currentItem.getphoneO();
        String phoneh = currentItem.getphoneH();
        final String mobile = currentItem.getMobile();

        holder.Txid.setText("ID: " + id);
        holder.Txname.setText("NAME: " + name);
        holder.Txmail.setText("EMAIL: " + mail);
        holder.Txgender.setText("GENDER: " + gender);
        holder.TxphoneH.setText("OFFICE: " + phoneh);
        holder.TxphoneO.setText("HOME: " + phoneo);
       // holder.Txmobile.setText("MOBILE: " + mobile);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "MOBILE: "+mobile , Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView Txid;
        public TextView Txname;
        public TextView Txmail;
        public TextView Txgender;
        public TextView TxphoneO;
        public TextView TxphoneH;
        public TextView Txmobile;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            Txid = itemView.findViewById(R.id.TXid);
            Txname = itemView.findViewById(R.id.TXname);
            Txgender = itemView.findViewById(R.id.TXgender);
            Txmail = itemView.findViewById(R.id.TXmail);
            TxphoneH = itemView.findViewById(R.id.TXphoneH);
            TxphoneO = itemView.findViewById(R.id.TXphoneO);
           // Txmobile = itemView.findViewById(R.id.TXmobile);
        }
    }
}