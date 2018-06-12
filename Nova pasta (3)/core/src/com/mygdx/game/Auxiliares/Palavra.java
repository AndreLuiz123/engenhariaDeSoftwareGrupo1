package com.mygdx.game.Auxiliares;

import java.util.ArrayList;

public class Palavra {
    ArrayList<Character> wordArray;

    Palavra(String palavra) {
        wordArray = new ArrayList<Character>();

        for(int i = 0; i < palavra.length(); i++){
            wordArray.add(palavra.charAt(i));
        }
    }

}
