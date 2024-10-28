package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.dto.WinnerDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private InputView inputView;
    private OutputView outputView;
    private RacingCars racingCars;
    private UserInputProcessor userInputProcessor;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingCars = null;
        this.userInputProcessor = new UserInputProcessor();
    }

    public void game() {
        List<String> racingCarNames = prepareRacingCarNames();
        Integer totalAttempts = prepareTotalAttempts();

        racingCars = RacingCars.createRacingCars(racingCarNames, totalAttempts);

        outputView.printResult();
        race();
        outputView.printWinner(getWinnerDto());
    }

    private List<String> prepareRacingCarNames() {
        return userInputProcessor.processCarName(inputView.getRacingCarNames());
    }

    private Integer prepareTotalAttempts() {
        return userInputProcessor.processTotalAttempts(inputView.getTotalAttempts());
    }

    private void race() {
        while (racingCars.isNotEnoughAttempts()) {
            List<RacingCar> attemptResult = racingCars.attempt();
            outputView.printAttemptResult(attemptResult);
        }
    }

    private List<WinnerDto> getWinnerDto() {
        List<RacingCar> winners = racingCars.findWinners();
        return winners.stream()
                .map(winner -> new WinnerDto(winner.getCarName()))
                .toList();
    }
}
