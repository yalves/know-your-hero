package com.example.yanal.knowyourhero.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.yanal.knowyourhero.Marvel.yaMarvelCharacter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by yanal on 27-Jun-17.
 */
public class yaApiUtils {

    public List<yaMarvelCharacter> getData(String end){
        String json;
        json = yaNetworkUtils.getJSONFromAPI(end);
        Log.i("Resultado", json);
        List<yaMarvelCharacter> retorno = parseJson(json);

        return retorno;
    }

    private List<yaMarvelCharacter> parseJson(String json){
        final ObjectNode node;
        Gson gson = new Gson();

        try {
            node = new ObjectMapper().readValue(json, ObjectNode.class);

            if (node.has("data")) {
                System.out.println("resultados do request: " + node.get("data"));
            }

            String resultados = node.get("data").get("results").toString();

            Type collectionType = new TypeToken<List<yaMarvelCharacter>>(){}.getType();
            List<yaMarvelCharacter> characters = gson.fromJson(resultados, collectionType);

            return characters;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Bitmap baixarImagem(String url) {
        try{
            URL endereco;
            InputStream inputStream;
            Bitmap imagem; endereco = new URL(url);
            inputStream = endereco.openStream();
            imagem = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return imagem;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}