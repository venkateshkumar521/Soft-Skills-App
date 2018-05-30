package softskills.venky.com.softjob;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PostFeedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<PostFeedData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_feed);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(PostFeedActivity.this)
                        .setIcon(android.R.drawable.stat_sys_warning)
                        .setTitle("Job Post")
                        .setMessage("Are you sure you want to post a Job opening?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(PostFeedActivity.this,PostActivity.class);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(PostFeedActivity.this,
                                        "Cancelled", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rview);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();




        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                // StringBuffer stringbuffer = new StringBuffer();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    PostFeedData userdetails = dataSnapshot1.getValue(PostFeedData.class);
                    PostFeedData listdata = new PostFeedData();
                    String jobTitle =userdetails.getJobTitle();
                    String jobLocation=userdetails.getJobLocation();
                    String companyName=userdetails.getCompanyName();
                    String jobDescription=userdetails.getJobDescription();
                    String contact=userdetails.getContact();
                    String emailID = userdetails.getEmailID();


                    listdata.setJobTitle(jobTitle);
                    listdata.setJobLocation(jobLocation);
                    listdata.setCompanyName(companyName);
                    listdata.setJobDescription(jobDescription);
                    listdata.setContact(contact);
                    listdata.setEmailID(emailID);
                    list.add(listdata);
                    // Toast.makeText(MainActivity.this,""+name,Toast.LENGTH_LONG).show();

                }

                Context context = PostFeedActivity.this;
                RecyclerAdapter recycler = new RecyclerAdapter(context,list);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(PostFeedActivity.this);
                recyclerView.setLayoutManager(layoutmanager);
                recyclerView.setItemAnimator( new DefaultItemAnimator());
                recyclerView.setAdapter(recycler);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //  Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}
