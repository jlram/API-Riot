package com.example.eag.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummonerActivity extends AppCompatActivity {

    ImageView mIcon;
    TextView mNombre;
    TextView mID;
    TextView mNivel;
    String URLConsulta;

    ArrayList<Champion> champions = new ArrayList<Champion>();

    ChampionsAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    RecyclerView mRecyclerView;

    String nombre;
    String server;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner);

        mIcon = (ImageView) findViewById(R.id.imageIcon);
        mNombre = (TextView) findViewById(R.id.textSumm);
        mID = (TextView) findViewById(R.id.textID);
        mNivel = (TextView) findViewById(R.id.textLVL);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        if (b != null) {

            nombre = b.getString("nombreExtra");
            nombre = nombre.replace(" ", "");
            server = b.getString("serverExtra");

            URLConsulta = "https://" + server + ".api.riotgames.com/lol/summoner/v3/summoners/by-name/" + nombre  + "?api_key=" + getResources().getString(R.string.API);

        }

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest consulta = new JsonObjectRequest (Request.Method.GET, URLConsulta, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                //JSONObject summ = response.getJSONObject("");
                    String nombre = response.getString("name");
                    int profileIconId = response.getInt("profileIconId");
                    id = response.getString("id");
                    int summonerLevel = response.getInt("summonerLevel");

                    Glide.with(SummonerActivity.this)
                            .load("http://opgg-static.akamaized.net/images/profile_icons/profileIcon" + profileIconId + ".jpg")
                            .override(200,200)
                            .into(mIcon);

                    mNombre.setText(nombre);

                    mID.setText("ID: " + id);

                    mNivel.setText("Nivel: " + summonerLevel);

                } catch (JSONException e) {
                  e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                System.out.println("errorrr");

            }
        });

        queue.add(consulta);
        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
       // champions = Champion.createList(3);
        champions.add(new Champion("xdd", 5, 5, 5, false));

        mLayoutManager = new LinearLayoutManager(this);


        mRecyclerView.setLayoutManager(mLayoutManager);
        List<Champion> listChampions = Arrays.asList(new Champion("Zilean", 3, 3, 3, false),
                                                    new Champion("Bard", 3, 3, 3, false),
                                                    new Champion("Rakan", 3, 3, 3, false));

        mAdapter = new ChampionsAdapter(listChampions);
        mRecyclerView.setAdapter(mAdapter);


    }




}
