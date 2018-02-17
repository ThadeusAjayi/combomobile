package com.shopspreeng.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.shopspreeng.combocard.R;
import com.shopspreeng.model.UserModel;

import java.util.ArrayList;

/**
 * Created by ainoj on 2/11/2018.
 */

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.PlayerListViewHolder>{

    ArrayList<UserModel> allPlayers;
    Context context;
    LayoutInflater layoutInflater;


    public PlayerListAdapter (Context context) {
        this.context = context;
    }

    public void setAllPlayers(ArrayList<UserModel> userModelArrayList) {
        allPlayers.addAll(userModelArrayList);
        notifyDataSetChanged();
    }

    @Override
    public PlayerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = layoutInflater.from(context).inflate(R.layout.available_players_list, parent, false);

        return new PlayerListViewHolder(root);
    }

    @Override
    public void onBindViewHolder(PlayerListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return allPlayers != null? allPlayers.size() : 0;
    }

    public class PlayerListViewHolder extends RecyclerView.ViewHolder {

        ImageView playerImage;
        TextView playerName;
        RatingBar ratingBar;

        public PlayerListViewHolder(View itemView) {
            super(itemView);
            playerImage = itemView.findViewById(R.id.player_img);
            playerName = itemView.findViewById(R.id.player_name);
            ratingBar = itemView.findViewById(R.id.player_rating);
        }
    }
}
