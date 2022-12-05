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
import umn.ac.id.uas.project.model.ProcessorIntelModel;

public class IntelAdapter extends RecyclerView.Adapter<IntelAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ProcessorIntelModel> processors;

    public IntelAdapter(Context context, ArrayList<ProcessorIntelModel> processors) {
        this.context = context;
        this.processors = processors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.processor_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(processors.get(position).getImage());
        holder.description.setText(processors.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return processors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView description;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.processor_description);
            image = itemView.findViewById(R.id.processor_image);
        }
    }
}
