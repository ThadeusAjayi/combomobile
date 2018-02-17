package com.shopspreeng;

import android.app.Application;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.firebase.auth.FirebaseAuth;

import java.net.URISyntaxException;

/**
 * Created by Thadeus on 1/25/2018.
 */

public class ComboCardApp extends Application {

    private static ComboCardApp mInstance;
    public Socket mSocket;
    public FirebaseAuth firebaseAuth;

    {
        try {
            mSocket = IO.socket("https://io-chat-socket.herokuapp.com/");
        } catch (URISyntaxException e) {
        }
    }

    public static synchronized ComboCardApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        mSocket.connect();
        firebaseAuth.getInstance().getCurrentUser();
    }
}
