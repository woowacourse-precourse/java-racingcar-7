package racingcar;

import java.util.List;

public class Executor {
    private List<Car> cars;
    private final String operator = ",";

    private IOController ioController;
    private Parser parser;
    private Validator validator;


    Executor(IOController ioController, Parser parser, Validator validator) {
        this.ioController = ioController;
        this.parser = parser;
        this.validator = validator;
    }
}
