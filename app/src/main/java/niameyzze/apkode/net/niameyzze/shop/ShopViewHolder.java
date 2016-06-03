package niameyzze.apkode.net.niameyzze.shop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import niameyzze.apkode.net.niameyzze.R;

/**
 * Created by brabo on 6/3/16.
 */
public class ShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView image;

    public ShopViewHolder(View itemView) {
        super(itemView);

        image = (ImageView)itemView.findViewById(R.id.image);

        itemView.setOnClickListener(this);
    }

    public void bind(ShopObject shopObject){

       /* Picasso.with(image.getContext())
                .load(R.mipmap.bg2)
                .fit().centerCrop()
                .into(image);*/
    }

    @Override
    public void onClick(View v) {

    }
}
