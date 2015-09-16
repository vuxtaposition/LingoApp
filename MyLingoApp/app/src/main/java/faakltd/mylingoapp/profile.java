package faakltd.mylingoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class profile extends ActionBarActivity {


    TextView welcome;
    TextView resultView;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        Bundle extras = getIntent().getExtras();
        final String welcomeText = extras.getString("username");

        welcome = (TextView) findViewById(R.id.textView9);
        resultView = (TextView) findViewById(R.id.resultsView);
        logout = (Button) findViewById(R.id.logoutG);

        welcome.setText(""+welcomeText);

        getData();




        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(profile.this, MainActivity.class);

                startActivity(i);

            }
        });







    }



    public void getData() {

        String result = "";
        InputStream isr = null;

        String mymail;

        mymail = welcome.getText().toString();


        InputStream is = null;
        //add paramaters using an arryList key value
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("email", mymail));


        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(
                    "http://lingo.hostei.com/welcome_profile.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
            Log.d("HTTP", "HTTP: OK");

        } catch (Exception e) {
            Log.e("HTTP", "Error in http connection " + e.toString());
        }

        // convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    isr, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            //reads line for line
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            isr.close();

            result = sb.toString();
            //resultView.setText("" + result);

        } catch (Exception e) {
            Log.e("log_tag", "Error  converting result " + e.toString());
        }


        //parse json data
        try {
            String s = "";
            JSONArray jArray = new JSONArray(result);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                s = s +
                        "Name : " + json.getString("fname") + " " + json.getString("lname") + "\n" +
                        "email : " + json.getString("email") + "\n\n" +
                        "Progressed to level : " + json.getString("progress") + "\n  \n";


            }

                resultView.setText("Welcome \n" + s);








        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag", "Error Parsing Data " + e.toString());
        }


    }


}
