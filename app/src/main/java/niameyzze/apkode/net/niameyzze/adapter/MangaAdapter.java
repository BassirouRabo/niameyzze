package niameyzze.apkode.net.niameyzze.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import niameyzze.apkode.net.niameyzze.R;
import niameyzze.apkode.net.niameyzze.holder.MangaHolder;
import niameyzze.apkode.net.niameyzze.model.Manga;

public class MangaAdapter extends RecyclerView.Adapter<MangaHolder> {

    private List<Manga> mangas;
    private Context mContext;

    public MangaAdapter(Context context, List<Manga> mangas) {
        mContext = context;
        this.mangas = mangas;
    }

    @Override
    public MangaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_manga, parent, false);
        return new MangaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MangaHolder mangaHolder, int position) {
        Manga manga = mangas.get(position);

        Glide.with(mContext).load(manga.getMedium())
                .thumbnail(0.5f)
                .crossFade()
                .placeholder(R.color.grey300)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mangaHolder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return mangas.size();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MangaAdapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MangaAdapter.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

   
}