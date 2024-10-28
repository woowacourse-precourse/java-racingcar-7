package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingCenter;
import racingcar.domain.RacingResult;
import racingcar.dto.CarStatusDto;
import racingcar.util.InputSplitter;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final RacingCenter racingCenter = new RacingCenter();

    public void startGame() {
        RacingCars racingCars = registerRacingCars();
        int round = getRoundNumber();

        OutputView.printExecutionResultMessage();
        for (int i = 0; i < round; i++) {
            racingCars.updatePositionsWithRandomNumbers(generateRandomNumbers(countCars(racingCars)));
            OutputView.printRoundResult(racingCars.getStatus());
        }

        selectWinners(racingCars);
    }

    private RacingCars registerRacingCars() {
        OutputView.printInputCarNameMessage();
        List<String> carNames = InputSplitter.splitByComma(InputView.inputCarNames());
        List<Car> racingCars = racingCenter.registerCars(carNames);

        return new RacingCars(racingCars);
    }

    private int getRoundNumber() {
        OutputView.printInputRoundMessage();
        String inputRoundNumber = InputView.inputRoundNumber();

        return Integer.parseInt(inputRoundNumber);
    }

    private List<Integer> generateRandomNumbers(int racingCarCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < racingCarCount; i++) {
            randomNumbers.add(RandomNumberGenerator.generate());
        }

        return randomNumbers;
    }

    private int countCars(RacingCars racingCars) {
        return racingCars.getStatus().size();
    }

    private void selectWinners(RacingCars racingCars) {
        List<CarStatusDto> raceResults = racingCars.getStatus();
        RacingResult racingResult = new RacingResult(raceResults);
        OutputView.printWinnerNames(racingResult.selectWinners());
    }
}
