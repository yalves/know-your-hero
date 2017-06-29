package com.example.yanal.knowyourhero.Views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yanal.knowyourhero.Adapters.yaMarvelCharacterAdapter;
import com.example.yanal.knowyourhero.Models.yaMarvelCharacter;
import com.example.yanal.knowyourhero.R;
import com.example.yanal.knowyourhero.Utils.yaApiUtils;

import java.util.ArrayList;
import java.util.List;

public class yaMainActivity extends AppCompatActivity {
    private yaMarvelCharacterAdapter marvelCharacterAdapter;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ya_main);

        marvelCharacterAdapter = new yaMarvelCharacterAdapter(new ArrayList<yaMarvelCharacter>(), this);
        ListView lView = (ListView) findViewById(R.id.lstCharacters);
        lView.setAdapter(marvelCharacterAdapter);

        //Chamando a task async para recuperar dados da API
        GetDataFromMarvelApi data = new GetDataFromMarvelApi();
        data.execute();

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Ex 2 - Pegando conteudo do filho da listview
                //TextView textView = (TextView) view.findViewById(R.id.txtLogin);
                // Toast.makeText(MainActivity.this,"Clicou em "+ textView.getText().toString(), Toast.LENGTH_LONG).show();

                //Ex 3 - Indo para uma nova view
                Intent intent = new Intent(yaMainActivity.this, yaDetailActivity.class);

                yaMarvelCharacter character = marvelCharacterAdapter.getItem(position);

                intent.putExtra("character", character);
                startActivity(intent);
            }
        });
    }

    private class GetDataFromMarvelApi extends AsyncTask<Void, Void, List<yaMarvelCharacter>> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(yaMainActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected List<yaMarvelCharacter> doInBackground(Void... params) {
            List<yaMarvelCharacter> loadedCharacters = new ArrayList<yaMarvelCharacter>();
            yaApiUtils util = new yaApiUtils();

            loadedCharacters = util.getData("http://gateway.marvel.com/v1/public/characters?ts=1&apikey=7f4a9857bd4998b55a01eb9f09d40e90&hash=fb7392548e27da1bd6fc4909be65c829&limit=50&nameStartsWith=Sp");
            return loadedCharacters;
        }

        @Override
        protected void onPostExecute(List<yaMarvelCharacter> characters){
            super.onPostExecute(characters);
            load.dismiss();
            marvelCharacterAdapter.setItemList(characters);
            marvelCharacterAdapter.notifyDataSetChanged();
        }
    }
}
