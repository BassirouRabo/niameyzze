package niameyzze.apkode.net.niameyzze.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import niameyzze.apkode.net.niameyzze.R;
import niameyzze.apkode.net.niameyzze.model.Event;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Event event = (Event) getIntent().getSerializableExtra("Event");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        TextView txtTitre = (TextView) findViewById(R.id.txtTitre);
        TextView txtLieu = (TextView) findViewById(R.id.txtLieu);
        TextView txtHoraire = (TextView) findViewById(R.id.txtHoraire);
        TextView txtTarif = (TextView) findViewById(R.id.txtTarif);
        TextView txtPresentation = (TextView) findViewById(R.id.txtPresentation);

        ImageView imageView = (ImageView) findViewById(R.id.main_backdrop);

        assert toolbar != null;
        toolbar.setTitle("#" + event.getRubrique());

        assert txtTitre != null;
        txtTitre.setText(event.getTitre());
        assert txtLieu != null;
        txtLieu.setText(event.getLieu());
        assert txtHoraire != null;
        txtHoraire.setText(event.getHoraire());
        assert txtTarif != null;
        txtTarif.setText(event.getTarif());
        assert txtPresentation != null;
        txtPresentation.setText(event.getPresentation());

        Glide.with(this)
                .load(event.getImage())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
               .into(imageView);

        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_share) {
            // startActivity(new Intent(getApplicationContext(), Conditions.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
