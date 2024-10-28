package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;
import racingcar.model.Car;
import racingcar.util.Util;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.Message;
import racingcar.view.OutputView;

public class GameService {
    public static final int START_NUMBER = 0;
    public static final int END_NUMBER = 9;
    public static final int THRESHOLD = 4;
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private Validator validator = new Validator();

    public List<Car> readyCar() {
        outputView.print(Message.INPUT_CAR_NAMES);
        String string = inputView.input();
        validator.validateNames(string);
        List<Car> cars = new ArrayList<>();
        for (String name : Util.splitByComma(string)) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public Long readyTimes() {
        outputView.print(Message.INPUT_TIMES);
        final Long times = inputView.longInput();
        validator.validateTimes(times);
        outputView.print("");
        return times;
    }

    public List<Car> playGame(List<Car> cars, Long times) {
        LongStream.range(0L, times)
                .forEach(n -> playSet(cars));
        return cars;
    }

    private void playSet(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) >= THRESHOLD) {
                car.forward();
            }
            outputView.printResult(car.getStatus());
        }
        outputView.print("");
    }

    public void showGameResult(List<Car> cars) {
        final Car maxCar = cars.stream()
                .max(Comparator.comparing(Car::getMileage)).get();
        List<Car> winner = cars.stream().filter(car -> car.isSameMileage(maxCar)).toList();
        outputView.printWinner(winner.stream().map(Car::getName).toList());
    }
}
