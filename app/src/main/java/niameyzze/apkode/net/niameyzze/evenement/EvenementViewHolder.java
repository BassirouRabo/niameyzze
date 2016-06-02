package niameyzze.apkode.net.niameyzze.evenement;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import java.io.Serializable;

import niameyzze.apkode.net.niameyzze.Event;
import niameyzze.apkode.net.niameyzze.R;

public class EvenementViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView txtRubrique, txtTitre, txtTarif, txtLieu, txtHoraire;

    public EvenementViewHolder(View itemView) {
        super(itemView);

        txtRubrique = (TextView) itemView.findViewById(R.id.txtRubrique);
        txtTitre = (TextView) itemView.findViewById(R.id.txtTitre);
        txtTarif = (TextView) itemView.findViewById(R.id.txtTarif);
        txtLieu = (TextView) itemView.findViewById(R.id.txtLieu);
        txtHoraire = (TextView) itemView.findViewById(R.id.txtHoraire);

        itemView.setOnClickListener(this);
    }

    public void bind(EvenementObject evenementObject) {
        txtRubrique.setText("#"+evenementObject.getRubrique());
        txtTitre.setText(evenementObject.getTitre());
        txtTarif.setText(evenementObject.getTarif());
        txtLieu.setText(evenementObject.getLieu());
        txtHoraire.setText(evenementObject.getHoraire());
    }

    @Override
    public void onClick(View v) {
        Log.e("e", "Clicked...");
        Intent intent = new Intent(v.getContext().getApplicationContext(), Event.class);
        intent.putExtra("EvenementObject", (Serializable) v.getTag());
       v.getContext().startActivity(intent);


    }
}