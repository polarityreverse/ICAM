package com.example.ankit.icam;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ANKIT on 18-12-2017.
 */

public class MPL3_HFDV extends AppCompatActivity{
    ProgressDialog mProgressView;
    TableLayout MPL3_HFDV_TABLE;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mpl3__hfdv);
        mProgressView = new ProgressDialog(this);
        mProgressView.setMessage("Getting data. It may take a while..");
        mProgressView.show();
        MPL3_HFDV_TABLE = findViewById(R.id.table_main);
        TableRow columnNameRow = new TableRow(this);
        for (int i = 0; i< Constants.MPL3_HFDV_ColumnHead.length; i++) {
            TextView columnName = new TextView(this);
            columnName.setText(Constants.MPL3_HFDV_ColumnHead[i]);
            columnName.setTextColor(Color.WHITE);
            columnName.setGravity(Gravity.CENTER);
            columnName.setPadding(15,10,15,30);
            columnNameRow.addView(columnName);
        }
        MPL3_HFDV_TABLE.isStretchAllColumns();
        MPL3_HFDV_TABLE.addView(columnNameRow, ViewGroup.LayoutParams.WRAP_CONTENT, 50);
        getData();
    }
    public void init(ArrayList<String> dataRec) {
        TableRow dataRow = new TableRow(this);
        for (int j = 0; j < Constants.MPL3_HFDV_ColumnHead.length; j++) {
            TextView dataPoint = new TextView(this);
            dataPoint.setText(dataRec.get(j));
            dataPoint.setTextColor(Color.WHITE);
            dataPoint.setGravity(Gravity.CENTER);
            dataRow.addView(dataPoint);
        }
        MPL3_HFDV_TABLE.addView(dataRow);
    }



    public void getData() {
        final StringRequest mpl3_hfdv_Request = new StringRequest(Request.Method.GET, Constants.MPL3_HFDV_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("Response", response.toString());
                try {
                    JSONArray baseArray = new JSONArray(response);
                    for (int i = 1; i < baseArray.length(); i++) {
                        ArrayList<String> data = new ArrayList<>();
                        JSONObject baseObject = baseArray.getJSONObject(i);

                        for(int j = 0; j < Constants.MPL3_HFDV_ColumnHead.length; j++){
                            if(baseObject.has(Constants.MPL3_HFDV_ColumnHead[j])){
                                data.add(baseObject.getString(Constants.MPL3_HFDV_ColumnHead[j]));
                            }else{
                                continue;
                            }

                        }
                        Log.v("DataArray", data.toString());
                        mProgressView.dismiss();
                        init(data);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mProgressView.dismiss();
                String message = null;
                if (error instanceof NetworkError) {
                    message = "Cannot connect to Internet. Please check your connection!!";
                } else if (error instanceof ServerError) {
                    message = "Server down. Please try again after some time!!";
                } else if (error instanceof AuthFailureError) {
                    message = "Authentication error!!";
                } else if (error instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (error instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
        mpl3_hfdv_Request.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(mpl3_hfdv_Request);

    }
}

