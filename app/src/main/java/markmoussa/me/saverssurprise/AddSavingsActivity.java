package markmoussa.me.saverssurprise;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class AddSavingsActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";

    EditText amountSavedEditor;
    EditText commentsTextEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView amountSavedTextView = (TextView) findViewById(R.id.amountSavedTextView);
        amountSavedEditor = (EditText) findViewById(R.id.amountSavedEditor);

        TextView commentsTextView = (TextView) findViewById(R.id.commentsTextView);
        commentsTextEditor = (EditText) findViewById(R.id.commentsTextEditor);

        Button submitButton = (Button) findViewById(R.id.submitSavedButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            //final Double amountAdded = Double.parseDouble(amountSavedEditor.getText().toString());

            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String uid = intent.getStringExtra("uid");
//                Bundle extras = getIntent().getExtras();
//                if (extras != null) {
//                    uid = extras.getString("uid");
//                } else {
//                    uid = null;
//                    Log.v("NULL: ", "this is null m8");
//                }
                Log.v("DANK: ", "uid is this: " + uid);
                String url = "https://scorching-torch-468.firebaseio.com/users/" + uid;
                Log.v("Dank url: ", url);
                final Firebase myFireBaseRef = new Firebase(url);
                //myFireBaseRef.child("users");
                myFireBaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        // do some stuff once
                        // Grab dat savings
                        int amountAdding = (int) (Double.parseDouble(amountSavedEditor.getText().toString()) * 100);
                        int amountSaved = (int) (Double.parseDouble(snapshot.child("amountSaved").getValue().toString()) * 100);
                        amountSaved += amountAdding;
                        Log.v("DANK: ", snapshot.child("city").getValue().toString());
                        myFireBaseRef.child("amountSaved").setValue(amountSaved/100);
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        Log.v("Error whaaaaaat: ", firebaseError.getMessage());
                    }
                });
                // Add the value to the shared preferences persistence
                // Grab value from the database and add whatever the number added is
                // Push value back to database

//                String url = "https://api.zinc.io/v0/order";
//                // Request a string response
//                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//
//                                // Result handling
//                                System.out.println(response.substring(0,100));
//
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                        // Error handling
//                        System.out.println("Something went wrong!");
//                        error.printStackTrace();
//
//                    }
//                });
//                // Add the request to the queue
//                Volley.newRequestQueue(this).add(stringRequest);
//                // Take separate value and comment and make it into JSON, to push to database
//                // so that it can show up in history
                startActivity(new Intent(AddSavingsActivity.this, ThankYouActivity.class));
            }
        });
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//    }
//
//    @Override
//    protected void onStart() {
//        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedpreferences.edit();
//
//        editor.putString(Name, n);
//        editor.putString(Phone, ph);
//        editor.putString(Email, e);
//        editor.commit();
//        Toast.makeText(AddSavingsActivity.this,"Thanks", Toast.LENGTH_LONG).show();
//    }
}
