package com.example.pre_api.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.pre_api.databinding.ItemUserBinding;
import com.example.pre_api.model.Name;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    //define file java binding kita dulu. Binding = untuk menampilkan view
    private ItemUserBinding binding;

    public ItemViewHolder(@NonNull ItemUserBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Name nama) {
        binding.setName(nama);
    }
}
