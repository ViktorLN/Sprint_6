package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    // убираю зависимость
    private final IKittensCounter iKittensCounter;
    private final Predator predator;

    public Lion(String sex, IKittensCounter iKittensCounter, Predator predator) throws Exception {
        // попробую уместить в 1 конструктор
        this.iKittensCounter = iKittensCounter;
        this.predator = predator;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return iKittensCounter.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
