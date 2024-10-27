package racingcar;

public class Car {
    private String name;
    private int randomNumber;
    private int currentPos;

    public Car(String name) {
        this.name = name;
        this.randomNumber = 0;
        this.currentPos = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPos(){
        return currentPos;
    }
}
