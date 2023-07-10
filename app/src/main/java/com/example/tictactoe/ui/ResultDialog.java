package com.example.tictactoe.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.tictactoe.R;

public class ResultDialog extends Dialog {

    private final String message;
    private final PlaygroundActivity playgroundActivity;

    public ResultDialog(@NonNull Context context, String message, PlaygroundActivity playgroundActivity) {
        super(context);
        this.message = message;
        this.playgroundActivity = playgroundActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);
        TextView messageText = findViewById(R.id.messageText);
        Button startAgainButton = findViewById(R.id.startAgainButton);
        messageText.setText(message);
        startAgainButton.setOnClickListener(view -> {
            playgroundActivity.restartMatch();
            dismiss();
        });
    }
}