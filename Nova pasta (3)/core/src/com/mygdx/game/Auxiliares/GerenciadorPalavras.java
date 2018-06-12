package com.mygdx.game.Auxiliares;

import java.util.ArrayList;
import java.util.Random;

public class GerenciadorPalavras {
    public ArrayList<Palavra> palavras;

    Random random;
    int al;

    GerenciadorPalavras() {
        palavras = new ArrayList<Palavra>();

        /*Banco de dados de palavras aqui
        *
        *
        *
        */
    }

    public Palavra geraPalavra() {
        if(palavras.size() > 0) {
            al = random.nextInt(palavras.size());
            return palavras[al];
        }
        return NULL;
    }
}
