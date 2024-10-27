package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final RacingGameService racingGameService;

    public RacingController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void startRacingGame() {
        try {
            String carNames = InputView.getCarNames();
            Integer tryCount = getTryCountByInteger();
            List<RacingCar> racingCars = racingGameService.initializeRacingGame(carNames);
            playRacingGame(tryCount, racingCars);
            printWinners(racingCars);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private Integer getTryCountByInteger() {
        String tryCountInString = InputView.getTryCount();
        return racingGameService.convertTryCountToInt(tryCountInString);
    }

    private void playRacingGame(Integer tryCount, List<RacingCar> racingCars) {
        OutputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveRacingCars(racingCars);
            OutputView.printGame(racingCars);
        }
    }

    private void printWinners(List<RacingCar> racingCars) {
        List<RacingCar> winners = racingGameService.getWinners(racingCars);
        OutputView.printWinners(winners);
    }

    private void moveRacingCars(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(Randoms.pickNumberInRange(0, 9));
        }
    }


}
