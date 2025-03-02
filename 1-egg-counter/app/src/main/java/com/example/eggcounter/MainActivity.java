package com.example.eggcounter;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView iv_egg;
    private TextView tv_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        addListeners();
    }

    private void initViews() {
        iv_egg = findViewById(R.id.iv_egg);
        tv_counter = findViewById(R.id.tv_counter);
    }

    private void addListeners() {
        iv_egg.setOnClickListener(v -> incrementCounter());
    }

    private void incrementCounter() {
        int counter = Integer.parseInt(tv_counter.getText().toString()) + 1;
        tv_counter.setText(String.valueOf(counter));
    }
}