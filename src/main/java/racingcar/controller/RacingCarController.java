package racingcar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.dto.UserInputDTO;
import racingcar.entity.Car;
import racingcar.entity.Race;
import racingcar.exception.ExceptionUtils;
import racingcar.exception.GeneralError;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.RacingView;

public class RacingCarController {
    final private RacingView racingView;
    final private RandomNumberGenerator randomNumberGenerator;

    public RacingCarController(RacingView racingView, RandomNumberGenerator randomNumberGenerator) {
        this.racingView = racingView;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        UserInputDTO userInput = getUserInput();

        List<String> carNames = List.of(userInput.carNames().split(","));
        int roundCount = Integer.parseInt(userInput.roundCount());

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Race race = new Race(cars);
        for (int i = 0; i < roundCount; i++) {
            race.runSingleRound(this.randomNumberGenerator);

            Map<String, Integer> roundState = new HashMap<>();
            for (Car car : cars) {
                roundState.put(car.getName(), car.getPosition());
            }
            racingView.printRoundResult(roundState);
        }

        racingView.printWinners(race.getWinners());
    }

    private UserInputDTO getUserInput() {
        UserInputDTO userInputDTO = new UserInputDTO(racingView.inputCarNames(), racingView.inputRoundCount());
        if (!userInputDTO.isValid()) {
            ExceptionUtils.throwIllegalArgException(GeneralError.EMPTY_INPUT);
        }
        return userInputDTO;
    }


}
