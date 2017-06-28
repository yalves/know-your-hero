package com.example.yanal.knowyourhero;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yanal.knowyourhero.Marvel.yaMarvelCharacter;
import com.example.yanal.knowyourhero.Utils.yaApiUtils;
import com.example.yanal.knowyourhero.Utils.yaNetworkUtils;

import java.util.Collection;
import java.util.List;

public class yaMainActivity extends AppCompatActivity {

    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ya_main);

        GetJson download = new GetJson();

        download.execute();

        //System.out.println(yaNetworkUtils.getJSONFromAPI("http://gateway.marvel.com/v1/public/characters?ts=1&apikey=7f4a9857bd4998b55a01eb9f09d40e90&hash=fb7392548e27da1bd6fc4909be65c829&limit=1"));
    }

    private class GetJson extends AsyncTask<Void, Void, List<yaMarvelCharacter>> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(yaMainActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected List<yaMarvelCharacter> doInBackground(Void... params) {
            yaApiUtils util = new yaApiUtils();

            return util.getData("http://gateway.marvel.com/v1/public/characters?ts=1&apikey=7f4a9857bd4998b55a01eb9f09d40e90&hash=fb7392548e27da1bd6fc4909be65c829&limit=1");
        }

        @Override
        protected void onPostExecute(List<yaMarvelCharacter> pessoa){
            load.dismiss();
            //System.out.println(pessoa.get(0).getName());

        }
    }
}
