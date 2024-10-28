package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
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

        Race race = new Race(createCars(carNames));
        startRace(roundCount, race);

        List<String> winners = race.getWinners();
        racingView.printWinners(winners);
    }

    private void startRace(int roundCount, Race race) {
        racingView.printRaceBegin();
        for (int i = 0; i < roundCount; i++) {
            race.runSingleRound(this.randomNumberGenerator);
            racingView.printRoundResult(race.getRaceHistory().getLastRound());
        }
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private UserInputDTO getUserInput() {
        UserInputDTO userInputDTO = new UserInputDTO(racingView.inputCarNames(), racingView.inputRoundCount());
        if (!userInputDTO.isValid()) {
            ExceptionUtils.throwIllegalArgException(GeneralError.EMPTY_INPUT);
        }
        return userInputDTO;
    }


}
