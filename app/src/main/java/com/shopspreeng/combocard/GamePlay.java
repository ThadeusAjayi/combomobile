package com.shopspreeng.combocard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.shopspreeng.Utils.CardUtils;
import com.shopspreeng.model.CardModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GamePlay extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {

    ArrayList<CardModel> deckCards = new ArrayList<>();
    ArrayList<CardModel> player_1_cards = new ArrayList<>();
    ArrayList<CardModel> player_2_cards = new ArrayList<>();
    ArrayList<CardModel> player_3_cards = new ArrayList<>();
    ArrayList<CardModel> player_4_cards = new ArrayList<>();

    ImageView p1c1, p1c2, p1c3, p1c4, p1c5;
    ImageView p2c1, p2c2, p2c3, p2c4, p2c5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_play);

        if (savedInstanceState != null) {
            //TODO restore current game play
        } else {
            //TODO initialize new game cards
            ArrayList<CardModel> singleCards = new CardUtils.SingleCard().singleCard;
            Log.v("Single Card List", String.valueOf(singleCards));
            Log.v("Single Card Size", String.valueOf(singleCards.size()));

            ArrayList<CardModel> compoundCards = new CardUtils.CompoundCard().compound;
            Log.v("Compound Card List", String.valueOf(compoundCards));
            Log.v("Compound Card Size", String.valueOf(compoundCards.size()));

            //TODO determine card sharing by the number of players
            initViews();
            setDragListenersAndLongClickListenersOnViews(this);
            initialCardShare(2, compoundCards);
        }


        //TODO share cards to players


    }

    void initViews() {
        p1c1 = findViewById(R.id.p1c1);
        p1c2 = findViewById(R.id.p1c2);
        p1c3 = findViewById(R.id.p1c3);
        p1c4 = findViewById(R.id.p1c4);
        p1c5 = findViewById(R.id.p1c5);

        p2c1 = findViewById(R.id.p2c1);
        p2c2 = findViewById(R.id.p2c2);
        p2c3 = findViewById(R.id.p2c3);
        p2c4 = findViewById(R.id.p2c4);
        p2c5 = findViewById(R.id.p2c5);
    }

    private void setDragListenersAndLongClickListenersOnViews(GamePlay gamePlay) {
        p1c1.setOnDragListener(gamePlay);
        p1c2.setOnDragListener(gamePlay);
        p1c3.setOnDragListener(gamePlay);
        p1c4.setOnDragListener(gamePlay);
        p1c5.setOnDragListener(gamePlay);

        p2c1.setOnDragListener(gamePlay);
        p2c2.setOnDragListener(gamePlay);
        p2c3.setOnDragListener(gamePlay);
        p2c4.setOnDragListener(gamePlay);
        p2c5.setOnDragListener(gamePlay);
        //TODO set DragListener for Card deck and Pass card


        p1c1.setOnLongClickListener(gamePlay);
        p1c2.setOnLongClickListener(gamePlay);
        p1c3.setOnLongClickListener(gamePlay);
        p1c4.setOnLongClickListener(gamePlay);
        p1c5.setOnLongClickListener(gamePlay);

        p2c1.setOnLongClickListener(gamePlay);
        p2c2.setOnLongClickListener(gamePlay);
        p2c3.setOnLongClickListener(gamePlay);
        p2c4.setOnLongClickListener(gamePlay);
        p2c5.setOnLongClickListener(gamePlay);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button.
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void initialCardShare(int numOfPlayers, ArrayList<CardModel> compoundCards) {

        Random cardRandom = new Random();


        if (numOfPlayers == 2) {
            while (player_1_cards.size() < 4) {
                int index = cardRandom.nextInt(compoundCards.size());
                player_1_cards.add(compoundCards.get(index));
                compoundCards.remove(compoundCards.get(index));
                index = cardRandom.nextInt(compoundCards.size());
                player_2_cards.add(compoundCards.get(index));
                compoundCards.remove(compoundCards.get(index));
            }
            deckCards.addAll(compoundCards);
            Log.v("Deck", String.valueOf(compoundCards.size()));
            ClipboardManager clipboard = (ClipboardManager)  getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("copy", String.valueOf(compoundCards));
            clipboard.setPrimaryClip(clip);
            Log.v("player 1 size", String.valueOf(player_1_cards.size()));
            Log.v("player 2 size", String.valueOf(player_2_cards.size()));
            setCardsIntoPlayerLayout(2);
        }

        if (numOfPlayers == 3) {
            while (player_1_cards.size() < 4) {
                int index = cardRandom.nextInt(compoundCards.size());
                player_1_cards.add(compoundCards.get(index));
                compoundCards.remove(compoundCards.get(index));
                index = cardRandom.nextInt(compoundCards.size());
                player_2_cards.add(compoundCards.get(index));
                compoundCards.remove(compoundCards.get(index));
                index = cardRandom.nextInt(compoundCards.size());
                player_3_cards.add(compoundCards.get(index));
                compoundCards.remove(compoundCards.get(index));
            }
            deckCards.addAll(compoundCards);
        }

        if (numOfPlayers == 4) {
            while (player_1_cards.size() < 4) {
                int index = cardRandom.nextInt(compoundCards.size());
                player_1_cards.add(compoundCards.get(index));
                compoundCards.remove(compoundCards.get(index));
                index = cardRandom.nextInt(compoundCards.size());
                player_2_cards.add(compoundCards.get(index));
                compoundCards.remove(compoundCards.get(index));
                index = cardRandom.nextInt(compoundCards.size());
                player_3_cards.add(compoundCards.get(index));
                compoundCards.remove(compoundCards.get(index));
                index = cardRandom.nextInt(compoundCards.size());
                player_4_cards.add(compoundCards.get(index));
                compoundCards.remove(compoundCards.get(index));
            }
            deckCards.addAll(compoundCards);
        }

    }

    private void setCardsIntoPlayerLayout(int numOfPlayers) {
        ImageView p1Holder [] = {p1c1, p1c2, p1c3, p1c4};
        ImageView p2Holder [] = {p2c1, p2c2, p2c3, p2c4};
        if (numOfPlayers == 2) {
            for (int x = 0; x < player_1_cards.size(); x++) {
                p1Holder[x].setTag(player_1_cards.get(x).getCardNum());
            }
            for (int y = 0; y < player_2_cards.size(); y++) {
                p2Holder[y].setTag(player_2_cards.get(y).getCardNum());
            }
        }
    }


    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {

        Toast.makeText(this, String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public boolean onLongClick(View view) {
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                view);
        view.startDrag(new ClipData((ClipData) view.getTag()), shadowBuilder, view, 0);

        return true;
    }

}
