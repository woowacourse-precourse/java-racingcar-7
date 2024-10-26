package racingcar.entity;

public class Car {

    private final String name;
    private Road road;

    private Car(String name){
        this.name=name;
        this.road=null;
    }

    public String getName() {
        return name;
    }

    public Road getRoad() {
        return road;
    }
}
