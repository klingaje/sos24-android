package fi.arcada.codechallenge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DatItemViewAdapter extends RecyclerView.Adapter<DatItemViewAdapter.DataItemViewHolder> {

    ArrayList<DataItem> dataItems;
    Context context;

    public DatItemViewAdapter(Context context, ArrayList<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;

    }

    @NonNull
    @Override
    public DatItemViewAdapter.DataItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DatItemViewAdapter.DataItemViewHolder holder, int position) {
        DataItem item = dataItems.get(position);

        holder.itemName.setText(item.getName());
        holder.itemValue.setText(String.format("%.2f", item.getValue()));
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class DataItemViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemValue;

        public DataItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.dataItemName);
            itemValue = itemView.findViewById(R.id.dataItemValue);

        }
    }
}
