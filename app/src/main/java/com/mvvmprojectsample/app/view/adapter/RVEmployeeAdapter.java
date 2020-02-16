package com.mvvmprojectsample.app.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvmprojectsample.app.R;
import com.mvvmprojectsample.app.databinding.RecyclerViewItemBinding;
import com.mvvmprojectsample.app.model.webService.employee.Employee;
import com.mvvmprojectsample.app.view.ui.SampleActivity;

import java.util.List;

public class RVEmployeeAdapter extends RecyclerView.Adapter<RVEmployeeAdapter.RVEmployeeViewHolder> {

    private List<Employee> list;

    @NonNull
    @Override
    public RVEmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewItemBinding itemBinding =
                DataBindingUtil
                        .inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_view_item, parent, false);
        return new RVEmployeeViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final RVEmployeeViewHolder holder, int position) {
        Employee employee = list.get(position);
        holder.recyclerViewItemBinding.setEmployee(employee);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.recyclerViewItemBinding.imgAvatar.getContext();
                context.startActivity(new Intent(context, SampleActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void updateList(List<Employee> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    class RVEmployeeViewHolder extends RecyclerView.ViewHolder {
        private RecyclerViewItemBinding recyclerViewItemBinding;

        public RVEmployeeViewHolder(@NonNull RecyclerViewItemBinding recyclerViewItemBinding) {
            super(recyclerViewItemBinding.getRoot());
            this.recyclerViewItemBinding = recyclerViewItemBinding;
        }
    }
}
