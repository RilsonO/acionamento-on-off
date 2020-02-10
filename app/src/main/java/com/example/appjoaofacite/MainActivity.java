package com.example.appjoaofacite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";
    private static final String ARQUIVO_PREFERENCIA2 = "ArquivoPreferencia";
    private static final String ARQUIVO_PREFERENCIA3 = "ArquivoPreferencia";
    private static final String ARQUIVO_PREFERENCIA4 = "ArquivoPreferencia";
    private static final String ARQUIVO_PREFERENCIA5 = "ArquivoPreferencia";
    private static final String ARQUIVO_PREFERENCIA6 = "ArquivoPreferencia";
    private static final String ARQUIVO_PREFERENCIA7 = "ArquivoPreferencia";
    String url, parametros;
    int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1_id);
        btn2 = findViewById(R.id.btn2_id);
        btn3 = findViewById(R.id.btn3_id);
        btn4 = findViewById(R.id.btn4_id);
        btn5 = findViewById(R.id.btn5_id);
        btn6 = findViewById(R.id.btn6_id);

        if(cont==0){

            cont++;
            final SharedPreferences sharedPreferencesBtn7 = getSharedPreferences( ARQUIVO_PREFERENCIA7, 0 );
            if(sharedPreferencesBtn7.contains("begin")){

                String b1,b2,b3,b4,b5,b6;
                SharedPreferences sharedPreferencesBtn1 = getSharedPreferences( ARQUIVO_PREFERENCIA, 0 );
                SharedPreferences sharedPreferencesBtn2 = getSharedPreferences( ARQUIVO_PREFERENCIA2, 0 );
                SharedPreferences sharedPreferencesBtn3 = getSharedPreferences( ARQUIVO_PREFERENCIA3, 0 );
                SharedPreferences sharedPreferencesBtn4 = getSharedPreferences( ARQUIVO_PREFERENCIA4, 0 );
                SharedPreferences sharedPreferencesBtn5 = getSharedPreferences( ARQUIVO_PREFERENCIA5, 0 );
                SharedPreferences sharedPreferencesBtn6 = getSharedPreferences( ARQUIVO_PREFERENCIA6, 0 );
                b1 = sharedPreferencesBtn1.getString("btn1","");
                b2 = sharedPreferencesBtn2.getString("btn2","");
                b3 = sharedPreferencesBtn3.getString("btn3","");
                b4 = sharedPreferencesBtn4.getString("btn4","");
                b5 = sharedPreferencesBtn5.getString("btn5","");
                b6 = sharedPreferencesBtn6.getString("btn6","");

                if(b1.equals("1")){
                    btn1.setText("Botão 1\ndesligado");
                }else{
                    btn1.setText("Botão 1\nligado");
                }

                if(b2.equals("1")){
                    btn2.setText("Botão 2\ndesligado");
                }else{
                    btn2.setText("Botão2\nligado");
                }

                if(b3.equals("1")){
                    btn3.setText("Botão 3\ndesligado");
                }else{
                    btn3.setText("Botão 3\nligado");
                }

                if(b4.equals("1")){
                    btn4.setText("Botão 4\ndesligado");
                }else{
                    btn4.setText("Botão 4\nligado");
                }

                if(b5.equals("1")){
                    btn5.setText("Botão 5\ndesligado");
                }else{
                    btn5.setText("Botão 5\nligado");
                }

                if(b6.equals("1")){
                    btn6.setText("Botão 6\ndesligado");
                }else{
                    btn6.setText("Botão 6\nligado");
                }


                Toast.makeText(getApplicationContext(),"Dados recuperados do ultimo acesso!",Toast.LENGTH_LONG).show();
            }else{
                SharedPreferences sharedPreferencesBtn1 = getSharedPreferences( ARQUIVO_PREFERENCIA, 0 );
                SharedPreferences.Editor editorBtn1 = sharedPreferencesBtn1.edit();
                editorBtn1.putString( "btn1","1");
                editorBtn1.commit();
                btn1.setText("Botão 1\ndesligado");

                SharedPreferences sharedPreferencesBtn2 = getSharedPreferences( ARQUIVO_PREFERENCIA2, 0 );
                SharedPreferences.Editor editorBtn2 = sharedPreferencesBtn2.edit();
                editorBtn2.putString( "btn2","1");
                editorBtn2.commit();
                btn2.setText("Botão 2\ndesligado");

                SharedPreferences sharedPreferencesBtn3 = getSharedPreferences( ARQUIVO_PREFERENCIA3, 0 );
                SharedPreferences.Editor editorBtn3 = sharedPreferencesBtn3.edit();
                editorBtn3.putString( "btn3","1");
                editorBtn3.commit();
                btn3.setText("Botão 3\ndesligado");

                SharedPreferences sharedPreferencesBtn4 = getSharedPreferences( ARQUIVO_PREFERENCIA4, 0 );
                SharedPreferences.Editor editorBtn4 = sharedPreferencesBtn4.edit();
                editorBtn4.putString( "btn4","1");
                editorBtn4.commit();
                btn4.setText("Botão 4\ndesligado");

                SharedPreferences sharedPreferencesBtn5 = getSharedPreferences( ARQUIVO_PREFERENCIA5, 0 );
                SharedPreferences.Editor editorBtn5 = sharedPreferencesBtn5.edit();
                editorBtn5.putString( "btn5","1");
                editorBtn5.commit();
                btn5.setText("Botão 5\ndesligado");

                SharedPreferences sharedPreferencesBtn6 = getSharedPreferences( ARQUIVO_PREFERENCIA6, 0 );
                SharedPreferences.Editor editorBtn6 = sharedPreferencesBtn6.edit();
                editorBtn6.putString( "btn6","1");
                editorBtn6.commit();
                btn6.setText("Botão 6\ndesligado");

                SharedPreferences.Editor editorBtn7 = sharedPreferencesBtn7.edit();
                editorBtn7.putString( "begin","1");
                editorBtn7.commit();
            }

        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ConnectivityManager connMgr = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE );
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                    SharedPreferences sharedPreferencesBtn1 = getSharedPreferences( ARQUIVO_PREFERENCIA, 0 );
                    if(sharedPreferencesBtn1.contains("btn1")){
                        String btn = sharedPreferencesBtn1.getString("btn1","");
                        if(btn.equals("1")){

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn1.setText("Botão 1\n ligado");

                            SharedPreferences.Editor editorBtn1 = sharedPreferencesBtn1.edit();
                            editorBtn1.putString( "btn1","0");
                            editorBtn1.commit();

                        }else{

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn1.setText("Botão 1\n desligado");

                            SharedPreferences.Editor editorBtn1 = sharedPreferencesBtn1.edit();
                            editorBtn1.putString( "btn1","1");
                            editorBtn1.commit();
                        }
                    }


                } else {
                    Toast.makeText( getApplicationContext(), "Nenhuma conexão foi detectada", Toast.LENGTH_LONG ).show();
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE );
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                    SharedPreferences sharedPreferencesBtn2 = getSharedPreferences( ARQUIVO_PREFERENCIA2, 0 );
                    if(sharedPreferencesBtn2.contains("btn2")){
                        String btn = sharedPreferencesBtn2.getString("btn2","");
                        if(btn.equals("1")){

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn2.setText("Botão 2\n ligado");

                            SharedPreferences.Editor editorBtn2 = sharedPreferencesBtn2.edit();
                            editorBtn2.putString( "btn2","0");
                            editorBtn2.commit();

                        }else{

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn2.setText("Botão 2\n desligado");

                            SharedPreferences.Editor editorBtn2 = sharedPreferencesBtn2.edit();
                            editorBtn2.putString( "btn2","1");
                            editorBtn2.commit();
                        }
                    }


                } else {
                    Toast.makeText( getApplicationContext(), "Nenhuma conexão foi detectada", Toast.LENGTH_LONG ).show();
                }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE );
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                    SharedPreferences sharedPreferencesBtn3 = getSharedPreferences( ARQUIVO_PREFERENCIA3, 0 );
                    if(sharedPreferencesBtn3.contains("btn2")){
                        String btn = sharedPreferencesBtn3.getString("btn3","");
                        if(btn.equals("1")){

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn3.setText("Botão 3\n ligado");

                            SharedPreferences.Editor editorBtn3 = sharedPreferencesBtn3.edit();
                            editorBtn3.putString( "btn3","0");
                            editorBtn3.commit();

                        }else{

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn3.setText("Botão 3\n desligado");

                            SharedPreferences.Editor editorBtn3 = sharedPreferencesBtn3.edit();
                            editorBtn3.putString( "btn3","1");
                            editorBtn3.commit();
                        }
                    }


                } else {
                    Toast.makeText( getApplicationContext(), "Nenhuma conexão foi detectada", Toast.LENGTH_LONG ).show();
                }

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE );
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                    SharedPreferences sharedPreferencesBtn4 = getSharedPreferences( ARQUIVO_PREFERENCIA4, 0 );
                    if(sharedPreferencesBtn4.contains("btn4")){
                        String btn = sharedPreferencesBtn4.getString("btn4","");
                        if(btn.equals("1")){

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn4.setText("Botão 4\n ligado");

                            SharedPreferences.Editor editorBtn4 = sharedPreferencesBtn4.edit();
                            editorBtn4.putString( "btn4","0");
                            editorBtn4.commit();

                        }else{

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn4.setText("Botão 4\n desligado");

                            SharedPreferences.Editor editorBtn4 = sharedPreferencesBtn4.edit();
                            editorBtn4.putString( "btn4","1");
                            editorBtn4.commit();
                        }
                    }


                } else {
                    Toast.makeText( getApplicationContext(), "Nenhuma conexão foi detectada", Toast.LENGTH_LONG ).show();
                }

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE );
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                    SharedPreferences sharedPreferencesBtn5 = getSharedPreferences( ARQUIVO_PREFERENCIA5, 0 );
                    if(sharedPreferencesBtn5.contains("btn5")){
                        String btn = sharedPreferencesBtn5.getString("btn5","");
                        if(btn.equals("1")){

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn5.setText("Botão 5\n ligado");

                            SharedPreferences.Editor editorBtn5 = sharedPreferencesBtn5.edit();
                            editorBtn5.putString( "btn5","0");
                            editorBtn5.commit();

                        }else{

                            url = "your-route";
                            parametros = "your-parameter";
                            new SolicitaDados().execute( url );
                            btn5.setText("Botão 5\n desligado");

                            SharedPreferences.Editor editorBtn5 = sharedPreferencesBtn5.edit();
                            editorBtn5.putString( "btn5","1");
                            editorBtn5.commit();
                        }
                    }


                } else {
                    Toast.makeText( getApplicationContext(), "Nenhuma conexão foi detectada", Toast.LENGTH_LONG ).show();
                }

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE );
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                    SharedPreferences sharedPreferencesBtn6 = getSharedPreferences( ARQUIVO_PREFERENCIA6, 0 );
                    if(sharedPreferencesBtn6.contains("btn6")){
                        String btn = sharedPreferencesBtn6.getString("btn6","");
                        if(btn.equals("1")){

                            url = "http://167.114.133.131/app/r6.php?token=f";
                            parametros = "";
                            new SolicitaDados().execute( url );
                            btn6.setText("Botão 6\n ligado");

                            SharedPreferences.Editor editorBtn6 = sharedPreferencesBtn6.edit();
                            editorBtn6.putString( "btn6","0");
                            editorBtn6.commit();

                        }else{

                            url = "http://167.114.133.131/app/r6.php?token=0";
                            parametros = "";
                            new SolicitaDados().execute( url );
                            btn6.setText("Botão 6\n desligado");

                            SharedPreferences.Editor editorBtn6 = sharedPreferencesBtn6.edit();
                            editorBtn6.putString( "btn6","1");
                            editorBtn6.commit();
                        }
                    }


                } else {
                    Toast.makeText( getApplicationContext(), "Nenhuma conexão foi detectada", Toast.LENGTH_LONG ).show();
                }

            }
        });
    }

    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return conexao.postDados(urls[0], parametros);

        }
        @Override
        protected void onPostExecute(String resultado){

        }

    }
}
