package racingcar;

public class Car {

    private final String name;
    private int position;

    private Car(String name) {
        checkNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public boolean isNotSamePositionTo(int position) {
        return this.position != position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
