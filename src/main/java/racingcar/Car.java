package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = formatCarName(name);
    }

    private String formatCarName(String name) {
        return name.trim();
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
