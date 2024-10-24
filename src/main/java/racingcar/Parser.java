package racingcar;

import java.util.ArrayList;

public class Parser {
    private String input;
    private ArrayList<Car> cars;
    private Validator validator;

    Parser(String _input) {
        input = _input;
        cars = new ArrayList<>(10);
        validator = new Validator();
    }

    public void parseInput() {
        String[] splitedNames = input.split(",");

        for (String name : splitedNames) {
            validator.checkValidName(name);
            cars.add(new Car(name));
        }
    }
}
