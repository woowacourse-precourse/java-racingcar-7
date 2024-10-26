package racingcar;

public class Car {

    private final int NAME_MAX_LENGTH  = 5;
    private String name;
    private int location;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름이 5글자를 초과할 수 없어요.");
        }
    }

    public void moveForward(int distance) {
        this.location = distance;
    }

    public int currentLocation() {
        return this.location;
    }
}
