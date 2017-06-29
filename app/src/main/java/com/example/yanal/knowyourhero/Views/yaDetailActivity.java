package com.example.yanal.knowyourhero.Views;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yanal.knowyourhero.Models.yaMarvelCharacter;
import com.example.yanal.knowyourhero.R;
import com.squareup.picasso.Picasso;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/*
YA Yan Alves Monteiro - Activity principal
*/
public class yaDetailActivity extends AppCompatActivity {

    private yaMarvelCharacter character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ya_activity_scrolling);

        //Botao flutuante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(yaDetailActivity.this,
                        "You liked " + character.getName(), Toast.LENGTH_LONG).show();
            }
        });


        Intent intent = getIntent();

        Parcelable receivedCharacter = intent.getParcelableExtra("character");
        character = (yaMarvelCharacter) receivedCharacter;

        TextView txtName = (TextView) findViewById(R.id.txtNameDetail);
        txtName.setText(UTF8toISO(character.getName()));

        TextView txtDescription = (TextView) findViewById(R.id.txtDescriptionDetail);
        txtDescription.setText(UTF8toISO(character.getDescription()));

        TextView txtEditions = (TextView) findViewById(R.id.txtEditionsDetail);
        int ya = character.getComics().getAvailable();
        txtEditions.setText(String.valueOf(ya));

        ImageView imgAvatar = (ImageView) findViewById(R.id.avatarDetailedCharacter);

        Picasso.with(this)
                .load(character.getIncredibleThumbnailUrl())
                .into(imgAvatar);

    }

    /*
    YA Yan Alves Monteiro - método para converter encoding de UTF-8 para ISO-8859-1
     */
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
