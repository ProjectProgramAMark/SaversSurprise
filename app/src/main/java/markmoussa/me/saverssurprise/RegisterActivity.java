package markmoussa.me.saverssurprise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText emailField = (EditText) findViewById(R.id.emailField);
        EditText passWordField = (EditText) findViewById(R.id.passwordField);
        EditText streetAddressField = (EditText) findViewById(R.id.streetAddressField);
        EditText cityField = (EditText) findViewById(R.id.cityField);
        EditText stateField = (EditText) findViewById(R.id.stateField);
        EditText zipField = (EditText) findViewById(R.id.zipField);
        EditText phoneField = (EditText) findViewById(R.id.phoneField);
        Button registerSubmitButton = (Button) findViewById(R.id.registerSubmitButton);


    }

}
