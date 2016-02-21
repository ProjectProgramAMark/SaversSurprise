package markmoussa.me.saverssurprise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.okhttp.Response;

import java.io.IOException;

public class ThankYouActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button viewHistoryButton = (Button) findViewById(R.id.viewHistoryButton);
        Button exitButton = (Button) findViewById(R.id.exitButton);
        final Button buyStuff = (Button) findViewById(R.id.runTheTrap);
        viewHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThankYouActivity.this, HistoryGraphActivity.class));
            }
        });

        final Activity activity = this;

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code the exit/killing part later
            }
        });

        buyStuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyStuff();

            }
        });
    }

    public void buyStuff() {
        final HttpUtil swagSend = new HttpUtil();
        final String searchUrl = "https://api.zinc.io/v0/order";
        String json = "  \"client_token\": \"T8VOQUVI0YZVHVY6ICVTXGPP\",\n" +
                "  \"retailer\": \"amazon\",\n" +
                "  \"products\": [\n" +
                "    {\n" +
                "      \"product_id\": \"0923568964\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"seller_selection_criteria\": {\n" +
                "          \"condition_in\": [\"New\"],\n" +
                "          \"prime\": true,\n" +
                "          \"handling_days_max\": 6\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"max_price\": 0,\n" +
                "  \"shipping_address\": {\n" +
                "    \"first_name\": \"Tim\",\n" +
                "    \"last_name\": \"Beaver\",\n" +
                "    \"address_line1\": \"77 Massachusetts Avenue\",\n" +
                "    \"address_line2\": \"\",\n" +
                "    \"zip_code\": \"02139\",\n" +
                "    \"city\": \"Cambridge\",\n" +
                "    \"state\": \"MA\",\n" +
                "    \"country\": \"US\",\n" +
                "    \"phone_number\": \"5551230101\"\n" +
                "  },\n" +
                "  \"is_gift\": true,\n" +
                "  \"shipping_method\": \"cheapest\",\n" +
                "  \"payment_method\": {\n" +
                "    \"name_on_card\": \"Ben Bitdiddle\",\n" +
                "    \"number\": \"5555555555554444\",\n" +
                "    \"security_code\": \"123\",\n" +
                "    \"expiration_month\": 1,\n" +
                "    \"expiration_year\": 2015,\n" +
                "    \"use_gift\": false\n" +
                "  },\n" +
                "  \"billing_address\": {\n" +
                "    \"first_name\": \"William\",\n" +
                "    \"last_name\": \"Rogers\",\n" +
                "    \"address_line1\": \"84 Massachusetts Ave\",\n" +
                "    \"address_line2\": \"\",\n" +
                "    \"zip_code\": \"02139\",\n" +
                "    \"city\": \"Cambridge\",\n" +
                "    \"state\": \"MA\",\n" +
                "    \"country\": \"US\",\n" +
                "    \"phone_number\": \"5551234567\"\n" +
                "  },\n" +
                "  \"retailer_credentials\": {\n" +
                "    \"email\": \"timbeaver@gmail.com\",\n" +
                "    \"password\": \"myRetailerPassword\"\n" +
                "  },\n";

        swagSend.post(searchUrl, new HttpUtil.HttpCallback() {
            @Override
            public void onFailure(Response response, IOException e) {

            }

            @Override
            public void onSuccess(Response response) {
                try {
                    final String jsonData = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String purchaseUrl = "http://www.amazon.com/BigMouth-Donald-Trump-Toilet-Paper/dp/B0198KU3Y0/ref=pd_rhf_gw_s_cp_4?_encoding=UTF8&ie=UTF8&pf_rd_i=&pf_rd_m=&pf_rd_p=&pf_rd_r=15SXR2AK7462AZBDV8XZ&pf_rd_s=recent-history-footer&pf_rd_t=gateway&refRID=15SXR2AK7462AZBDV8XZ";
                            Intent i = new Intent(ThankYouActivity.this, ProductReturn.class);
                            i.putExtra("url", purchaseUrl);
                            startActivity(i);
                        }


                    });
                    Log.v("SWAG: ", jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
//
//    public void onRestart() {
//        super.onRestart();
//        finish();
//        System.out.println("On Restart called!!");
//        startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedpreferences.edit();
//
//        editor.putString(Name, n);
//        editor.putString(Phone, ph);
//        editor.putString(Email, e);
//        editor.commit();
//        Toast.makeText(ThankYouActivity.this,"Thanks", Toast.LENGTH_LONG).show();
//
//    }
}