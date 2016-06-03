package niameyzze.apkode.net.niameyzze.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import niameyzze.apkode.net.niameyzze.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            }
        });

    }


    public void startEvenements(View view) {
        startActivity(new Intent(this, EventsActivity.class));
    }

    public void startMangas(View view) {
        startActivity(new Intent(this, MangasActivity.class));
    }

    public void startShops(View view) {
        startActivity(new Intent(this, ShopsActivity.class));
    }
}
