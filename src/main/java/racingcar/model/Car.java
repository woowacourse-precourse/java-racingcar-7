package racingcar.model;

public class Car {

    private String name;

    public Car() {
    }

    private Car(String name) {
        this.name = name;
    }

    public boolean isValidateLength(String name, final int limitLength) {
        if (name.length() > limitLength) {
            throw new IllegalArgumentException("The name must be " + limitLength + " characters or fewer.");
        }
        return true;
    }


    public String getName() {
        return name;
    }
}
