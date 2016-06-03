package niameyzze.apkode.net.niameyzze.activity;

import android.app.ProgressDialog;
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
import niameyzze.apkode.net.niameyzze.adapter.ShopAdapter;
import niameyzze.apkode.net.niameyzze.fragment.ShopSlideshow;
import niameyzze.apkode.net.niameyzze.helper.AppController;
import niameyzze.apkode.net.niameyzze.model.Shop;

public class ShopsActivity extends AppCompatActivity {

    private static final String endpoint = "http://api.androidhive.info/json/glide.json";
    private String TAG = ShopsActivity.class.getSimpleName();
    private ArrayList<Shop> shops;
    private ProgressDialog pDialog;
    private ShopAdapter shopAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        pDialog = new ProgressDialog(this);
        shops = new ArrayList<>();
        shopAdapter = new ShopAdapter(this, shops);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(shopAdapter);

        recyclerView.addOnItemTouchListener(new ShopAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new ShopAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("shops", shops);
                bundle.putInt("position", position);

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                ShopSlideshow shopSlideshow = ShopSlideshow.newInstance();
                shopSlideshow.setArguments(bundle);
                shopSlideshow.show(fragmentTransaction, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        fetchImages();

    }

    private void fetchImages() {

        final TextView txtLoadingShop = (TextView) findViewById(R.id.txtLoadingShop);

        JsonArrayRequest req = new JsonArrayRequest(endpoint,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        assert txtLoadingShop != null;
                        txtLoadingShop.setVisibility(View.GONE);

                        shops.clear();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                Shop shop = new Shop();
                                shop.setName(object.getString("name"));

                                JSONObject url = object.getJSONObject("url");
                                shop.setSmall(url.getString("small"));
                                shop.setMedium(url.getString("medium"));
                                shop.setLarge(url.getString("large"));
                                shop.setTimestamp(object.getString("timestamp"));

                                shops.add(shop);

                            } catch (JSONException e) {
                                Log.e(TAG, "Json parsing error: " + e.getMessage());
                            }
                        }

                        shopAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                assert txtLoadingShop != null;
                txtLoadingShop.setText("Erreur réseau");
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }

}
