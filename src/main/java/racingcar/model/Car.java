package racingcar.model;

public class Car {
    String name;
    int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void moveForward(){
        this.distance++;
    }

    public void printCarDistance() {
        System.out.print(generateDistanceStatus());
    }

    public String generateDistanceStatus() {
        return name + " : " + "-".repeat(distance) + "\n";
    }
}

