package com.philipstudio.storyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview_main);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Image> arrayList = new ArrayList<>();
        arrayList.add(new Image("Image 1", R.drawable.image1));
        arrayList.add(new Image("Image 2", R.drawable.image2));
        arrayList.add(new Image("Image 3", R.drawable.image3));
        arrayList.add(new Image("Image 4", R.drawable.image4));
        arrayList.add(new Image("Image 5", R.drawable.image5));
        arrayList.add(new Image("Image 6", R.drawable.image6));
        arrayList.add(new Image("Image 7", R.drawable.image7));
        arrayList.add(new Image("Image 8", R.drawable.image8));
        arrayList.add(new Image("Image 9", R.drawable.image9));
        arrayList.add(new Image("Image 10", R.drawable.image10));

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Trending", arrayList, Constant.ITEM_TRENDING));
        categories.add(new Category("Favourite", arrayList, Constant.ITEM_FAVOURITE));

        MainAdapter adapter = new MainAdapter(categories, MainActivity.this);
        recyclerView.setAdapter(adapter);


    }
}