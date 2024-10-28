package model;

import validator.InputValidator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        InputValidator.validateCarName(name);
        this.name = name;
        this.position = 0;
    }


    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

}
