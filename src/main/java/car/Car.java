package car;

public class Car {
    private final String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(){
        distance++;
    }

    @Override
    public String toString(){
        return name + " : " + "-".repeat(distance);
    }
}
