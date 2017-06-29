package com.example.yanal.knowyourhero.Utils;

/**
 * Created by yanal on 27-Jun-17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class yaNetworkUtils {

    //Responsavel por obter um objeto JSON de uma API
    public static String getJSONFromAPI(String url){
        String response = "";
        try {
            URL apiEnd = new URL(url);
            int responseCode;
            HttpURLConnection connection;
            InputStream is;

            connection = (HttpURLConnection) apiEnd.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.connect();

            responseCode = connection.getResponseCode();
            if(responseCode < HttpURLConnection.HTTP_BAD_REQUEST){
                is = connection.getInputStream();
            }else{
                is = connection.getErrorStream();
            }

            response = convertInputStreamToString(is);
            is.close();
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return response;
    }

    //Converte de inpusStream para String
    private static String convertInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String line;

            br = new BufferedReader(new InputStreamReader(is));
            while((line = br.readLine())!=null){
                buffer.append(line);
            }

            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return buffer.toString();
    }
}