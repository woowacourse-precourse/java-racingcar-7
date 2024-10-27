package racingcar.domain;

public class Car {

    private String name;
    private int position;
    private final static int MAX_CAR_NAME_LENGTH = 5;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    private void validateCarName(String name) {
        int nameLength = name.length();
        if (nameLength > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다.");
        }
    }
}
