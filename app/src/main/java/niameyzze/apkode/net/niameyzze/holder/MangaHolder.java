package niameyzze.apkode.net.niameyzze.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import niameyzze.apkode.net.niameyzze.R;

/**
 * Created by brabo on 6/3/16.
 */
public class MangaHolder extends RecyclerView.ViewHolder {
    public ImageView thumbnail;

    public MangaHolder(View view) {
        super(view);
        thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
    }
}