package com.example.yanal.knowyourhero.Views;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanal.knowyourhero.Models.yaMarvelCharacter;
import com.example.yanal.knowyourhero.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class yaDetailActivity extends AppCompatActivity {

    private yaMarvelCharacter character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ya_detail);

        Intent intent = getIntent();

        Parcelable receivedCharacter = intent.getParcelableExtra("character");
        character = (yaMarvelCharacter) receivedCharacter;

        TextView txtName = (TextView) findViewById(R.id.txtDetailName);
        txtName.setText(UTF8toISO(character.getName()));

        TextView txtDescription = (TextView) findViewById(R.id.txtDetailDescription);
        txtDescription.setText(UTF8toISO(character.getDescription()));

        ImageView imgAvatar = (ImageView) findViewById(R.id.imgDetailAvatar);

        Picasso.with(this)
                .load(character.getIncredibleThumbnailUrl())
                .into(imgAvatar);

    }

    public static String UTF8toISO(String str){
        Charset utf8charset = Charset.forName("UTF-8");
        Charset iso88591charset = Charset.forName("ISO-8859-1");

        ByteBuffer inputBuffer = ByteBuffer.wrap(str.getBytes());

        // decode UTF-8
        CharBuffer data = utf8charset.decode(inputBuffer);

        // encode ISO-8559-1
        ByteBuffer outputBuffer = iso88591charset.encode(data);
        byte[] outputData = outputBuffer.array();

        return new String(outputData);
    }
}
