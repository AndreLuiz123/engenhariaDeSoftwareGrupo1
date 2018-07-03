package com.mygdx.game.Auxiliares;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Palavra {

    private String texto;
    private String dica;

    public Palavra(String texto, String dica){
        this.texto = texto;
        this.dica = dica;
    }

    public boolean palavraCorreta(String resposta){
        if(texto.equals(resposta)){
            return true;
        }else
            return false;
    }

    public String getDica(){
        return this.dica;
    }

    public String getPalavra(){
        return this.texto;
    }

    public int getTamanho(){ return texto.length(); }
}

