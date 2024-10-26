package racingcar.model;

public class Car {
    private String name;
    private int move;

    public Car(String name, int move) {
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    private void setMove(int move) {
        this.move = move;
    }

    public void addMove(Car car) {
        car.setMove(car.getMove() + 1);
    }
}
