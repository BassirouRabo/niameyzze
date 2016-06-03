package niameyzze.apkode.net.niameyzze.holder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.Serializable;

import niameyzze.apkode.net.niameyzze.R;
import niameyzze.apkode.net.niameyzze.activity.EventActivity;
import niameyzze.apkode.net.niameyzze.model.Event;

public class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView txtRubrique, txtTitre, txtTarif, txtLieu, txtHoraire;


    public EventHolder(View itemView) {
        super(itemView);

        txtRubrique = (TextView) itemView.findViewById(R.id.txtRubrique);
        txtTitre = (TextView) itemView.findViewById(R.id.txtTitre);
        txtTarif = (TextView) itemView.findViewById(R.id.txtTarif);
        txtLieu = (TextView) itemView.findViewById(R.id.txtLieu);
        txtHoraire = (TextView) itemView.findViewById(R.id.txtHoraire);

        itemView.setOnClickListener(this);
    }

    public void bind(Event event) {
        txtRubrique.setText("#" + event.getRubrique());
        txtTitre.setText(event.getTitre());
        txtTarif.setText(event.getTarif());
        txtLieu.setText(event.getLieu());
        txtHoraire.setText(event.getHoraire());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext().getApplicationContext(), EventActivity.class);
        intent.putExtra("Event", (Serializable) v.getTag());
        v.getContext().startActivity(intent);
    }
}