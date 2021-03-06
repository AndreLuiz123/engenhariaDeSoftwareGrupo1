package com.mygdx.game.Auxiliares;

import java.util.ArrayList;
import java.util.Random;

public class GerenciadorPerguntas {
    private ArrayList<Pergunta> perguntascat0; //Perguntas de levantamento de dados
    private ArrayList<Pergunta> perguntascat1; //Perguntas de ferramentas case
    private ArrayList<Pergunta> perguntascat2; //Perguntas de diagramas uml
    private ArrayList<Pergunta> perguntascat3; //Perguntas de qualidade de software
    private ArrayList<Pergunta> perguntascat4; //Perguntas de gerencia de projetos
    private Pergunta perguntaNeutra;
    private String alternativa;

    Random random;
    int al;

    public GerenciadorPerguntas() {
        perguntascat0 = new ArrayList<Pergunta>();
        perguntascat1 = new ArrayList<Pergunta>();
        perguntascat2 = new ArrayList<Pergunta>();
        perguntascat3 = new ArrayList<Pergunta>();
        perguntascat4 = new ArrayList<Pergunta>();
        random = new Random();

        //Banco de Dados: kkkkk

        perguntaNeutra = new Pergunta("","","","","",10);

        perguntascat0.add(new Pergunta("Qual dessas nao e uma tecnica de levantamento de dados?", "Observacao pessoal",
                "Entrevista", "Seminario", "Conversa Casual", 3));
        perguntascat0.add(new Pergunta("Qual dessas nao e uma vantagem do uso de questionarios?", "Agilidade no processo",
                "Aplicacao facil", "Uniformidade na mensuracao", "Obtencao de informacao detalhada", 3));
        perguntascat0.add(new Pergunta("Qual dessas alternativas e uma vantagem da Observacao Pessoal?", "Oferece evidências formais",
                "Nao exige disponibilidade de tempo do cliente", "Aplicado a um alto numero de pessoas", "Uniformidade na mensuracao", 1));
        perguntascat0.add(new Pergunta("A tecnica de levantamento de dados pode ser dividida em 4 fases. Assinale a alternativa que as enumera em ordem correta:", "preparação, prototipação, correção e documentação",
                "definição, programação, realização, e organização", "preparação, realização, interpretação e conclusão", "prototipação, organização, correção e conclusão", 2));

        perguntascat1.add(new Pergunta("Qual dessas ferramentas CASE e indicada para Gerencia de Projetos?", "CVS",
                "Git", "Google Code", "Oracle", 2));
        perguntascat1.add(new Pergunta("Qual dessas ferramentas CASE nao e uma ferramenta de edicao?", "Microsoft Word",
                "Git", "Wiki", "Star UML", 1));
        perguntascat1.add(new Pergunta("Qual dessas alternativas e uma desvantagem no uso de ferramentas CASE?", "Incompatibilidade de ferramentas",
                "Falta de qualidade no produto final", "Maior quantidade de codigos de programacao", "Maior gasto de tempo", 0));
        perguntascat1.add(new Pergunta("Qual dessas ferramentas CASE nao e uma ferramenta de banco de dados", "Oracle",
                "MySQL", "Xplanner", "Postgres", 2));
        perguntascat2.add(new Pergunta("Qual dessas alternativas nao configura um Diagrama estrutural UML?", "Diagrama de classes",
                "Diagrama de codigo", "Diagrama de sequencia", "Diagrama de caso de uso", 1));
        perguntascat2.add(new Pergunta("O Diagrama da UML que representa o comportamento interno de determinado objeto, subsistema ou sistema global denomina-se diagrama de?", "estado",
                "sequencia", "classe", "caso de uso", 2));
        perguntascat2.add(new Pergunta("Qual dessas alternativas apresenta um exemplo de diagrama de estruturas da UML?", "Diagrama de implatacao",
                "Diagrama de atividades", "Diagrama de caso de uso", "Diagrama de sequencia", 2));
    }

    public Pergunta geraPergunta(int cat){
        switch (cat){
            case 0:
                if (perguntascat0.size() > 0) {
                    al = random.nextInt(perguntascat0.size());
                    return perguntascat0.get(al);
                }
                break;
            case 1:
                if (perguntascat1.size() > 0) {
                    al = random.nextInt(perguntascat1.size());
                    return perguntascat1.get(al);
                }
                break;
            case 2:
                if (perguntascat2.size() > 0) {
                    al = random.nextInt(perguntascat2.size());
                    return perguntascat2.get(al);
                }
                break;
            case 3:
                if (perguntascat3.size() > 0) {
                    al = random.nextInt(perguntascat3.size());
                    return perguntascat3.get(al);
                }
                break;
            case 4:
                if (perguntascat2.size() > 0) {
                    al = random.nextInt(perguntascat2.size());
                    return perguntascat2.get(al);
                }
                break;
                default: break;


        }
        return perguntaNeutra;
    }

    public Pergunta geraPergunta0() {
        if (perguntascat0.size() > 0) {
            al = random.nextInt(perguntascat0.size());
            return perguntascat0.get(al);
        }
        return null;
    }

    public Pergunta geraPergunta1() {
        if (perguntascat1.size() > 0) {
            al = random.nextInt(perguntascat1.size());
            return perguntascat1.get(al);
        }
        return null;
    }

    public Pergunta geraPergunta2() {
        if (perguntascat2.size() > 0) {
            al = random.nextInt(perguntascat2.size());
            return perguntascat2.get(al);
        }
        return null;
    }

    public Pergunta geraPergunta3() {
        if (perguntascat3.size() > 0) {
            al = random.nextInt(perguntascat3.size());
            return perguntascat3.get(al);
        }
        return null;
    }

    public Pergunta geraPergunta4() {
        if (perguntascat4.size() > 0) {
            al = random.nextInt(perguntascat4.size());
            return perguntascat4.get(al);
        }
        return null;
    }

    public Pergunta pulaPergunta(int categoria){
        switch (categoria){
            case 0:
                return geraPergunta0();
            case 1:
                return geraPergunta1();
            case 2:
                return geraPergunta2();
            case 3:
                return geraPergunta3();
            case 4:
                return geraPergunta4();
            default: return null;

        }
    }

    public int retornaRespostaErrada(int respCerta){
        int r=respCerta;

        while(r==respCerta){
            r = random.nextInt(4);
        }

        return r;
    }

    public Pergunta getPerguntaNeutra(){
        return perguntaNeutra;
    }

    public boolean restaPergunta(int cat){
        switch(cat){
            case 0:
                for(int i=0;i<perguntascat0.size();i++){
                    if(!perguntascat0.get(i).isFeita()){
                        return true;
                    }
                }
                break;
            case 1:
                for(int i=0;i<perguntascat1.size();i++){
                    if(!perguntascat1.get(i).isFeita()){
                        return true;
                    }
                }
                break;
            case 2:
                for(int i=0;i<perguntascat2.size();i++){
                    if(!perguntascat2.get(i).isFeita()){
                        return true;
                    }
                }
                break;
            case 3:
                for(int i=0;i<perguntascat3.size();i++){
                    if(!perguntascat3.get(i).isFeita()){
                        return true;
                    }
                }
                break;
            case 4:
                for(int i=0;i<perguntascat4.size();i++){
                    if(!perguntascat4.get(i).isFeita()){
                        return true;
                    }
                }
                break;
            default: break;
        }
        return false;
    }
    }