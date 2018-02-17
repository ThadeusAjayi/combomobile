package com.shopspreeng.combocard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.shopspreeng.Utils.StaticUtils;


public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_IDP_RESPONSE = "extra_idp_response";
    private static final String EXTRA_SIGNED_IN_CONFIG = "extra_signed_in_config";

    FirebaseAuth fbUser = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //TODO select start or continue game

        if (fbUser.getCurrentUser() != null) {
            Toast.makeText(this, fbUser.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
        }

    }

    public void startNew(View view) {
        startActivity(new Intent(this, NewContinueGame.class)
                .putExtra(StaticUtils.OLD_NEW_GAME, getString(R.string.new_game)));
    }

    public void continueGame(View view) {
        startActivity(new Intent(this, NewContinueGame.class)
                .putExtra(StaticUtils.OLD_NEW_GAME, getString(R.string.continue_game)));
    }


    public void logout(View view) {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                    }
                });
    }

}
