package com.example.tictactoe.ui;

import static com.example.tictactoe.ui.AddPlayersActivity.player1;
import static com.example.tictactoe.ui.AddPlayersActivity.player2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoe.R;
import com.example.tictactoe.databinding.ActivityPlaygroundBinding;

import java.util.ArrayList;
import java.util.List;

public class PlaygroundActivity extends AppCompatActivity {

    private final List<int[]> combinationList = new ArrayList<>();
    ActivityPlaygroundBinding binding;
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //9 zero
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaygroundBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{2, 4, 6});
        combinationList.add(new int[]{0, 4, 8});

        String playerOneName = getIntent().getStringExtra(player1);
        String playerTwoName = getIntent().getStringExtra(player2);

        binding.playerOneName.setText(playerOneName);
        binding.playerTwoName.setText(playerTwoName);
        changePlayerTurn(1);

    }

    public void onClick(View view) {
        int tag = Integer.parseInt((String) view.getTag());
        if (isBoxSelectable(tag)) {
            performAction((ImageView) view, tag);

        }
    }

    public void onClickReset(View view) {
       restartMatch();
    }

    private void performAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;
        switch (playerTurn) {
            case 1: {
                imageView.setImageResource(R.drawable.x);
                if (checkResults()) {
                    showResultDialog(binding.playerOneName.getText().toString() + " " + getString(R.string.winner));
                } else if (totalSelectedBoxes == 9) {
                    showResultDialog("Match Draw");
                } else {
                    changePlayerTurn(2);
                    totalSelectedBoxes++;
                }
                break;
            }
            case 2: {
                imageView.setImageResource(R.drawable.o);
                if (checkResults()) {
                    showResultDialog(binding.playerTwoName.getText().toString() + " " + getString(R.string.winner));
                } else if (totalSelectedBoxes == 9) {
                    showResultDialog("Match Draw");
                } else {
                    changePlayerTurn(1);
                    totalSelectedBoxes++;
                }
                break;

            }
        }

    }

    private void showResultDialog(String message) {
        ResultDialog resultDialog = new ResultDialog(this, message, PlaygroundActivity.this);
        resultDialog.setCancelable(false);
        resultDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        resultDialog.show();
    }

    private boolean checkResults() {
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++) {
            final int[] combination = combinationList.get(i);
            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn &&
                    boxPositions[combination[2]] == playerTurn) {
                response = true;
            }
        }
        return response;
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1) {
            binding.playerOneName.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoName.setBackgroundResource(R.drawable.blue_border);
        } else {
            binding.playerTwoName.setBackgroundResource(R.drawable.black_border);
            binding.playerOneName.setBackgroundResource(R.drawable.blue_border);
        }
    }


    private boolean isBoxSelectable(int boxPosition) {
        return (boxPositions[boxPosition] == 0);
    }

    public void restartMatch() {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}; //9 zero
        playerTurn = 1;
        changePlayerTurn(1);
        totalSelectedBoxes = 1;
        binding.box0.setImageResource(R.drawable.holder);
        binding.box1.setImageResource(R.drawable.holder);
        binding.box2.setImageResource(R.drawable.holder);
        binding.box3.setImageResource(R.drawable.holder);
        binding.box4.setImageResource(R.drawable.holder);
        binding.box5.setImageResource(R.drawable.holder);
        binding.box6.setImageResource(R.drawable.holder);
        binding.box7.setImageResource(R.drawable.holder);
        binding.box8.setImageResource(R.drawable.holder);
    }
}