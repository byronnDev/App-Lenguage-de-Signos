package mikel.echeverria.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mikel.echeverria.model.Card;
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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RecyclerDataHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
        holder.assignData(dataList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setDataList(List<Card> listaDeElementos) {
        this.dataList = listaDeElementos;
        notifyDataSetChanged();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {
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
            itemView.setOnClickListener(view -> listener.onItemClick(item));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Card item);
    }
}