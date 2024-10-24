package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private final String name;
    private int position;
    private final RandomNumberGenerator numberGenerator;

    public Car(String name, RandomNumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
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
        if(4 <= randomNumber && randomNumber <= 9){
            position++;
        }
    }


}
