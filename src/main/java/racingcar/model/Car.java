package racingcar.model;

public class Car {

    private final String name;
    private int positon = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStartLine() {
        return positon;
    }

    public void move(int randomMove) {
        if (randomMove >= 4) {
            positon++;
        }
    }
}
