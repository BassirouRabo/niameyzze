package niameyzze.apkode.net.niameyzze.manga;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import niameyzze.apkode.net.niameyzze.R;

/**
 * Created by brabo on 6/3/16.
 */
public class MangaAdapter extends RecyclerView.Adapter<MangaViewHolder> {
    List<MangaObject> list;

    public MangaAdapter(List<MangaObject> list) {
        this.list = list;
    }

    @Override
    public MangaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_manga, viewGroup, false);
        return new MangaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MangaViewHolder mangaViewHolder, int position) {
        MangaObject mangaObject = list.get(position);
        mangaViewHolder.bind(mangaObject);
        mangaViewHolder.itemView.setTag(mangaObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
