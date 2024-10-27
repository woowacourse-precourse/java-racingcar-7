package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.validator.Validator;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;
    private final Validator validator;

    public RacingCarController() {
        this.racingCarView = new RacingCarView();
        this.validator = new Validator();
    }

    public void run() {
        String carInput = racingCarView.inputCarNames();
        validator.validateCarNames(carInput);
        String roundInput = racingCarView.inputRound();
        validator.validateRound(roundInput);

        setUpGame(carInput, roundInput);
        // TODO 서비스 구현
        printResult();
    }

    private void setUpGame(String carInput, String roundInput) {
        List<String> carNames = List.of(carInput.split(","));
        int round = Integer.parseInt(roundInput);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Race race = new Race(cars, round);
    }

    public void printResult() {
        System.out.println("실행 결과");
    }
}
