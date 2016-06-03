package niameyzze.apkode.net.niameyzze;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import niameyzze.apkode.net.niameyzze.manga.MangaAdapter;
import niameyzze.apkode.net.niameyzze.manga.MangaObject;

public class Mangas extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MangaObject> mangaObject = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getDataFromApi();

            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            recyclerView.setAdapter(new MangaAdapter(mangaObject));
        }
    }

    private void getDataFromApi(){
        ProgressBar loading = (ProgressBar) findViewById(R.id.loading);
        assert loading != null;
        loading.setVisibility(View.GONE);

        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));
        mangaObject.add(new MangaObject(""));

    }
}
