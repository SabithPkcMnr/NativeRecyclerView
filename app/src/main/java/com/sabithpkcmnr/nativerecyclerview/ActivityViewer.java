package com.sabithpkcmnr.nativerecyclerview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityViewer extends AppCompatActivity {

    TextView itemTitle, itemDescription;
    String stringTitle, stringDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        stringTitle = getIntent().getStringExtra("title");
        stringDescription = getIntent().getStringExtra("description");

        itemTitle = findViewById(R.id.itemTitle);
        itemDescription = findViewById(R.id.itemDescription);

        itemTitle.setText(stringTitle);
        itemDescription.setText(stringDescription);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}