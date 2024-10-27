package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private final String name;
    private int position;
    private final RandomNumberGenerator numberGenerator;

    public Car(String name) {
        this.name = name;
        this.numberGenerator = new RandomNumberGenerator();
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        int randomNumber = numberGenerator.generateRandomNumber();
        if(4 <= randomNumber){
            position++;
        }
    }


}
