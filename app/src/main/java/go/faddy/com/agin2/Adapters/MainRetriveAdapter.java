package go.faddy.com.agin2.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import go.faddy.com.agin2.R;

public class MainRetriveAdapter extends RecyclerView.Adapter<MainRetriveAdapter.ImageViewHolder> {
    public Context mContext;
    private List<Retrive> mRetrives;
    private ArrayList<Image> images;
    public MainRetriveAdapter(Context context, List<Retrive> retrives){
        mContext = context;
        mRetrives = retrives;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Retrive retriveCurrent = mRetrives.get(position);
        holder.textViewName.setText(retriveCurrent.getSubject());
        holder.textUpload.setText(retriveCurrent.getDescription());
        holder.textDate.setText(retriveCurrent.getDay() + " - " + retriveCurrent.getMonth() + " - " + retriveCurrent.getYear());
        images = new ArrayList<>();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);
    }

    @Override
    public int getItemCount() {
        return mRetrives.size();
    }

    public  class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName, textUpload, textDate;
        public RecyclerView newRecycler;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
//            newRecycler = itemView.findViewById(R.id.new_recyclerview);
            textUpload = itemView.findViewById(R.id.text_view_desc);
            textDate = itemView.findViewById(R.id.show_dates);


        }
    }
}
