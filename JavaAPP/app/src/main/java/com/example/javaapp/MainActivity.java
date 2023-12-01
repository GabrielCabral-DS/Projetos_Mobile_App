package com.example.javaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selecionarPedra(View view){
        verificarGanhador("Pedra");

    }

    public void selecionarPapel(View view){
        verificarGanhador("Papel");

    }

    public void selecionarTesoura(View view){
        verificarGanhador("Tesoura");

    }

    public void verificarGanhador(String escolhaUsuario){
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.txtResultado);

        if ( ( escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")||
            ( escolhaApp == "Papel" && escolhaUsuario == "Pedra")||
            ( escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
        ){
          textoResultado.setText("Você Perdeu!!");

        } else if (
                        ( escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")||
                        ( escolhaUsuario == "Papel" && escolhaApp == "Pedra")||
                        ( escolhaUsuario == "Tesoura" && escolhaApp == "Papel")


        ) {//Verificação se o Usuário é o Ganhador

            textoResultado.setText("Você Ganhou!!");

        }else {//Empatou
            textoResultado.setText("Você Empatou!!");

        }

    }

    public String gerarEscolhaAleatoriaApp(){
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.img_App);

        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){
            case "Pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }


}