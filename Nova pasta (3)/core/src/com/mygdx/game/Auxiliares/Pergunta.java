package com.mygdx.game.Auxiliares;

public class Pergunta {

    String alta;
    String altb;
    String altc;
    String altd;

    String texto;
    int categoria;
    //Categorias:
    //0 = levantamento de dados, 1 = ferramentas case, 2 = diagramas uml, 3 = qualidade de software
    //4 = gerência de projetos, 5 = outro

    int altcorreta; // 0 = a, 1 = b, 2 = c, 3 = d


    Pergunta(String texto, String alta, String altb, String altc, String altd, int altcorreta, int categoria){
        this.texto = texto;

        this.alta = alta;
        this.altb = altb;
        this.altc = altc;
        this.altd = altd;

        this.altcorreta = altcorreta;
        if(altcorreta < 0 || altcorreta > 3) this.altcorreta = 0; // Se der erro alternativa a ta certa

    }

}
