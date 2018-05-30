package softskills.venky.com.softjob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class softActivity extends AppCompatActivity {

    ArrayList<String> title, subTitle, description;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft);
    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    DataClass dataClass = new DataClass();


    title = dataClass.getTitle();
    subTitle = dataClass.getSubTitle();
    description = dataClass.getDescription();


    adapter = new RecyclerViewAdapter(this, title, subTitle);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
}
}
