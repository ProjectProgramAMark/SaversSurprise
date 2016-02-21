package markmoussa.me.saverssurprise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class AddSavingsActivity extends AppCompatActivity {

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

}
