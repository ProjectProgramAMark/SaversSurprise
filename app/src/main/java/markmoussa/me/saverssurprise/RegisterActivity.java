package markmoussa.me.saverssurprise;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText emailField;
    EditText passwordField;
    EditText streetAddressField;
    EditText cityField;
    EditText stateField;
    EditText zipField;
    EditText phoneField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Firebase myFirebaseRef = new Firebase("https://scorching-torch-468.firebaseio.com/");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        emailField = (EditText) findViewById(R.id.emailField);
        //String emailText = emailField.getText().toString();
        passwordField = (EditText) findViewById(R.id.passwordField);
        //String passwordText = passwordField.getText().toString();
        streetAddressField = (EditText) findViewById(R.id.streetAddressField);
        //String streetAddressText = emailField.getText().toString();
        cityField = (EditText) findViewById(R.id.cityField);
        //String cityText = cityField.getText().toString();
        stateField = (EditText) findViewById(R.id.stateField);
        //String stateText = stateField.getText().toString();
        zipField = (EditText) findViewById(R.id.zipField);
        //String zipText = zipField.getText().toString();
        phoneField = (EditText) findViewById(R.id.phoneField);
        //String phoneText = phoneField.getText().toString();
        Button registerSubmitButton = (Button) findViewById(R.id.registerSubmitButton);
        registerSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();
                String streetAddressText = emailField.getText().toString();
                String cityText = cityField.getText().toString();
                String stateText = stateField.getText().toString();
                String zipText = zipField.getText().toString();
                String phoneText = phoneField.getText().toString();

                myFirebaseRef.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        System.out.println("Successfully created user account with uid: " + result.get("uid"));
                        
                    }
                    @Override
                    public void onError(FirebaseError firebaseError) {
                        // there was an error
                        System.out.println("There was an error lil niglet");
                        Context context = getApplicationContext();
                        CharSequence text = "Login level NOT dank!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });
            }
        });


    }

    protected void onRegister(String email, String password, String street, String city, String state, String zip, String phone) {
        // Fill in the code for this later
    }

}
