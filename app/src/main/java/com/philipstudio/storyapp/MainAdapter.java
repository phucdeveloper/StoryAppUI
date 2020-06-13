package com.philipstudio.storyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<Category> arrayList;
    Context context;

    public MainAdapter(ArrayList<Category> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return arrayList.get(position).getType();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Constant.ITEM_TRENDING:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trending, parent, false);
                return new ViewHolder(view, viewType);
            case Constant.ITEM_FAVOURITE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favourite, parent, false);
                return new ViewHolder(view, viewType);

            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (arrayList.get(position).getType()) {
            case Constant.ITEM_TRENDING:
                holder.txtCategory.setText(arrayList.get(position).getNameCategory());
                holder.cardStackView.setHasFixedSize(true);
                CardStackLayoutManager layoutManager = new CardStackLayoutManager(context);
                layoutManager.setStackFrom(StackFrom.Right);
                layoutManager.setVisibleCount(3);
                layoutManager.setTranslationInterval(16.0f);
                layoutManager.setScaleInterval(0.95f);
                layoutManager.setMaxDegree(0.0f);
                layoutManager.setDirections(Direction.HORIZONTAL);
                holder.cardStackView.setLayoutManager(layoutManager);
                holder.cardStackView.rewind();

                TrendingAdapter adapter = new TrendingAdapter(arrayList.get(position).getArrayList(), context);
                holder.cardStackView.setAdapter(adapter);
                break;
            case Constant.ITEM_FAVOURITE:
                holder.recyclerView.setHasFixedSize(true);
                LinearLayoutManager manager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
                holder.recyclerView.setLayoutManager(manager);

                FavouriteAdapter favouriteAdapter = new FavouriteAdapter(arrayList.get(position).getArrayList(), context);
                holder.recyclerView.setAdapter(favouriteAdapter);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtCategory;
        CardStackView cardStackView;
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            switch (viewType) {
                case Constant.ITEM_TRENDING:
                    txtCategory = itemView.findViewById(R.id.item_textview_category);
                    cardStackView = itemView.findViewById(R.id.card_stack_view);
                    break;
                case Constant.ITEM_FAVOURITE:
                    txtCategory = itemView.findViewById(R.id.item_textview_category);
                    recyclerView = itemView.findViewById(R.id.recyclerview);
                    break;
            }
        }
    }
}
