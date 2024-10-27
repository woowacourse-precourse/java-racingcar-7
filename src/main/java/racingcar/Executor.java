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

    Executor(IOController ioController, Parser parser, Validator validator, Racing racing) {
        this.ioController = ioController;
        this.parser = parser;
        this.validator = validator;
        this.racing = racing;
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
        final long maxMoveCount = cars.stream()
            .mapToLong(Car::getMoveCount).max().orElse(0);

        winners = cars.stream()
            .filter(car -> car.getMoveCount() == maxMoveCount)
            .toList();

        return winners;
    }
}
