package racingcar;

import java.util.Random;

public class Car {

    private String name;
    private int currentPosition;

    public Car(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public void move() {
        Random random = new Random();
        if (name.length() > Constants.CAR_NAME_LENGTH_MAX) {
          
        }

    }



}
}
