package racingcar.model;

public class Car {

    public String name;
    public Integer distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String toString() {
        System.out.println("car name: "+ this.name);
        return this.name;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}
