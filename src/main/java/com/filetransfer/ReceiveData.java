package com.filetransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ReceiveData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        ClientSocket clientSocket = new ClientSocket(ReceiveData.this) ;
        clientSocket.run();
    }
}
