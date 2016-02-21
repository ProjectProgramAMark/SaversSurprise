package markmoussa.me.saverssurprise;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import okio.BufferedSink;

public class HttpUtil {

    private OkHttpClient client;
    private Request.Builder builder;

    public HttpUtil() {
        client = new OkHttpClient();
        builder = new Request.Builder();
    }

    public void get(String url, HttpCallback callback) {
        call("GET", url, callback);
    }

    public void post(String url, HttpCallback cb) {
        call("POST", url, cb);
    }

    private void call(String method, String url, final HttpCallback callback){
        Request request = builder.url(url).method(method, method.equals("GET") ? null : new RequestBody() {
            // don't care much about request body
            @Override
            public MediaType contentType() {
                return null;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

            }
        }).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFailure(null, e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    callback.onFailure(response, null);
                    return;
                }
                callback.onSuccess(response);
            }
        });

    }

    public interface HttpCallback {

        public void onFailure(Response response, IOException e);

        public void onSuccess(Response response);

    }
}