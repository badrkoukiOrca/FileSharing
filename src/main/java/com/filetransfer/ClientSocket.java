package com.filetransfer;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientSocket  implements  Runnable{

    private final Context context;

    public ClientSocket(Context context){
        this.context = context ;
    }

    @Override
    public void run() {



            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        Socket client = new Socket("192.168.43.1",2020);
                        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
                        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
                        while (true){
                            final String message = dataInputStream.readUTF();
                            final Activity activity = (Activity) context ;

                            activity.runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast.makeText(activity,message,Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            thread.start();




    }
}
