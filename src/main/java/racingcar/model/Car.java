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

}
