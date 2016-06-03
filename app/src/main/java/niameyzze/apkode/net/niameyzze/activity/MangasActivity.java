package niameyzze.apkode.net.niameyzze.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import niameyzze.apkode.net.niameyzze.R;
import niameyzze.apkode.net.niameyzze.adapter.MangaAdapter;
import niameyzze.apkode.net.niameyzze.fragment.MangaSlideshow;
import niameyzze.apkode.net.niameyzze.helper.AppController;
import niameyzze.apkode.net.niameyzze.model.Manga;

public class MangasActivity extends AppCompatActivity {

    private static final String endpoint = "http://api.androidhive.info/json/glide.json";
    private String TAG = MangasActivity.class.getSimpleName();
    private ArrayList<Manga> mangas;
    private MangaAdapter mangaAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mangas = new ArrayList<>();
        mangaAdapter = new MangaAdapter(this, mangas);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mangaAdapter);

       recyclerView.addOnItemTouchListener(new MangaAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new MangaAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("mangas", mangas);
                bundle.putInt("position", position);

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                MangaSlideshow mangaSlideshow = MangaSlideshow.newInstance();
                mangaSlideshow.setArguments(bundle);
                mangaSlideshow.show(fragmentTransaction, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        fetchImages();

    }

    private void fetchImages() {
        final TextView txtLoadingManga = (TextView) findViewById(R.id.txtLoadingManga);

        JsonArrayRequest req = new JsonArrayRequest(endpoint,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        assert txtLoadingManga != null;
                        txtLoadingManga.setVisibility(View.GONE);

                        mangas.clear();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                Manga manga = new Manga();
                                manga.setName(object.getString("name"));

                                JSONObject url = object.getJSONObject("url");
                                manga.setSmall(url.getString("small"));
                                manga.setMedium(url.getString("medium"));
                                manga.setLarge(url.getString("large"));
                                manga.setTimestamp(object.getString("timestamp"));

                                mangas.add(manga);

                            } catch (JSONException e) {
                                Log.e(TAG, "Json parsing error: " + e.getMessage());
                            }
                        }

                        mangaAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                assert txtLoadingManga != null;
                txtLoadingManga.setVisibility(View.GONE);
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }
    
}
