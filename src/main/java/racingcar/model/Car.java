package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        position++;
    }


    public void pritntStatus() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public boolean isAheadOf(Car otherCar) {
        return this.position > otherCar.position;
    }

    public boolean isAtSamePosition(Car otherCar) {
        return this.position == otherCar.position;
    }

    public void printWinner() {
        System.out.print(name);
    }

}
