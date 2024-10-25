package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.FinalResultDto;
import racingcar.dto.RoundResultDto;
import racingcar.model.CarMaker;
import racingcar.model.RacingGame;
import racingcar.model.RoundNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarMaker carMaker;
    private final RacingGame racingGame;
    private final RoundNumberValidator roundNumberValidator;

    public GameController(InputView inputView, OutputView outputView, CarMaker carMaker, RacingGame racingGame,
                          RoundNumberValidator roundNumberValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carMaker = carMaker;
        this.racingGame = racingGame;
        this.roundNumberValidator = roundNumberValidator;
    }

    public void start() {
        String carNames = inputView.requestCarNamesInput();
        int roundNumber = getRoundNumber();

        List<Car> carList = carMaker.makeCars(carNames);
        FinalResultDto finalResultDto = racingGame.playRacingGame(roundNumber, carList);

        printResults(finalResultDto, roundNumber);
    }

    private int getRoundNumber() {
        int roundNumber = Integer.parseInt(inputView.requestRoundNumberInput());
        roundNumberValidator.validateRoundNumber(roundNumber);
        return roundNumber;
    }

    private void printResults(FinalResultDto finalResultDto, int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            RoundResultDto roundResultDto = finalResultDto.roundResultList().get(i);
            outputView.printRoundResult(roundResultDto.roundNumber(), roundResultDto.carList());
        }
        outputView.printFinalResult(finalResultDto.winnerList());
    }
}
