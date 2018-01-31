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
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

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

    int id;

    List<Champion> listChampions = new ArrayList<Champion>();

    String URLConsulta2;

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

        /*
        * En caso de que b no este vacio, cargamos el nombre y el servidor para meterlos en la URL de la consulta
        * */
        if (b != null) {

            nombre = b.getString("nombreExtra");
            nombre = nombre.replace(" ", "");
            server = b.getString("serverExtra");

            URLConsulta = "https://" + server + ".api.riotgames.com/lol/summoner/v3/summoners/by-name/" + nombre  + "?api_key=" + getResources().getString(R.string.API);

        }

        final RequestQueue queue = Volley.newRequestQueue(this);

        /*
        * Primera consulta a la API de Riot. En este caso obtendremos informacion de un jugador introduciendo su nombre de usuario.
        */
        final JsonObjectRequest consulta = new JsonObjectRequest (Request.Method.GET, URLConsulta, null, new Listener<JSONObject>() {
            /**
             * Asignamos en activity_summoner.xml un icono, obtenido gracias al ID de icono en la API de Riot y a un link facilitado por ellos.
             * He usado la libreria externa Glide a la hora de la asignacion.
             *
             * Tambien asigna un nombre al TextView principal de la actividad, un ID de usuario y un Nivel de Jugador.
             *
             * @param response
             */
            @Override
            public void onResponse(JSONObject response) {

                try {

                    String nombre = response.getString("name");
                    int profileIconId = response.getInt("profileIconId");
                    id = response.getInt("id");
                    int summonerLevel = response.getInt("summonerLevel");


                    Glide.with(SummonerActivity.this)
                            .load("http://opgg-static.akamaized.net/images/profile_icons/profileIcon" + profileIconId + ".jpg")
                            .override(200,200)
                            .into(mIcon);

                    mNombre.setText(nombre);

                    mID.setText("ID: " + id);

                    mNivel.setText("Level: " + summonerLevel);

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

        /**
         * Principal problema comentado en clase. No he sido capaz de cargar en cola una consulta recien terminada otra.
         * Al poner <<queue.add(consulta2);>> dentro del onResponse de la primera consulta no obtenia nada ni me entraba el
         * onResponse de la consulta2, por lo que he decidido dejarlo como estaba y poner una key por defecto, 32148910,
         * correspondiente al jugador "Pablito Terrores".
         * */
        URLConsulta2 = "https://euw1.api.riotgames.com/lol/champion-mastery/v3/champion-masteries/by-summoner/32148910?api_key=" + getResources().getString(R.string.API);

        final JsonArrayRequest consulta2 = new JsonArrayRequest (Request.Method.GET, URLConsulta2, null, new Listener<JSONArray>() {
            /**
             * Creo objetos Champion por cada campeon asociado al jugador con el cual haya conseguido un nivel de habilidad
             * 5 o mayor (max 7). Añado estos datos a la lista de Champions, la cual sera asociada mas tarde con el Recycler View.
             *
             */
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for (int i = 0; i< response.length();i++) {
                        JSONObject c = response.getJSONObject(i);

                        //Hago este filtro ya que solo es relevante en un jugador que su nivel con
                        //un personaje sea mayor de 4
                        if(c.getInt("championLevel")>4){

                            Champion c1 = new Champion("Champion",
                                    c.getInt("championId"),
                                    c.getInt("championLevel"),
                                    c.getInt("championPoints"),
                                    c.getBoolean("chestGranted"));

                            listChampions.add(c1);

                        }
                    }

                    //Creacion del LayoutManager
                    mLayoutManager = new LinearLayoutManager(getParent());
                    //Asociacion del LayoutManager con nuestro Recycler View.
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    //Asociacion del Adaptador con el arraylist listChampions
                    mAdapter = new ChampionsAdapter(listChampions);
                    //Asociacion del recycler view con nuestro adaptador.
                    mRecyclerView.setAdapter(mAdapter);

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
        /**
         * Cola de consultas.
         */
        queue.add(consulta);
        queue.add(consulta2);

    }
}
