package umn.ac.id.uas.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import umn.ac.id.uas.project.adapter.TopSpecificationAdapter;
import umn.ac.id.uas.project.global.SharedPreference;
import umn.ac.id.uas.project.model.ComputerPackage;
import umn.ac.id.uas.project.model.TopSpecification;
import umn.ac.id.uas.project.model.UserModel;
import umn.ac.id.uas.project.retrofit.ApiService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserModel user = SharedPreference.getUser(getApplicationContext());

        TextView displayName = findViewById(R.id.display_name);
        displayName.setText("Hai, " + user.getName());

        ImageView profileIcon = findViewById(R.id.profile_icon);

        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(v -> {
            SharedPreference.logout(getApplicationContext());
            startActivity(new Intent(this, SignInActivity.class));
            finish();
        });

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

        ConstraintLayout product = findViewById(R.id.product);
        product.setOnClickListener(v -> {
            startActivity(new Intent(this, ProductActivity.class));
        });

        ApiService.endpoint().getTopSpecificationComputers().enqueue(new Callback<ComputerPackage>() {
            @Override
            public void onResponse(Call<ComputerPackage> call, Response<ComputerPackage> response) {
                if(response.isSuccessful()) {
                    ArrayList<ComputerPackage> computerPackages =  response.body().getTopSpecificationComputers();

                    RecyclerView topSpecificationRecyclerView = findViewById(R.id.top_specification_recycler_view);
                    TopSpecificationAdapter topSpecificationAdapter = new TopSpecificationAdapter(MainActivity.this, computerPackages);
                    topSpecificationRecyclerView.setAdapter(topSpecificationAdapter);
                    topSpecificationRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                } else {
                    try {
                        String errorMessage = response.errorBody().string();
                        Log.i("error 23", errorMessage);
                        Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ComputerPackage> call, Throwable t) {
                String errorMessage = t.getMessage();
                Log.i("Error 21", errorMessage);
                Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}