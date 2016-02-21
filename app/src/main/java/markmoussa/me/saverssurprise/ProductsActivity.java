package markmoussa.me.saverssurprise;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Firebase myFirebaseRef = new Firebase("https://scorching-torch-468.firebaseio.com/");
        EditText product1 = (EditText) findViewById(R.id.product1);
        EditText product2 = (EditText) findViewById(R.id.product2);
        EditText product3 = (EditText) findViewById(R.id.product3);
        EditText product4 = (EditText) findViewById(R.id.product4);
        EditText product5 = (EditText) findViewById(R.id.product5);
//        final ArrayList<String> products = new ArrayList<>();
//        products.add(product1.toString());
//        products.add(product2.toString());
//        products.add(product3.toString());
//        products.add(product4.toString());
//        products.add(product5.toString());
        Button submitProductButton = (Button) findViewById(R.id.submitProductsButton);
        submitProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid;
                Bundle extras = getIntent().getExtras();
                if(extras == null) {
                    uid = null;
                    Log.v("DANK: ", "There ain't no string being pulled in from the extras");
                } else {
                    uid= extras.getString("uid");
                }
                Firebase markRef = myFirebaseRef.child("users");
//                Map<String, Object> productsMap = new HashMap<String, Object>();
//                productsMap.put("products", products);
//                markRef.child(uid).updateChildren(products);
            }
        });

    }

}
