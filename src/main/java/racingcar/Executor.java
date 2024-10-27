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
    private List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();

    private final IOController ioController;
    private final Parser parser;
    private final Validator validator;


    Executor(IOController ioController, Parser parser, Validator validator) {
        this.ioController = ioController;
        this.parser = parser;
        this.validator = validator;
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

        executeForCount(cars, repeatCount);

        winners = getWinners(cars);
        ioController.printWinners(winners);
    }

    public void executeForCount(List<Car> cars, long repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            moveCars(cars);
            ioController.printResults(cars);
        }
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    public void moveCar(Car car) {
        int randomVal = Randoms.pickNumberInRange(startInclusive, endInclusive);
        if (MOVE_STANDARD <= randomVal) {
            car.move();
        }
    }

    public List<Car> getWinners(List<Car> cars) {
        long maxMoveCount = 0;
        for (Car car : cars) {
            if (maxMoveCount < car.getMoveCount()) {
                maxMoveCount = car.getMoveCount();
            }
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxMoveCount == car.getMoveCount()) {
                winners.add(car);
            }
        }
        return winners;
    }
}
