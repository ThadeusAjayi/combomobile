package com.shopspreeng.combocard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shopspreeng.adapter.PlayerListAdapter;

public class GameSetup extends AppCompatActivity {

    final static String TWO_PLAYERS = "two_players";
    final static String THREE_PLAYERS = "three_players";
    final static String FOUR_PLAYERS = "four_players";

    RecyclerView playerListRecycler;
    PlayerListAdapter playerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);

        playerListRecycler = findViewById(R.id.player_recycler);

        playerListRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        playerListAdapter = new PlayerListAdapter(this);

        playerListRecycler.setAdapter(playerListAdapter);

        //TODO populate a list of all players and sort list by online and online time
        //TODO make selection of upto 3 players and pass in ArrayList;

    }
}
