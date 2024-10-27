package racingcar.Domain;

public class CarName {
    private final String value;


    private CarName(String value) {
        CarNameValidatator.validate(value);
        this.value = value;
    }

    public static CarName from(String value) {
        return new CarName(value);
    }

    @Override
    public String toString() {
        return value;
    }

}
