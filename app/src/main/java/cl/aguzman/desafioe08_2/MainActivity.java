package cl.aguzman.desafioe08_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference root = new Nodes().refcredentials();
    TextView deparment;
    TextView jobTitle;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deparment = (TextView) findViewById(R.id.deparmentTv);
        jobTitle = (TextView) findViewById(R.id.jobTitleTv);
        name = (TextView) findViewById(R.id.nametTv);

        root.child("00030").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Credentials data = dataSnapshot.getValue(Credentials.class);
                deparment.setText(data.getDeparment());
                jobTitle.setText(data.getJobTitle());
                name.setText(data.getName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
