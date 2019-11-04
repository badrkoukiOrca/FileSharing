package com.filetransfer;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {


    private final Context context;

    public ServerThread(Context context){
        this.context = context ;
    }


    @Override
    public void run() {
        try{
            final ServerSocket server = new ServerSocket();
            server.setReuseAddress(true);
            server.bind(new InetSocketAddress(2020));
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        Socket client = server.accept();
                        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
                        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
                        while (true) {
                            dataOutputStream.writeUTF("badreddine...");
                            dataOutputStream.flush();
                            Thread.sleep(2000);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            };

            thread.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}