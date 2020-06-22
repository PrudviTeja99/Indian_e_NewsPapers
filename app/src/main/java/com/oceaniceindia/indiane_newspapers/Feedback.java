package com.oceaniceindia.indiane_newspapers;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Feedback extends AppCompatActivity {
    String mymail="oceaniceindia@gmail.com,oceaniclabsdevelopment@gmail.com";
    String mymails[]=mymail.split(",");
    String subject="Feedback of OnlineNewsPapers";
    EditText msg;
    Button send;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        msg=findViewById(R.id.message);
        send=findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=msg.getText().toString();
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,mymails);
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,message);
                intent.setType("message/rfc822");
                startActivity(intent);
            }
        });
    }
}