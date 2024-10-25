package racingcar.car;

public abstract class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name.trim();
        this.position = position;
        CarValidator.valid(this);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void incrementPosition(int value) {
        this.position += value;
    }

    public abstract void move();
}
