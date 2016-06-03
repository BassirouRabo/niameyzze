package niameyzze.apkode.net.niameyzze.manga;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import niameyzze.apkode.net.niameyzze.R;

/**
 * Created by brabo on 6/3/16.
 */
public class MangaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView image;

    public MangaViewHolder(View itemView) {
        super(itemView);

        image = (ImageView)itemView.findViewById(R.id.image);

        itemView.setOnClickListener(this);
    }

    public void bind(MangaObject mangaObject){

       /* Picasso.with(image.getContext())
                .load(R.mipmap.bg2)
                .fit().centerCrop()
                .into(image);*/
    }

    @Override
    public void onClick(View v) {

    }
}
