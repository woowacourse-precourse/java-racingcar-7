package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Executor {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVE_STANDARD = 4;
    private static final int startInclusive = 0;
    private static final int endInclusive = 9;

    private long repeatCount;
    private List<Car> cars;
    private List<Car> winners;

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
        cars = Car.createCarsByName(carNames);

        validator.validateRepeatCount(inputRepeatCountStr);
        repeatCount = parser.parseRepeatCount(inputRepeatCountStr);

        for (int i = 0; i < repeatCount; i++) {
            racing.moveCars(cars);
            ioController.printResults(cars);
        }

        winners = judge.getWinners(cars);
        ioController.printWinners(winners);
    }
}
