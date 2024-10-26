package racingcar;

public abstract class Car {

    protected final String name;
    protected int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    abstract public void move();

    abstract public boolean isWinner(int maxPosition);

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
