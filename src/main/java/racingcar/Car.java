package racingcar;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int location;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.location = 0;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "글자 이내여야 합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 한 글자 이상이여야 합니다.");
        }
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            this.location += 1;
        }
    }

    public void printState() {
        System.out.println(this.name + " : " + "-".repeat(this.location));
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
