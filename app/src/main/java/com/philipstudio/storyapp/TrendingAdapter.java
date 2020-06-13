package com.philipstudio.storyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.ArrayList;

public class TrendingAdapter extends CardStackView.Adapter<TrendingAdapter.ViewHolder> {

    ArrayList<Image> arrayList;
    Context context;

    public TrendingAdapter(ArrayList<Image> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imge_trending, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgImage.setImageResource(arrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends CardStackView.ViewHolder{
        ImageView imgImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgImage = itemView.findViewById(R.id.imageview_image);
        }
    }
}
