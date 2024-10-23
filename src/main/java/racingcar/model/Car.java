package racingcar.model;

public class Car {
    private String name;
    private int position;
    private boolean isWinner;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.isWinner = false;
    }
}
