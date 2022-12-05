package umn.ac.id.uas.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import umn.ac.id.uas.project.model.ProcessorIntelModel;

public class PickProcessorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] processors;
    int[] imageIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_processor);

        processors = new String[]{
                "Pilih Brand Processor",
                "Intel",
                "AMD"
        };

        imageIcons = new int[] {
                R.drawable.tw_lightning_bolt,
                R.drawable.intel_logo,
                R.drawable.amd_logo
        };

        Spinner processorSpinner = findViewById(R.id.processor_spinner);
        processorSpinner.setOnItemSelectedListener(this);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),processors, imageIcons);
        processorSpinner.setAdapter(customAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch(processors[position]) {
            case "Intel" :
                ArrayList<ProcessorIntelModel> intelI9 = new ArrayList<ProcessorIntelModel>();
                ArrayList<ProcessorIntelModel> intelI7 = new ArrayList<ProcessorIntelModel>();

                intelI9.add(new ProcessorIntelModel(R.drawable.processor_icon, "Intel Core i9-13900K 3.0GHz Up To 5.8GHz - Cache 36MB [Box] Socket LGA 1700 - Raptor Lake Series"));
                intelI9.add(new ProcessorIntelModel(R.drawable.processor_icon, "Intel Core i9-13900K 3.0GHz Up To 5.8GHz - Cache 36MB [Box] Socket LGA 1700 - Raptor Lake Series"));

                intelI7.add(new ProcessorIntelModel(R.drawable.processor_icon, "Intel Core i7-13700K 3.4GHz Up To 5.4GHz - Cache 30MB [Box] Socket LGA 1700 - Raptor Lake Series"));
                intelI7.add(new ProcessorIntelModel(R.drawable.processor_icon, "Intel Core i7-13700K 3.4GHz Up To 5.4GHz - Cache 30MB [Box] Socket LGA 1700 - Raptor Lake Series"));

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProcessorRecyclerViewFragment(this, intelI9, intelI7)).commit();
                break;
            case "AMD" :
                ArrayList<ProcessorIntelModel> amd5 = new ArrayList<ProcessorIntelModel>();
                ArrayList<ProcessorIntelModel> amd4 = new ArrayList<ProcessorIntelModel>();

                amd5.add(new ProcessorIntelModel(R.drawable.amd_icon, "AMD Ryzen 9 7950X 4.5Ghz Up To 5.7Ghz Cache 64MB 170W AM5 [Box] - 16 Core - 100-100000514WOF"));
                amd5.add(new ProcessorIntelModel(R.drawable.amd_icon, "AMD Ryzen 9 7900X 4.7Ghz Up To 5.6Ghz Cache 64MB 170W AM5 [Box] - 12 Core - 100-100000589WOF"));

                amd4.add(new ProcessorIntelModel(R.drawable.amd_icon, "AMD Ryzen 9 5950X 3.4Ghz Up To 4.9Ghz Cache 64MB 105W AM4 [Box] - 16 Core - 100-100000059WOF (Garansi Lokal/AMD"));
                amd4.add(new ProcessorIntelModel(R.drawable.amd_icon, "AMD Ryzen 9 5900X 3.7Ghz Up To 4.8Ghz Cache 64MB 105W AM4 [Box] - 12 Core - 100-100000061WOF (Garansi AMD Global/AMD"));

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProcessorAmdRecyclerViewFragment(getApplicationContext(), amd4, amd5)).commit();
                break;
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment()).commit();
                Toast.makeText(this, "Please Pick a processor...", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}