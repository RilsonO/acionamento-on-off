package com.example.appjoaofacite;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class conexao {
    public static String postDados(String urlUsuario, String parametrosUsuario){
        URL url;
        HttpURLConnection connection = null;

        try {

            url = new URL(urlUsuario);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Lenght","" + Integer.toString(parametrosUsuario.getBytes().length));

            connection.setRequestProperty("Content-Language","pt-BR");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            outputStreamWriter.write(parametrosUsuario);
            outputStreamWriter.flush();

            InputStream inputStream = connection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String Linha;
            StringBuffer resposta = new StringBuffer();

            while ((Linha = bufferedReader.readLine()) != null){
                resposta.append(Linha);
                resposta.append('\r');
            }

            bufferedReader.close();

            return resposta.toString();


        }catch (Exception erro){
            return null;

        }finally {
            if (connection != null){
                connection.disconnect();
            }

        }
    }
}
