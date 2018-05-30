package softskills.venky.com.softjob;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Myprofile extends AppCompatActivity {
    TextView username,emailid,Mobile;
    String uid,email,mobile;
    FirebaseUser user;
    public void onBackPressed() {
        Toast.makeText(Myprofile.this, "Back Button is being Pressed!", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_myprofile);
        username =(TextView) findViewById(R.id.userid);
        emailid =(TextView) findViewById(R.id.useremail);
        Mobile=(TextView)findViewById(R.id.usermobile);
        user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        uid = user.getUid();
        email = user.getEmail();
        mobile=user.getPhoneNumber();
        Mobile.setText(mobile);
        username.setText(uid);
        emailid.setText(email);
    }
}
