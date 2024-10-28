package racingcar;

public class Car {

    private int moveCount = 0;
    private final String name;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void movement() {
        moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }


}
