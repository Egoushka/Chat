package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etAuthor;
    private TextView tvChatBox;
    private TextView tvAuthor;
    private EditText etMessage;

    private String authorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAuthor = findViewById(R.id.etAuthor);
        tvChatBox = findViewById(R.id.tvChatBox);
        tvAuthor = findViewById(R.id.tvEtAuthor);
        etMessage = findViewById(R.id.etMessage);

        // Author name -> textView
        authorName = etAuthor.getText().toString();
        tvAuthor.setText(getString(R.string.author_display, authorName));

        tvChatBox.setMovementMethod(new ScrollingMovementMethod());

        //software keyboard ->
        // 1. Manifest -> Activity -> android:windowSoftInputMode= "adjustResize
        // 2. activity.xml -> TextView ->
        // app:andoid:layout_height="0dp"
        // app:layout_constraintHeight_percent=".45"

    }
    public void setAuthorClick(View view){
        String authorName = etAuthor.getText().toString();
        if(authorName.equals(R.string.empty_string)){
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_imput,
                    Toast.LENGTH_SHORT
            ).show();
        }
        this.authorName = authorName;
        tvAuthor.setText((getString(R.string.author_display, this.authorName)));
    }

    public void sendMessageClick(View view) {
        String message = etMessage.getText().toString();
        if(message.equals(R.string.empty_string)){
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_imput,
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }
        tvChatBox.append(authorName + getString(R.string.dash) + message + '\n');
        etMessage.setText(R.string.empty_string);
    }
}