package com.example.yanal.knowyourhero.Views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yanal.knowyourhero.Adapters.yaMarvelCharacterAdapter;
import com.example.yanal.knowyourhero.Models.yaMarvelCharacter;
import com.example.yanal.knowyourhero.R;
import com.example.yanal.knowyourhero.Utils.yaApiUtils;

import java.util.ArrayList;
import java.util.List;

public class yaMainActivity extends AppCompatActivity {
    private yaMarvelCharacterAdapter marvelCharacterAdapter;
    private ProgressDialog load;
    private String searchPattern;
    GetDataFromMarvelApi taskGetCharacters = new GetDataFromMarvelApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ya_main);

        marvelCharacterAdapter = new yaMarvelCharacterAdapter(new ArrayList<yaMarvelCharacter>(), this);
        ListView lView = (ListView) findViewById(R.id.lstCharacters);
        lView.setAdapter(marvelCharacterAdapter);

        //Chamando a task async para recuperar dados da API
        taskGetCharacters.execute();

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(yaMainActivity.this, yaDetailActivity.class);

                yaMarvelCharacter character = marvelCharacterAdapter.getItem(position);

                intent.putExtra("character", character);
                startActivity(intent);
            }
        });
    }

    //Método
    public void searchCharacters(View view)
    {
        EditText searchBox = (EditText) findViewById(R.id.txtBoxSearch);
        searchPattern = searchBox.getText().toString();

        new GetDataFromMarvelApi().execute();
    }

    private class GetDataFromMarvelApi extends AsyncTask<Void, Void, List<yaMarvelCharacter>> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(yaMainActivity.this, "Por favor Aguarde ...", "Buscando informações dos personagens...");
        }

        @Override
        protected List<yaMarvelCharacter> doInBackground(Void... params) {
            List<yaMarvelCharacter> loadedCharacters;
            yaApiUtils util = new yaApiUtils();

            String charactersRouteURL = "http://gateway.marvel.com/v1/public/characters?ts=1&apikey=7f4a9857bd4998b55a01eb9f09d40e90&hash=fb7392548e27da1bd6fc4909be65c829&limit=50";
            if (searchPattern != null && !searchPattern.trim().isEmpty())
            {
                charactersRouteURL += "&nameStartsWith=" + searchPattern;
            }
            loadedCharacters = util.getData(charactersRouteURL);
            return loadedCharacters;
        }

        @Override
        protected void onPostExecute(List<yaMarvelCharacter> characters){
            super.onPostExecute(characters);
            load.dismiss();
            searchPattern = "";
            marvelCharacterAdapter.setItemList(characters);
            marvelCharacterAdapter.notifyDataSetChanged();
        }
    }
}
