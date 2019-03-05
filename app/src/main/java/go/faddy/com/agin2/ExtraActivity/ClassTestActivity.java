package go.faddy.com.agin2.ExtraActivity;

import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import go.faddy.com.agin2.Adapters.MainRetriveAdapter;
import go.faddy.com.agin2.Adapters.Retrive;
import go.faddy.com.agin2.R;

public class ClassTestActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MainRetriveAdapter mAdapter;
    private DatabaseReference mDatabaseRef;
    private List<Retrive> mRetrive;
    static Vibrator v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_test);
        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRetrive = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("posts").child("type").child("class_test");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Retrive retrive = postSnapshot.getValue(Retrive.class);
                    mRetrive.add(retrive);
                    v.vibrate(90);
                }
                mAdapter = new MainRetriveAdapter(ClassTestActivity.this, mRetrive);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}