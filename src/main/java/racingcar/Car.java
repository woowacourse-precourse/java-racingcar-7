package racingcar;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void attemptMove(int threshold) {
        if (threshold >= 4) {
            position++;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Car(name);
    }
}
