package com.kaushikthedeveloper.doublebackpress.example.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaushikthedeveloper.doublebackpress.example.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 03-03-2018.
 */
public class ExamplesListAdapter extends RecyclerView.Adapter<ExamplesListViewHolder>{
    // Provide a reference to the views for each data item
    List<ExamplesListData> list = Collections.emptyList();
    Context context;

    public ExamplesListAdapter(List<ExamplesListData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //Inflate the layout, initialize the View Holder
    @Override
    public ExamplesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_example_cardview, parent, false);
        ExamplesListViewHolder holder = new ExamplesListViewHolder(view);
        return holder;
    }

    /**
     * Map CardView to respective RecyclerView
     * Use the provided View Holder on the onCreateViewHolder method to
     * populate the current row on the RecyclerView
     */
    @Override
    public void onBindViewHolder(@NonNull ExamplesListViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.info.setText(list.get(position).getInfo());
    }

    /**
     * @return the number of elements the RecyclerView will display
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}