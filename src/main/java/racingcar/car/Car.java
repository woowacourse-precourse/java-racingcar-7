package racingcar.car;

public class Car implements Comparable<Car>{
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move() {
        if (MoveDecision.byRandom()) {
            this.moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.getMoveCount(), this.moveCount);
    }
}
