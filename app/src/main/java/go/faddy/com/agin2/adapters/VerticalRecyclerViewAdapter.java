package go.faddy.com.agin2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import go.faddy.com.agin2.models.RetrivingTexts;
import go.faddy.com.agin2.R;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalTextHolder> {
    public Context mContext;
    private List<RetrivingTexts> mRetrivingTexts;
    public RecyclerView newRecycler;
    DatabaseReference dataRef;
    private ArrayList<String> images;
    private RecyclerView mRecyclerView;
    private HorizontaRecyclerViewAdapter mAdapter;


    public VerticalRecyclerViewAdapter(Context context, List<RetrivingTexts> retrivingTexts) {
        mContext = context;
        mRetrivingTexts = retrivingTexts;
    }

    @NonNull
    @Override
    public VerticalTextHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_vertical, parent, false);
        return new VerticalTextHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalTextHolder holder, int position) {
        RetrivingTexts retrivingTextsCurrent = mRetrivingTexts.get(position);
        holder.textViewName.setText(retrivingTextsCurrent.getSubject());
        holder.textUpload.setText(retrivingTextsCurrent.getDescription());
        holder.textDate.setText(retrivingTextsCurrent.getDay() + " - " + retrivingTextsCurrent.getMonth() + " - " + retrivingTextsCurrent.getYear());
        String d = retrivingTextsCurrent.getTime_stamp();
        dataRef = FirebaseDatabase.getInstance().getReference()
                .child("posts").child("images").child(d);
        dataRef.keepSynced(true);
        images = new ArrayList<>();
        newRecycler.setHasFixedSize(true);
        newRecycler.setLayoutManager(new GridLayoutManager(mContext, 2));
        newRecycler.setItemAnimator(new DefaultItemAnimator());
        dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.hasChildren()) {
                        images.clear();
                        Iterable<DataSnapshot> snapshots = dataSnapshot.getChildren();
                        for (DataSnapshot snapshot : snapshots) {
                            images.add(snapshot.getValue(String.class));
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mAdapter = new HorizontaRecyclerViewAdapter(mContext, images);
        newRecycler.setAdapter(mAdapter);
    }

    @Override
    public int getItemCount() {
        return mRetrivingTexts.size();
    }

    public class VerticalTextHolder extends RecyclerView.ViewHolder {
        public TextView textViewName, textUpload, textDate;


        public VerticalTextHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textUpload = itemView.findViewById(R.id.text_view_desc);
            textDate = itemView.findViewById(R.id.show_dates);
            newRecycler = (RecyclerView) itemView.findViewById(R.id.recycler_view1);
        }
    }
}
