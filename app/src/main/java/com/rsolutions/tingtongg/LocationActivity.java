package com.rsolutions.tingtongg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapter.LocationListAdapter;
import app.AppController;
import model.Locations;

public class LocationActivity extends AppCompatActivity {

    private static final String TAG = LocationActivity.class.getSimpleName();
    private static final String url = "http://beta.json-generator.com/api/json/get/EJULLr8Jx";
    String[] values = new String[]{"Colaba",
            "Bandra",
            "Ballard Estate",
            "Churchgate",
            "Malabar Hill",
            "Lower Parel",
            "Dadar"
    };
    private ProgressDialog pDialog;
    private List<Locations> LocationsList= new ArrayList<Locations>();
    private ListView listView;
    private LocationListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        listView = (ListView) findViewById(R.id.LocationList);
        adapter = new LocationListAdapter(this,LocationsList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String locSelect = ((TextView) view).getText().toString();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
            }
        });

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest serviceReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Locations locations = new Locations();
                                locations.setLocation_nm(obj.getString("location_nm"));
//                                services.setThumbnailUrl(obj.getString("image"));
//                                services.setDetails(obj.getString("details"));



                                // adding service to service array
                                LocationsList.add(locations);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });


        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(serviceReq);


//        ListView locationList = (ListView)findViewById(R.id.LocationList);
//        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,values);
//        locationList.setAdapter(adapter);
//
//        locationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String locSelect=((TextView)view).getText().toString();
//                Intent i = new Intent(getApplicationContext(),MainActivity.class);
//                i.putExtra("Available services in"+"locSelect",locSelect);
//                startActivity(i);
//            }
//        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
