package com.shopspreeng.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shopspreeng.combocard.R;
import com.shopspreeng.model.SampleChatModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Thadeus on 1/27/2018.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{

    private Context context;
    private ArrayList<SampleChatModel> chatList = new ArrayList<>();
    private LayoutInflater inflater;

    public ChatAdapter(){}


    public ChatAdapter (Context context) {
        this.context = context;
    }

    public void setChatList (ArrayList<SampleChatModel> chatlist) {
        this.chatList = chatlist;
        notifyDataSetChanged();
    }

    public void addToChat (SampleChatModel chatitem) {
        this.chatList.add(chatitem);
        notifyDataSetChanged();
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = inflater.from(context).inflate(R.layout.content_chat_layout, parent,false);

        return new ChatViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        SampleChatModel chat = chatList.get(position);
        holder.message.setText(chat.getMessage());
        holder.sender.setText(chat.getSender());

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {

        TextView message, sender;

        public ChatViewHolder(View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message_tv);
            sender = itemView.findViewById(R.id.sender_tv);

        }
    }

    public SampleChatModel readAssets () {

        String json = null;
        try {
            InputStream is = context.getAssets().open("sampleChat.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Log.v("Assets Read", String.valueOf(new Gson().fromJson(json,SampleChatModel.class)));
        return new Gson().fromJson(json,SampleChatModel.class);
    }

}
