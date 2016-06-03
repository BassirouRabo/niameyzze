package niameyzze.apkode.net.niameyzze;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import niameyzze.apkode.net.niameyzze.shop.ShopAdapter;
import niameyzze.apkode.net.niameyzze.shop.ShopObject;

public class Shop extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ShopObject> shopObject = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getDataFromApi();

            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new ShopAdapter(shopObject));
        }
    }

    private void getDataFromApi(){
        ProgressBar loading = (ProgressBar) findViewById(R.id.loading);
        assert loading != null;
        loading.setVisibility(View.GONE);

        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));
        shopObject.add(new ShopObject(""));

    }

}
