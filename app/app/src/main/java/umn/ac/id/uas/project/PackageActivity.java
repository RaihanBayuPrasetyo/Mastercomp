package umn.ac.id.uas.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.stream.Collectors;

import umn.ac.id.uas.project.adapter.PackageAdapter;
import umn.ac.id.uas.project.model.ComputerPackage;

public class PackageActivity extends AppCompatActivity {
    public TextView packageLow;
    public TextView packageMedium;
    public TextView packageHigh;
    public ArrayList<ComputerPackage> computerPackages = new ArrayList<>();
    public RecyclerView recyclerView;
    public PackageAdapter packageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        recyclerView = findViewById(R.id.recycler_view);
        seedPackageData();
        setRecyclerviewItem(computerPackages);
        setPackageFragmentOnClickListener();
    }

    private void setRecyclerviewItem(ArrayList<ComputerPackage> computerPackages) {
        packageAdapter = new PackageAdapter(this, computerPackages);
        recyclerView.setAdapter(packageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void seedPackageData() {
        computerPackages.add(new ComputerPackage("Gaming E-Sports Blockade", 6969800.0, "AMD Ryzen 5 4500 3.6Ghz Up To 4.1Ghz, MSI B450 A Pro MAX,  GALAX Geforce GTX 1660 6GB DDR5", R.drawable.zeus_300_x_computer, "low"));
        computerPackages.add(new ComputerPackage("Gaming E-Sports Extraordinary", 8999000, "AMD Ryzen 5 4500 3.6Ghz Up To 4.1Ghz MSI B450 A Pro MAX,XFX Radeon RX 6600 CORE 8GB DDR6, CUBE GAMING WRITE WHITE.", R.drawable.zeus_300_x_computer, "low"));
        computerPackages.add(new ComputerPackage("Gaming E-Sports Hyssos", 10899000, "Intel Core i5 10400F 2.9Ghz Up To, ASRock B560M Pro4,  GEIL DDR4 EVO POTENZA 3200MHz Dual Chann, GALAX Geforce GTX 1660 SUPER 6GB DDR6.", R.drawable.zeus_300_x_computer, "medium"));
        computerPackages.add(new ComputerPackage("MSI MAG Desktop XII", 33341000, "MSI GeForce RTX 3080 Ventus 3X 8GB GDDR6, Intel i9-12900F [16C(8P+8E)/20T, MSI MAG B660 Tomahawk WiFi DDR4 [ATX]", R.drawable.zeus_300_x_computer, "high"));
    }

    private void setPackageFragmentOnClickListener() {
        packageLow = findViewById(R.id.package_low);
        packageMedium = findViewById(R.id.package_medium);
        packageHigh = findViewById(R.id.package_high);

        TextView[] textViews = {packageLow, packageMedium, packageHigh};

        packageLow.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                resetPackagesBackground(textViews);
                packageLow.setBackground(getResources().getDrawable(R.drawable.selected_package_background_low));
                setRecyclerviewItem((ArrayList<ComputerPackage>) computerPackages.stream().filter(c -> c.getRanking().equalsIgnoreCase("low")).collect(Collectors.toList()));
            }
        });

        packageMedium.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                resetPackagesBackground(textViews);
                packageMedium.setBackground(getResources().getDrawable(R.drawable.selected_package_background_medium));
                setRecyclerviewItem((ArrayList<ComputerPackage>) computerPackages.stream().filter(c -> c.getRanking().equalsIgnoreCase("medium")).collect(Collectors.toList()));
            }
        });

        packageHigh.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                resetPackagesBackground(textViews);
                packageHigh.setBackground(getResources().getDrawable(R.drawable.selected_package_background_high));
                setRecyclerviewItem((ArrayList<ComputerPackage>) computerPackages.stream().filter(c -> c.getRanking().equalsIgnoreCase("high")).collect(Collectors.toList()));
            }
        });
    }

    private void resetPackagesBackground(TextView[] textViews) {
        for(TextView textView : textViews) {
            textView.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_background_grey));
        }
    }
}