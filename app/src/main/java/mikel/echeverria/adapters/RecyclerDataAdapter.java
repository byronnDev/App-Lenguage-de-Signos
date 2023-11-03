package mikel.echeverria.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mikel.echeverria.model.Card;
import mikel.echeverria.activities.SecondActivity;
import mikel.echeverria.R;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataHolder> {
    private List<Card> dataList;
    private OnItemClickListener listener;

    public RecyclerDataAdapter(List<Card> dataList, OnItemClickListener listener) {
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño del elemento de la lista y crear un nuevo ViewHolder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RecyclerDataHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
        // Vincula los datos en la posición 'position' al ViewHolder
        Card item = dataList.get(position);
        holder.assignData(item, listener);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class RecyclerDataHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }

        public void assignData(Card item, OnItemClickListener listener) {
            imageView.setImageResource(item.getImageResource());
            textView.setText(item.getName());

            // Configura el clic del elemento
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), SecondActivity.class);
                    intent.putExtra("imageResource", item.getImageResource());
                    intent.putExtra("name", item.getName());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String name, String description);
    }
}
