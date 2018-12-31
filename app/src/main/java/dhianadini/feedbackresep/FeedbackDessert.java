package dhianadini.feedbackresep;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDessert extends AppCompatActivity {
    public static final String FEEDBACK_DESSERT = "net.simplifiedcoding.firebasedatabaseexample.feedbackdessert";
    public static final String FEEDBACK_ID = "net.simplifiedcoding.firebasedatabaseexample.feedbackid";

    EditText editTextFeedback;
    Button buttonAddFeedback;
    ListView listViewFeedback;

    //a list to store all the artist from firebase database
    List<DBFeedbackDessert> feedbackdessert;

    //our database reference object
    DatabaseReference feedbackresep;//nama db

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_dessert);

        //getting the reference of feedback dessert node
        feedbackresep = FirebaseDatabase.getInstance().getReference("feedbackdessert"); //nama tabel

        //getting views
        editTextFeedback = (EditText) findViewById(R.id.editTextFeedback);
        listViewFeedback = (ListView) findViewById(R.id.listViewFeedback);
        buttonAddFeedback = (Button) findViewById(R.id.buttonAddFeedback);

        //list to store feedback dessert
        feedbackdessert = new ArrayList<>();

        //adding an onclicklistener to button
        buttonAddFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addFeedbackDessert();
            }
        });

        //attaching listener to listview
        listViewFeedback.setOnItemClickListener(new AdapterView.OnItemClickListener() {//gak ngerti iki piye gakpaham :)))
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {//aku iki gakpaham
                //getting the selected artist
                DBFeedbackDessert fdessert = feedbackdessert.get(i);

                //creating an intent
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setComponent(new ComponentName("dhianadini.resep_masakan_mama","dhianadini.resep_masakan_mama.DetailActivityDrink"));
                startActivity(intent);

                //putting feedback and id to intent
                intent.putExtra(FEEDBACK_ID, fdessert.getFeedbackId());
                intent.putExtra(FEEDBACK_DESSERT, fdessert.getFeedbackDessert());

                //starting the activity with intent
                startActivity(intent);//sampe iki gakpaham
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        feedbackresep.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                feedbackdessert.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    DBFeedbackDessert fdessert = postSnapshot.getValue(DBFeedbackDessert.class);
                    //adding artist to the list
                    feedbackdessert.add(fdessert);
                }

                //creating adapter
                FeedbackDessertList dessertAdapter = new FeedbackDessertList(FeedbackDessert.this, feedbackdessert);
                //attaching adapter to the listview
                listViewFeedback.setAdapter(dessertAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addFeedbackDessert() {
        //getting the values to save
        String dessert = editTextFeedback.getText().toString().trim();
        ;

        //checking if the value is provided
        if (!TextUtils.isEmpty(dessert)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = feedbackresep.push().getKey();

            //creating an Artist Object
            DBFeedbackDessert feedbackDessert = new DBFeedbackDessert(id, dessert);

            //Saving the Artist
            feedbackresep.child(id).setValue(feedbackDessert);

            //setting edittext to blank again
            editTextFeedback.setText("");

            //displaying a success toast
            Toast.makeText(this, "Feedback dessert added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a feedback", Toast.LENGTH_LONG).show();
        }
    }
}
