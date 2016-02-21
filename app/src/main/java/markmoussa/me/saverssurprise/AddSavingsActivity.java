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

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        TextView amountSavedTextView = (TextView) findViewById(R.id.amountSavedTextView);
        EditText amountSavedEditor = (EditText) findViewById(R.id.amountSavedEditor);

        TextView commentsTextView = (TextView) findViewById(R.id.commentsTextView);
        EditText commentsTextEditor = (EditText) findViewById(R.id.commentsTextEditor);

        Button submitButton = (Button) findViewById(R.id.submitSavedButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddSavingsActivity.this, ThankYouActivity.class));
            }
        });
    }

}
