package com.example.eag.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView mIcon;

    private EditText mEditUser;

    private Spinner mSpinner;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIcon = (ImageView) findViewById(R.id.YCLImage);

        mEditUser = (EditText) findViewById(R.id.editUser);

        mSpinner = (Spinner) findViewById(R.id.spinner);

        mButton = (Button) findViewById(R.id.button);

        /**
         * Listener del boton de la actividad principal,
         * mandando los valores del nombre y del servidor.
         */
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean user = false;
                boolean pwd = false;

                if (!mEditUser.getText().toString().trim().equals("")) {
                    user = true;
                }

                if (!mSpinner.getSelectedItem().toString().equals("Select a server...")) {
                    pwd = true;
                }

                if (user == true && pwd == true) {
                    Intent i = new Intent(MainActivity.this, SummonerActivity.class);

                    i.putExtra("nombreExtra", mEditUser.getText().toString());
                    i.putExtra("serverExtra", mSpinner.getSelectedItem().toString());
                    startActivity(i);
                } else {
                    if (user == false) {
                        Toast.makeText(getApplicationContext(), "Introduce un usuario", Toast.LENGTH_SHORT).show();
                    }

                    if (pwd == false) {
                        Toast.makeText(getApplicationContext(), "Elige un servidor.", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

    }
}
