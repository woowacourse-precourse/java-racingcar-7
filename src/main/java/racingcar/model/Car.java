package racingcar.model;

public class Car {
    private final String name;
    private String curLocation;

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
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

}
