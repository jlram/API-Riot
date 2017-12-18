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

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, SummonerActivity.class);

                i.putExtra("nombreExtra", mEditUser.getText().toString());
                i.putExtra("serverExtra", mSpinner.getSelectedItem().toString());

                    startActivity(i);
                

            }
        });

    }
}
