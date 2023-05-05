package com.cursoandroid.app3pedrapapeloutesoura;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        selecionarOpcao("Pedra");
    }
    public void selecionarPapel(View view){
        selecionarOpcao("Papel");
    }
    public void selecionarTesoura(View view){
        selecionarOpcao("Tesoura");
    }

    public void selecionarOpcao(String escolhaUsuario){
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[numero];
        switch (escolhaApp){
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (escolhaApp.equals("Tesoura") && escolhaUsuario.equals("Papel")) ||
                        (escolhaApp.equals( "Papel" ) && escolhaUsuario.equals( "Pedra")) ||
                            (escolhaApp.equals( "Pedra") && escolhaUsuario.equals("Tesoura"))
        ){//App ganha
            textResultado.setText(R.string.vc_perdeu);
        }else if (
                (escolhaUsuario.equals("Tesoura") && escolhaApp.equals("Papel")) ||
                        (escolhaUsuario.equals("Papel") && escolhaApp.equals("Pedra")) ||
                        (escolhaUsuario.equals("Pedra") && escolhaApp.equals("Tesoura"))
        ){//usuario
            textResultado.setText(R.string.vc_ganhou);
        }else{//empate
            textResultado.setText(R.string.empate);
        }
    }
}