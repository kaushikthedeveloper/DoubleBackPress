package com.kaushikthedeveloper.doublebackpress.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kaushikthedeveloper.doublebackpress.example.helpers.ExamplesListAdapter;
import com.kaushikthedeveloper.doublebackpress.example.helpers.ExamplesListData;
import com.kaushikthedeveloper.doublebackpress.example.helpers.RecyclerClickSupport;

import java.util.ArrayList;
import java.util.List;

public class ExamplesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        setupAdapterData();
        setupOnListClicked();
    }

    /**
     * Update the data onto Adapter
     */
    public void setupAdapterData() {
        List<ExamplesListData> examplesData = fillData();

        // specify an adapter
        RecyclerView.Adapter mAdapter = new ExamplesListAdapter(examplesData, this);
        mRecyclerView.setAdapter(mAdapter);
    }


    /**
     * Fill the data to be shown in the Recycler view
     *
     * @return List<ExamplesListData>
     */
    public List<ExamplesListData> fillData() {
        List<ExamplesListData> data = new ArrayList<>();

        String[] titles = getResources().getStringArray(R.array.example_list_titles);
        String[] infos = getResources().getStringArray(R.array.example_list_infos);

        for (int i = 0; i < titles.length; i++) {
            data.add(new ExamplesListData(titles[i], infos[i]));
        }

        return data;
    }

    /**
     * On Click of card, open the corresponding Activity
     */
    public void setupOnListClicked() {
        RecyclerClickSupport.addTo(mRecyclerView).setOnItemClickListener(new RecyclerClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(ExamplesActivity.this, SimplestProgramActivity.class);
                        break;
                    case 1:
                        intent = new Intent(ExamplesActivity.this, ToastDisplayActivity.class);
                        break;
                    case 2:
                        intent = new Intent(ExamplesActivity.this, SnackbarDisplayActivity.class);
                        break;
                }
                ExamplesActivity.this.startActivity(intent);
            }
        });
    }

}