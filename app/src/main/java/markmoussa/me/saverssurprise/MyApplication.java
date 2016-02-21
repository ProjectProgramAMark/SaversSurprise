package markmoussa.me.saverssurprise;
import android.app.Application;
import com.firebase.client.Firebase;

public class MyApplication extends Application {
        private double amountSaved = 0;
        public double getAmountSaved() {
            return amountSaved;
        }

        public void setAmountSaved(String someVariable) {
            this.amountSaved = amountSaved;
        }
        @Override
        public void onCreate() {
            super.onCreate();
            Firebase.setAndroidContext(this);
        }
}
