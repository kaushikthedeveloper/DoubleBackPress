package com.kaushikthedeveloper.doublebackpress.example.helpers;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kaushikthedeveloper.doublebackpress.example.R;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 08-03-2018.
 */
public class ExamplesListViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public TextView title;
    public TextView info;

    public ExamplesListViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.examples_cardview);
        title = itemView.findViewById(R.id.examples_title);
        info = itemView.findViewById(R.id.examples_info);
    }

}