package racingcar.model;

public class Car {
    private String name;
    private Distance distance;
    private int order;

    public Car(String name, int order){
        this.name = name;
        this.order = order;
        this.distance = new Distance();
    }

    public String getName() {
        return name;
    }
}
