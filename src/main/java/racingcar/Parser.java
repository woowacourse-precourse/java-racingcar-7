package racingcar;

public class Parser {
    public static void parseNames(String input) {
        ValidatorForNames validator = new ValidatorForNames();

        for (String name : input.split(",")) {
            validator.checkValidation(name);
            Data.addCarToCarsByName(name);
        }
    }

    public static void parseCount(String input) {
        ValidatorForCount validator = new ValidatorForCount();

        validator.checkValidation(input);
        Data.setRacingCount(Integer.parseInt(input));
    }
}
