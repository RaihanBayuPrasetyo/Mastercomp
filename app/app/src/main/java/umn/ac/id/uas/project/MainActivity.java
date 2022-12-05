package umn.ac.id.uas.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import umn.ac.id.uas.project.model.TopSpecification;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView profileIcon = findViewById(R.id.profile_icon);
        ConstraintLayout zeusTopSpecification = findViewById(R.id.zeus_300_x_top_specification);
        ConstraintLayout haff700EvoTopSpecification = findViewById(R.id.haff_700_evo_top_specification);

        ConstraintLayout buildContainer = findViewById(R.id.build_container);
        buildContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BuildPcActivity.class));
            }
        });

        profileIcon.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        });

        ConstraintLayout navPackage = findViewById(R.id.nav_package);
        navPackage.setOnClickListener(v -> {
            startActivity(new Intent(this, PackageActivity.class));
        });

        zeusTopSpecification.setOnClickListener(v -> {
            TopSpecification pc = new TopSpecification("Zeus 300 X", "Intel Core i9-12900F (Gen 12 Intel)", "Gigabyte B660M DS3H DDR4", "Jonsbo CR1200 RGB CPU Cooler", "16GB(2x8GB) DDR4 3200Mhz RGB", "Nvidia RTX 4090 24GB", R.drawable.zeus_300_x_computer);

            Intent intent = new Intent(this, TopSpecificationActivity.class);
            intent.putExtra("pc", pc);
            startActivity(intent);
        });

        haff700EvoTopSpecification.setOnClickListener(v -> {
            TopSpecification pc = new TopSpecification("Haff 700 Evo", "Intel Core i9-12900F (Gen 12 Intel)", "Gigabyte B660M DS3H DDR4", "Jonsbo CR1200 RGB CPU Cooler", "16GB(2x8GB) DDR4 3200Mhz RGB", "Nvidia RTX 4090 24GB", R.drawable.haff_700_evo);

            Intent intent = new Intent(this, TopSpecificationActivity.class);
            intent.putExtra("pc", pc);
            startActivity(intent);
        });
    }
}