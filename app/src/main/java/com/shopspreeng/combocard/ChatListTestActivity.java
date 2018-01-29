package com.shopspreeng.combocard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.shopspreeng.ComboCardApp;
import com.shopspreeng.model.SampleChatListModel;
import com.shopspreeng.model.SampleChatModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChatListTestActivity extends AppCompatActivity {

    ListView existingChat;
    ArrayList<String> allChatList = new ArrayList<>();
    ArrayList<SampleChatModel> conversation = new ArrayList<>();
    Socket sock = ComboCardApp.getInstance().mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list_test);
        existingChat = findViewById(R.id.chat_lv);

        sock.emit("setLoggedUserEmail", "ainojie@gmail.com");
        sock.on("returnAllChats", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONArray chatArr = (JSONArray) args[0];
                        SampleChatListModel samp = null;
                        Gson gson = new Gson();

                        for (int i = 0; i < chatArr.length(); i++) {
                            try {
                                samp = gson.fromJson(chatArr.getString(i), SampleChatListModel.class);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Log.v("_ID " + i, samp.get_id());
                            allChatList.add(samp.get_id());
                        }
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, allChatList);
                        existingChat.setAdapter(arrayAdapter);
                    }

                });
            }
        });


        existingChat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "" + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                sock.emit("getChat", parent.getItemAtPosition(position));
                sock.on("getChat", new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {

                        JSONArray converse = new JSONArray();
                        JSONArray chatArr = (JSONArray) args[0];
                        try {
                            JSONObject chatMsgArr = (JSONObject) chatArr.get(0);
                            Log.v("ChatObj", chatMsgArr.toString());
                            converse = (JSONArray) chatMsgArr.get("chatmessages");
                            Log.v("Converse", converse.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        SampleChatModel samp = null;
                        Gson gson = new Gson();

                        for (int i = 0; i < converse.length(); i++) {
                            try {
                                samp = gson.fromJson(converse.getString(i), SampleChatModel.class);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Log.v("chats " + i, samp.toString());
                            conversation.add(samp);

                        }
                        Log.v("before send", String.valueOf(conversation));
                        startActivity(new Intent(ChatListTestActivity.this, ChatTestLayout.class).putParcelableArrayListExtra("conversation", conversation));
                    }
                });
            }
        });

    }
}
