package umn.ac.id.uas.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BuildPcActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_pc);

        TextView processorButton = findViewById(R.id.processor);
        processorButton.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), PickProcessorActivity.class));
        });
    }
}