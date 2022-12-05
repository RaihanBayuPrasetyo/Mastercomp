package umn.ac.id.uas.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import umn.ac.id.uas.project.R;
import umn.ac.id.uas.project.model.ComputerPackage;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ComputerPackage> computerPackages;

    public PackageAdapter(Context context, ArrayList<ComputerPackage> computerPackages) {
        this.context = context;
        this.computerPackages = computerPackages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.package_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(computerPackages.get(position).getTitle());
        holder.price.setText(String.valueOf(computerPackages.get(position).getPrice()));
        holder.description.setText(computerPackages.get(position).getDescription());
        holder.photo.setImageResource(computerPackages.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return computerPackages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, description, price;
        private ImageView photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.package_title);
            price = itemView.findViewById(R.id.package_price);
            description = itemView.findViewById(R.id.package_description);
            photo = itemView.findViewById(R.id.photo);
        }
    }
}
