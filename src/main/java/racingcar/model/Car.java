package racingcar.model;

public class Car {

    private String name;
    private Integer distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String toString() {
        System.out.println("car name: "+ this.name);
        return this.name;
    }
}
