package racingcar.controller;

import java.util.List;
import racingcar.domain.RaceResult;
import racingcar.model.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void run() {
        outputView.startMessage();
        List<Car> racingCars = inputView.getNames();

        outputView.trialCountMessage();
        int numberOfTries = inputView.getTrialNumber();

        //TODO: 시도 횟수만큼 레이스 반복
        for (int i = 0; i < numberOfTries; i++) {
            race(racingCars);
            outputView.showRaceStatus(racingCars);
        }

        //TODO: 최종 우승자 선정 및 출력
        List<Car> winners = RaceResult.getWinners(racingCars);
        outputView.finalWinnerMessage(winners);
    }

    public void race(List<Car> racingCars) {
        for (Car car : racingCars) {
            int randomValue = randomNumberGenerator.generateRandomNumber();
            car.move(randomValue);
        }
    }
}
