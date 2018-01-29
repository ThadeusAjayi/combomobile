package com.shopspreeng.combocard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.shopspreeng.ComboCardApp;
import com.shopspreeng.adapter.ChatAdapter;
import com.shopspreeng.model.SampleChatListModel;
import com.shopspreeng.model.SampleChatModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChatTestLayout extends AppCompatActivity {

    ImageButton sendBtn;
    TextInputEditText inputEditText;
    RecyclerView rv;
    ArrayList<SampleChatModel> chatlist = new ArrayList<>();
    ChatAdapter chatAdapter;
    Socket sock = ComboCardApp.getInstance().mSocket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_test_layout);
        chatAdapter = new ChatAdapter(this);

        if (getIntent().getExtras() != null) {
            chatlist = getIntent().getExtras().getParcelableArrayList("conversation");
            Log.v("chatlist", String.valueOf(chatlist));

            rv = findViewById(R.id.chat_list_rv);

            rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            rv.setAdapter(chatAdapter);

            chatAdapter.setChatList(chatlist);
        }

        sendBtn = findViewById(R.id.imageButton);
        inputEditText = findViewById(R.id.textInputEditText);

        sendBtn.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String message = inputEditText.getText().toString();
                sock.emit("chatMessage", new SampleChatModel(message, "ainojie@gmail.com"));
                inputEditText.setText("");

            }
        });

        sock.on("chatMessage", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject chatArr = (JSONObject) args[0];
                    }

                });
            }
        });




    }

}
