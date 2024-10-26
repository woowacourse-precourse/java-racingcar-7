package racingcar.domain;

import static racingcar.constant.DomainConstant.MOVE_THRESHOLD;

public class Car {
    private int position;
    private String name;

    public Car(){}

    public Car(String name) {
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
