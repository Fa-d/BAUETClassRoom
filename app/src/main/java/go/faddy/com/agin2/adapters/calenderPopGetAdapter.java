package go.faddy.com.agin2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import go.faddy.com.agin2.models.calenderPopGet;
import go.faddy.com.agin2.R;

public class calenderPopGetAdapter extends RecyclerView.Adapter<calenderPopGetAdapter.ViewHolder> {

    private List<calenderPopGet> listItems;
    private Context context;

    public calenderPopGetAdapter(List<calenderPopGet> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.calender_get_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        calenderPopGet popGet = listItems.get(i);
        viewHolder.type_cal.setText(popGet.getType());
        viewHolder.sub_cal.setText(popGet.getSubjcct());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView type_cal, sub_cal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type_cal = itemView.findViewById(R.id.type);
            sub_cal = itemView.findViewById(R.id.subject);
        }
    }

}
