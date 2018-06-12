package com.mygdx.game.Auxiliares;

import java.util.ArrayList;

public class GerenciadorPerguntas {
    public ArrayList<Pergunta> perguntas;

    GerenciadorPerguntas(){
        perguntas = new ArrayList<Pergunta>();

        //Banco de Dados: kkkkk
        perguntas.add(new Pergunta("Qual dessas nao e uma tecnica de levantamento de dados?", "Observacao pessoal",
                "Entrevista", "Seminario", "Conversa Casual", 3, 0));
        perguntas.add(new Pergunta("Qual dessas nao e uma vantagem do uso de questionarios?", "Agilidade no processo",
                "Aplicacao facil", "Uniformidade na mensuracao", "Obtencao de informacao detalhada", 3, 0));
        perguntas.add(new Pergunta("Qual dessas alternativas e uma vantagem da Observacao Pessoal?", "Oferece evidências formais",
                "Nao exige disponibilidade de tempo do cliente", "Aplicado a um alto numero de pessoas","Uniformidade na mensuracao", 1, 0));
        perguntas.add(new Pergunta("Qual dessas ferramentas CASE e indicada para Gerencia de Projetos?", "CVS",
                "Git", "Google Code", "Oracle", 2, 1));
        perguntas.add(new Pergunta("Qual dessas ferramentas CASE nao e uma ferramenta de edicao?", "Microsoft Word",
                "Git", "Wiki", "Star UML", 1, 1));
        perguntas.add(new Pergunta("Qual dessas alternativas e uma desvantagem no uso de ferramentas CASE?", "Incompatibilidade de ferramentas",
                "Falta de qualidade no produto final", "Maior quantidade de codigos de programacao", "Maior gasto de tempo", 0, 1));
        perguntas.add(new Pergunta("Qual dessas ferramentas CASE nao e uma ferramenta de banco de dados", "Oracle",
                "MySQL", "Xplanner", "Postgres", 2, 1));
        perguntas.add(new Pergunta("Qual dessas alternativas nao configura um Diagrama estrutural UML?", "",
                "", "", "", 2, 2));

    }
}
