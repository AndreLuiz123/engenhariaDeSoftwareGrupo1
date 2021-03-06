package com.mygdx.game.Auxiliares;

public class Pergunta {

    private String alta;
    private String altb;
    private String altc;
    private String altd;

    private String texto;

    private int altcorreta; // 0 = a, 1 = b, 2 = c, 3 = d
    private boolean foiFeita;


    Pergunta(String texto, String alta, String altb, String altc, String altd, int altcorreta){
        this.texto = texto;

        this.alta = alta;
        this.altb = altb;
        this.altc = altc;
        this.altd = altd;

        this.foiFeita = false;

        this.altcorreta = altcorreta;
        if(altcorreta < 0 || altcorreta > 3) this.altcorreta = 0; // Se der erro alternativa a ta certa

    }

    public boolean eRespostaCorreta(int resp){
        if(resp == this.altcorreta){
            return true;
        }else
            return false;
    }

    public String getAlta(){
        return this.alta;
    }

    public String getAltb(){
        return this.altb;
    }

    public String getAltc(){
        return this.altc;
    }

    public String getAltd(){
        return this.altd;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isFeita(){return this.foiFeita;}

    public void marcarFeita(){this.foiFeita = true;}

    public int getAltcorreta(){
        return this.altcorreta;
    }
}
