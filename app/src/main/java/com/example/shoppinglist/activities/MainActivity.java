package com.example.shoppinglist.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppinglist.R;
import com.example.shoppinglist.adapters.ProductAdapter;

public class MainActivity extends Activity {

    private EditText addTaskEditText;
    private RecyclerView recyclerView;
    private Button submitButton;
    private Button deleteAllButton;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        addTaskEditText = findViewById(R.id.add_product_edit_text);
        recyclerView = findViewById(R.id.my_recycler_view);
        submitButton = findViewById(R.id.bSubmit);
        deleteAllButton = findViewById(R.id.bDeleteAll);

        productAdapter = new ProductAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);
        submitButton.setOnClickListener(this::onSubmitClickListener);
        deleteAllButton.setOnClickListener(this::onDeleteAllButtonClickListener);
    }

    private void onSubmitClickListener(View v) {
        String productName = addTaskEditText.getText().toString();
        addTaskEditText.setText("");

        productAdapter.add(productName);
    }

    private void onDeleteAllButtonClickListener(View v) {
        productAdapter.deleteAll();
    }
}
