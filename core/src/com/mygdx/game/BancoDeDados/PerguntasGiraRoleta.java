package com.mygdx.game.BancoDeDados;

import java.util.ArrayList;

/**
 * Created by Andre Luiz on 10/05/2018.
 */

public class PerguntasGiraRoleta {

    public ArrayList<Pergunta> perguntas;

    public PerguntasGiraRoleta(){

        this.perguntas = new ArrayList<Pergunta>();

        this.perguntas.add(new Pergunta( "Qual dessas não é uma técnica de levantamento de dados?",
   "Observação Pessoal","Entrevista","Seminário","Conversa Casual",3 ));

        this.perguntas.add(new Pergunta( "Qual dessas não é uma vantagem do uso de questionários?",
                "Agilidade no processo","Aplicação fácil","Uniformidade na mensuração","Obtenção de informação detalhada",3 ));

        this.perguntas.add(new Pergunta( "   Qual dessas alternativas é uma\n"+"vantagem da Observação Pessoal?",
                "Oferece evidências formais","Não exige disponibilidade de tempo do cliente","Aplicado à um alto numero de pessoas",
                "Uniformidade na mensuração",1 ));

        this.perguntas.add(new Pergunta( " Qual dessas ferramentas CASE é indicada\n"+" para Gerência de Projetos?",
                "CVS","Git","Google Corde", "Oracle",1));

        this.perguntas.add(new Pergunta( "  Qual dessas ferramentas CASE\n"+" não é uma ferramenta de Edição?",
                "Microsoft Word","Git","Wiki", "Star UML",1));

        this.perguntas.add(new Pergunta( " Qual dessas alternativas é uma desvantagem\n"+" no uso de ferramentas CASE?",
                "Incompatibilidade de ferramentas","Falta de qualidade no produto final",
                "Maior quantidade de códigos de programação", "Maior gasto de tempo",0));

        this.perguntas.add(new Pergunta( "  Qual dessas ferramentas CASE não é\n"+" uma ferramenta de banco de dados?",
                "Oracle","MySQL",
                "Xplanner ", "Postgres",2));

        this.perguntas.add(new Pergunta( "  Qual dessas alternativas não\n"+" configura um Diagrama estrutural UML?",
                "Diagrama de classes","Diagrama de código",
                " Diagrama de sequência ", "Diagrama de caso de uso",1));

        this.perguntas.add(new Pergunta( "   O Diagrama da UML que representa o comportamento interno de determinado objeto,\n" +
                "subsistema ou sistema \n"+"global denomina-se diagrama de?",
                "estado","sequência",
                "classe ", "caso de uso",2));

        this.perguntas.add(new Pergunta( "  Qual dessas alternativas apresenta\n"+" um exemplo de diagrama de estruturas da UML?",
                "Diagrama de implantação","Diagrama de atividades",
                "Diagrama de caso de uso ", "Diagrama de sequência",2));



    }

    public Pergunta getPergunta(int i){

        return perguntas.get(i);

    }

}
