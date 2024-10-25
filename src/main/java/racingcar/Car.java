package racingcar;

class Car {

    private final String name;
    private int moveCount = 0;

    Car(String name) {
        this.name = name;
    }

    public void move() {
        this.moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
