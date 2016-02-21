package markmoussa.me.saverssurprise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddSavingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView amountSavedTextView = (TextView) findViewById(R.id.amountSavedTextView);
        EditText amountSavedEditor = (EditText) findViewById(R.id.amountSavedEditor);

        TextView commentsTextView = (TextView) findViewById(R.id.commentsTextView);
        EditText commentsTextEditor = (EditText) findViewById(R.id.commentsTextEditor);

        Button submitButton = (Button) findViewById(R.id.submitSavedButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add the value to the shared preferences persistence
                // Grab value from the database and add whatever the number added is
                // Push value back to database

                // Take separate value and comment and make it into JSON, to push to database
                // so that it can show up in history
                startActivity(new Intent(AddSavingsActivity.this, ThankYouActivity.class));
            }
        });
    }

}
