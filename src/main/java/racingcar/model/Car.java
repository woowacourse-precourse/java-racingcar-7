package racingcar.model;

public class Car {
    private final String name;
    private String curLocation;
    private static final int MAXIMUM_LENGTH = 5;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.curLocation = "";
    }

    public Car(String name, String curLocation) {
        validateName(name);
        this.name = name;
        this.curLocation = curLocation;
    }

    public String getName() {
        return name;
    }

    public String getCurLocation() {
        return curLocation;
    }

    public void moveForward() {
        curLocation += "-";
    }

    public Boolean isSamePosition(int maximumLength) {
        return curLocation.length() == maximumLength;
    }

    private void validateName(String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

}
