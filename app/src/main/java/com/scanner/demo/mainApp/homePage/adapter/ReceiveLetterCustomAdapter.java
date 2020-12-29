package com.scanner.demo.mainApp.homePage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemLetterBinding;
import com.scanner.demo.mainApp.homePage.model.ListLetter;

import java.util.List;

public class ReceiveLetterCustomAdapter extends RecyclerView.Adapter<ReceiveLetterCustomAdapter.viewHolderReceiveLetter> {
    List<ListLetter> listReceive ;
    Context context;

    public ReceiveLetterCustomAdapter(java.util.List listReceive, Context context) {
        this.listReceive = listReceive;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolderReceiveLetter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemLetterBinding itemLetterBinding = DataBindingUtil.inflate(inflater, R.layout.item_letter,parent,false);
        return new viewHolderReceiveLetter(itemLetterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderReceiveLetter holder, int position) {
        holder.itemLetterBinding.setListReceiveLetter(listReceive.get(position));
    }

    @Override
    public int getItemCount() {
        return listReceive.size();
    }

    public static class viewHolderReceiveLetter extends RecyclerView.ViewHolder {
        ItemLetterBinding itemLetterBinding;
        public viewHolderReceiveLetter(@NonNull ItemLetterBinding itemView) {
            super(itemView.getRoot());
            this.itemLetterBinding = itemView;
        }
    }
}