package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Executor {
    private static final int NAME_LENGTH_LIMIT = 5;

    private final IOController ioController;
    private final Parser parser;
    private final Validator validator;
    private final Racing racing;
    private final Judge judge;

    Executor(IOController ioController, Parser parser, Validator validator, Racing racing, Judge judge) {
        this.ioController = ioController;
        this.parser = parser;
        this.validator = validator;
        this.racing = racing;
        this.judge = judge;
    }

    public void run() {
        String inputCarNamesStr = ioController.enterCarNames();
        String inputRepeatCountStr = ioController.enterRepeatCount();
        Console.close();

        validator.validateCarNamesInput(inputCarNamesStr);
        List<String> carNames = parser.parseCarNamesByOperator(inputCarNamesStr);

        validator.validateCarNamesLength(carNames, NAME_LENGTH_LIMIT);
        List<Car> cars = Car.createCarsByName(carNames);

        validator.validateRepeatCount(inputRepeatCountStr);
        long repeatCount = parser.parseRepeatCount(inputRepeatCountStr);

        for (int i = 0; i < repeatCount; i++) {
            racing.moveCars(cars);
            ioController.printResults(cars);
        }

        List<Car> winners = judge.getWinners(cars);
        ioController.printWinners(winners);
    }
}
