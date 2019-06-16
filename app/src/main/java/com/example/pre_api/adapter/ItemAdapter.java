package com.example.pre_api.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.pre_api.R;
import com.example.pre_api.databinding.ItemUserBinding;
import com.example.pre_api.model.Name;
import com.example.pre_api.model.User;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> users;
    ItemUserBinding binding;

    private List<Name> nama;

    public ItemAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = DataBindingUtil.inflate(LayoutInflater
                        .from(viewGroup.getContext()), R.layout.item_user, viewGroup,
                false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ItemViewHolder itemView = (ItemViewHolder) viewHolder;
        itemView.bind((users.get(i).getName()));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
//
//    public void add(Name item) {
//        nama.add(item);
//        notifyItemInserted(users.size()-1);
//    }


}
