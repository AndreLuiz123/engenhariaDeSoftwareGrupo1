package com.mygdx.game.Auxiliares;

public class Pergunta {

    String alta;
    String altb;
    String altc;
    String altd;

    String texto;

    int altcorreta; // 0 = a, 1 = b, 2 = c, 3 = d


    Pergunta(String texto, String alta, String altb, String altc, String altd, int altcorreta){
        this.texto = texto;

        this.alta = alta;
        this.altb = altb;
        this.altc = altc;
        this.altd = altd;

        this.altcorreta = altcorreta;
        if(altcorreta < 0 || altcorreta > 3) this.altcorreta = 0; // Se der erro alternativa a ta certa

    }

}