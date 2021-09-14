package com.example.yanal.knowyourhero.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.yanal.knowyourhero.Models.yaMarvelCharacter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

/**
 * Created by yanal on 27-Jun-17.
 */
public class yaApiUtils {

    public List<yaMarvelCharacter> getData(String end){
        String json;
        json = yaNetworkUtils.getJSONFromAPI(end);
        Log.i("Resultado", json);

        return parseJson(json);
    }

    private List<yaMarvelCharacter> parseJson(String json){
        final ObjectNode node;
        Gson gson = new Gson();

        try {
            node = new ObjectMapper().readValue(json, ObjectNode.class);

            String results = node.get("data").get("results").toString();

            Type collectionType = new TypeToken<List<yaMarvelCharacter>>(){}.getType();

            return gson.fromJson(results, collectionType);

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