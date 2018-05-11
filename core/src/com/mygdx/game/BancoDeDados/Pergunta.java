package com.mygdx.game.BancoDeDados;

/**
 * Created by Andre Luiz on 10/05/2018.
 */

public class Pergunta {


    private String pergunta;
    private String letraA;
    private String letraB;
    private String letraC;
    private String letraD;

    private int opcaoCorreta;


    public Pergunta(String frase, String a, String b, String c, String d, int opcaoCorreta){

        this.pergunta = frase;

        this.letraA = a;
        this.letraB = b;
        this.letraC = c;
        this.letraD = d;

        this.opcaoCorreta = opcaoCorreta;
    }


    public String getPergunta() {
        return pergunta;
    }

    public String getLetraA() {
        return letraA;
    }

    public String getLetraB() {
        return letraB;
    }

    public String getLetraC() {
        return letraC;
    }

    public String getLetraD() {
        return letraD;
    }


    public int getOpcaoCorreta() {
        return opcaoCorreta;
    }


}
