package umn.ac.id.uas.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import umn.ac.id.uas.project.model.TopSpecification;

public class TopSpecificationActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_specification);

        TopSpecification pc = (TopSpecification) getIntent().getSerializableExtra("pc");

        ImageView pcImageResource = findViewById(R.id.pc_image_resource);
        TextView name = findViewById(R.id.pc_name);
        TextView processor = findViewById(R.id.processor_text);
        TextView motherboard = findViewById(R.id.motherboard_text);
        TextView cpuCooler = findViewById(R.id.cpu_cooler_text);
        TextView ram = findViewById(R.id.ram_text);
        TextView graphicCard = findViewById(R.id.graphic_card);

        name.setText(pc.getName());
        pcImageResource.setImageResource(pc.getImageResource());
        processor.setText(processor.getText().toString() + " " + pc.getProcessor());
        motherboard.setText(motherboard.getText().toString() + " " + pc.getMotherboard());
        cpuCooler.setText(cpuCooler.getText().toString() + " " + pc.getCpu_cooler());
        ram.setText(ram.getText().toString() + " " + pc.getRam());
        graphicCard.setText(graphicCard.getText().toString() + " " + pc.getGraphic_card());
    }
}