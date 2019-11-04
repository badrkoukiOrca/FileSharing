package com.filetransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button server;
    Button client ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        server = findViewById(R.id.server);
        client = findViewById(R.id.client) ;

        server.setOnClickListener(this);
        client.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.server:
                startActivity(new Intent(MainActivity.this,SendFile.class));
                break;
            case R.id.client:
                startActivity(new Intent(MainActivity.this,ReceiveData.class));
                break;
                default:
                    break;
        }
    }
}
