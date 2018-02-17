package com.shopspreeng.Utils;

import com.shopspreeng.combocard.R;
import com.shopspreeng.model.CardModel;

import java.util.ArrayList;

/**
 * Created by Thadeus on 1/25/2018.
 */

public class CardUtils {

    public static class SingleCard {

        private int count;

        private String mCardText [] = {"amulet", "castleship", "gold", "diamond", "robe", "pearl"};

        private int mCardResource;

        int amulet[] = {0, 1, 5};
        int castleship[] = {-1, 0, 2};
        int gold[] = {-3, 2, 1};
        int diamond[] = {-2, 3, 4};
        int robe[] = {-4, 3, -2};
        int pearl[]  = {-4, -5, 4};

        public ArrayList<CardModel> singleCard = new ArrayList<>();

        public SingleCard () {

            count = 0;
            while (count < amulet.length) {
                int cardResource = setmCardResource(mCardText[0]);
                singleCard.add(new CardModel(cardResource, mCardText[0], amulet[count]));
                count++;
            }

            count = 0;
            while (count < castleship.length) {
                int cardResource = setmCardResource(mCardText[1]);
                singleCard.add(new CardModel(cardResource, mCardText[1], castleship[count]));
                count++;
            }

            count = 0;
            while (count < gold.length) {
                int cardResource = setmCardResource(mCardText[2]);
                singleCard.add(new CardModel(cardResource, mCardText[2], gold[count]));
                count++;
            }

            count = 0;
            while (count < diamond.length) {
                int cardResource = setmCardResource(mCardText[3]);
                singleCard.add(new CardModel(cardResource, mCardText[3], diamond[count]));
                count++;
            }

            count = 0;
            while (count < robe.length) {
                int cardResource = setmCardResource(mCardText[4]);
                singleCard.add(new CardModel(cardResource, mCardText[4], robe[count]));
                count++;
            }

            count = 0;
            while (count < pearl.length) {
                int cardResource = setmCardResource(mCardText[5]);
                singleCard.add(new CardModel(cardResource, mCardText[5], pearl[count]));
                count++;
            }

        }

        public int setmCardResource(String cardText) {
            switch (cardText) {
                case "amulet":
                    mCardResource = R.drawable.arrow;
                    break;
                case "castleship":
                    mCardResource = R.drawable.axe;
                    break;
                case "gold":
                    mCardResource = R.drawable.doubleaxe;
                    break;
                case "diamond":
                    mCardResource = R.drawable.hammer;
                    break;
                case "robe":
                    mCardResource = R.drawable.javelin;
                    break;
                case "pearl":
                    mCardResource = R.drawable.sword;
                    break;
                default:
                    break;
            }

            return mCardResource;
        }
    }

    public static class CompoundCard {

        private int count;

        private String mCardText[] = {"springfield_rifle", "boomerang", "magnet", "fireball", "bayonet", "pepperbox_pistol"};

        private int mCardResource;


        int spring[] = {-4, 3, -1, 2, 1, -2, -5};
        int boom[] = {0, 4, -3, 1, -4, -1, 5};
        int mag[] = {2, 3, -5, 1, -2, 4, 5};
        int fire[] = {0, -2, -3, 5, -4, -2, -5};
        int bay[] = {1, 5, 3, -4, 3, -1, 4};
        int pepper[] = {-1, 2, -3, 4, -3, 2, -5};

        public ArrayList<CardModel> compound = new ArrayList<CardModel>();


        public CompoundCard() {

            count = 0;
            while (count < spring.length) {
                int cardResource = setmCardResource(mCardText[0]);
                compound.add(new CardModel(cardResource, mCardText[0], spring[count]));
                count++;
            }

            count = 0;
            while (count < boom.length) {
                int cardResource = setmCardResource(mCardText[1]);
                compound.add(new CardModel(cardResource, mCardText[1], boom[count]));
                count++;
            }

            count = 0;
            while (count < mag.length) {
                int cardResource = setmCardResource(mCardText[2]);
                compound.add(new CardModel(cardResource, mCardText[2], mag[count]));
                count++;
            }

            count = 0;
            while (count < fire.length) {
                int cardResource = setmCardResource(mCardText[3]);
                compound.add(new CardModel(cardResource, mCardText[3], fire[count]));
                count++;
            }

            count = 0;
            while (count < bay.length) {
                int cardResource = setmCardResource(mCardText[4]);
                compound.add(new CardModel(cardResource, mCardText[4], bay[count]));
                count++;
            }

            count = 0;
            while (count < pepper.length) {
                int cardResource = setmCardResource(mCardText[5]);
                compound.add(new CardModel(cardResource, mCardText[5], pepper[count]));
                count++;
            }

        }


        public int setmCardResource(String cardText) {
            switch (cardText) {
                case "springfield_rifle":
                    mCardResource = R.drawable.arrow;
                    break;
                case "boomerang":
                    mCardResource = R.drawable.axe;
                    break;
                case "magnet":
                    mCardResource = R.drawable.doubleaxe;
                    break;
                case "fireball":
                    mCardResource = R.drawable.hammer;
                    break;
                case "bayonet":
                    mCardResource = R.drawable.javelin;
                    break;
                case "pepperbox_pistol":
                    mCardResource = R.drawable.sword;
                    break;
                default:
                    break;
            }

            return mCardResource;
        }
    }

}
