package racingcar.domain.car.entity;

import racingcar.domain.road.entity.Road;

import static racingcar.domain.road.entity.Length.INITIALIZE;

public class Car {

    private final String name;
    private Road road;

    public Car(String name){
        this.name=name;
        this.road=new Road(INITIALIZE.getValue());
    }

    public String getName() {
        return name;
    }

    public Road getRoad() {
        return road;
    }
}
