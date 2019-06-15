package go.faddy.com.agin2.adapters;

import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import go.faddy.com.agin2.R;

public class HorizontaRecyclerViewAdapter extends RecyclerView.Adapter<HorizontaRecyclerViewAdapter.HorizontalImageViewHolder> {
    Vibrator v;
    Context context;
    public List<String> images;

    public HorizontaRecyclerViewAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.images = arrayList;
    }

    @NonNull
    @Override
    public HorizontalImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new HorizontalImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalImageViewHolder holder, int position) {
        String url = images.get(position);
        Picasso.with(context)
                .load(url)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        Picasso.with(context)
                                .load(url)
                                .into(holder.imageView);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class HorizontalImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public HorizontalImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }

}
