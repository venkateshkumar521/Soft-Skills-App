package softskills.venky.com.softjob;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class DescriptionActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);


        Intent intent = getIntent();
        int position = intent.getIntExtra(RecyclerViewAdapter.POSITION_KEY_NAME, -1);

        if (position == -1) {
            titleTextView.setText("Error in retrieval of data");
        }
        else {
            DataClass dataClass = new DataClass();
            ArrayList<String> titleAR , descriptionAR;
            //get the contents
            titleAR = dataClass.getTitle();
            descriptionAR = dataClass.getDescription();
            titleTextView.setText(titleAR.get(position));
            descriptionTextView.setText(descriptionAR.get(position));
        }
    }
}
