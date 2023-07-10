package com.example.tictactoe.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tictactoe.R;
import com.example.tictactoe.databinding.ActivityAddPlayersBinding;
public class AddPlayersActivity extends AppCompatActivity {

    static String player1 = "playerOne";
    static String player2 = "playerTwo";
    ActivityAddPlayersBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPlayersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startGameButton.setOnClickListener(view -> {
            String playerOneName = binding.playerOne.getText().toString();
            String playerTwoName = binding.playerTwo.getText().toString();



            if (playerOneName.isEmpty()) {
                Toast.makeText(AddPlayersActivity.this, getString(R.string.please_enter_player_1_name), Toast.LENGTH_SHORT)
                        .show();
            } else if (playerTwoName.isEmpty()) {
                Toast.makeText(AddPlayersActivity.this, getString(R.string.please_enter_player_2_name), Toast.LENGTH_SHORT)
                        .show();
            } else {
                Intent intent = new Intent(AddPlayersActivity.this, PlaygroundActivity.class);
                intent.putExtra(player1, playerOneName);
                intent.putExtra(player2, playerTwoName);
                startActivity(intent);

            }
        });

    }
}