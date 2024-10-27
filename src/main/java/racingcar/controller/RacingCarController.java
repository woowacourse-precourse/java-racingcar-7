package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.RacingCarService;
import racingcar.validator.Validator;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;
    private final Validator validator;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.racingCarView = new RacingCarView();
        this.validator = new Validator();
        this.racingCarService = new RacingCarService();
    }

    public void run() {
        String carInput = racingCarView.inputCarNames();
        validator.validateCarNames(carInput);
        String roundInput = racingCarView.inputRound();
        validator.validateRound(roundInput);

        Race race = setUpGame(carInput, roundInput);

        // TODO 결과 출력 view로 이동
        String roundResult = racingCarService.raceStart(race);
        String raceResult = racingCarService.findWinner(race);
        printResult(roundResult, raceResult);
    }

    private Race setUpGame(String carInput, String roundInput) {
        List<String> carNames = List.of(carInput.split(","));
        int round = Integer.parseInt(roundInput);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Race(cars, round);
    }

    private void printResult(String roundResult, String raceResult) {
        System.out.println("실행 결과");
        System.out.println(roundResult);
        System.out.println("최종 우승자 : " + raceResult);
    }
}
