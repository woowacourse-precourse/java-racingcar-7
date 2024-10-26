package racingcar;

import java.util.Random;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        Random random = new Random();
        if(random.nextInt(10) >= 4){  //무작위 값이 4 이상일때만 전진
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
