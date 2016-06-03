package niameyzze.apkode.net.niameyzze;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    public void startEvenements(View view) {
        startActivity(new Intent(this, Events.class));
    }

    public void startMangas(View view) {
        startActivity(new Intent(this, Mangas.class));
    }

    public void startShops(View view) {
        startActivity(new Intent(this, Shop.class));
    }
}
