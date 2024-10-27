package racingcar;

public class Validator {

    public static void isValidCarsName(String carsName) {
        if (!carsName.matches("^([a-zA-Z0-9]{1,5})(,[a-zA-Z0-9]{1,5})*$")) {
            throw new IllegalArgumentException("cars' name are not valid");
        }
    }

    public static void isValidTurn(String turn) {
        if (!turn.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("turn is not valid");
        }
    }
}
