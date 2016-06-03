package niameyzze.apkode.net.niameyzze.shop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import niameyzze.apkode.net.niameyzze.R;

/**
 * Created by brabo on 6/3/16.
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopViewHolder> {
    List<ShopObject> list;

    public ShopAdapter(List<ShopObject> list) {
        this.list = list;
    }

    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_shop, viewGroup, false);
        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopViewHolder shopViewHolder, int position) {
        ShopObject shopObject = list.get(position);
        shopViewHolder.bind(shopObject);
        shopViewHolder.itemView.setTag(shopObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
