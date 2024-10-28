package racingcar.model;

public class Car {
    String name;
    int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public void moveForward(){
        this.forwardCount++;
    }
}

