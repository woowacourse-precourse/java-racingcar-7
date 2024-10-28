package car;

public class Car {

    public static Integer maxDistance;
    private final String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(){
        distance++;
        maxDistance = Math.max(distance, maxDistance);
    }

    public Integer getDistance(){
        return distance;
    }

    @Override
    public String toString(){
        return name + " : " + "-".repeat(distance);
    }
}
