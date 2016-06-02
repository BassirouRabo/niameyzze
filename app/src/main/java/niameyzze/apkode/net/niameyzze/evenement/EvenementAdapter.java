package niameyzze.apkode.net.niameyzze.evenement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import niameyzze.apkode.net.niameyzze.R;

/**
 * Created by brabo on 6/2/16.
 */
public class EvenementAdapter extends RecyclerView.Adapter<EvenementViewHolder> {
    List<EvenementObject> list;

    public EvenementAdapter(List<EvenementObject> list) {
        this.list = list;
    }

    @Override
    public EvenementViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_evenement, viewGroup, false);
        return new EvenementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EvenementViewHolder evenementViewHolder, int position) {
        EvenementObject evenementObject = list.get(position);
        evenementViewHolder.bind(evenementObject);
        evenementViewHolder.itemView.setTag(evenementObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
