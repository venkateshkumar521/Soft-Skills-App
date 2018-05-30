package softskills.venky.com.softjob;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private ArrayList<String> data1, data2;
    private Context ctx;
    public static final String POSITION_KEY_NAME = "Position";

    RecyclerViewAdapter(Context context, ArrayList<String> s1, ArrayList<String> s2)
    {
        ctx = context;
        data1 = s1;
        data2 = s2;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater myLayoutInflater = LayoutInflater.from(ctx);
        View customView = myLayoutInflater.inflate(R.layout.my_row_layout,parent,false);

        return new CustomViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.t1.setText(data1.get(position));
        holder.t2.setText(data2.get(position));
    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView t1,t2;

        CustomViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            t1=itemView.findViewById(R.id.textView1);
            t2=itemView.findViewById(R.id.textView2);

        }

        @Override
        public void onClick(View v) {

            for (int i = 0; i < data1.size(); i++) {

                if (getLayoutPosition() == i) {

                    Intent intent = new Intent(ctx, DescriptionActivity.class);
                    intent.putExtra(POSITION_KEY_NAME, i);
                    ctx.startActivity(intent);

                }
            }
        }
    }
}