package racingcar.entity;

public class Car {

    private final String name;
    private Road road;

    public Car(String name){
        this.name=name;
        this.road=new Road(0);
    }

    public String getName() {
        return name;
    }

    public Road getRoad() {
        return road;
    }
}
