package racingcar.domain;

import static racingcar.constant.DomainConstant.MOVE_THRESHOLD;
import static racingcar.constant.ErrorMessages.NAME_LENGTH_ERROR_MESSAGE;

public class Car {
    private int position;
    private String name;

    public Car(){}

    public Car(String name) {
        if(name.isEmpty() || name.length()>5){
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
        this.name = name;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void move(int randomValue){
        if(randomValue >= MOVE_THRESHOLD){
            this.position += 1;
        }
    }
}
