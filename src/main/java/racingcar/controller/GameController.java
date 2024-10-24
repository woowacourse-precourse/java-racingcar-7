package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.FinalResultDto;
import racingcar.dto.RoundResultDto;
import racingcar.model.CarMaker;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarMaker carMaker;
    private final RacingGame racingGame;

    public GameController(InputView inputView, OutputView outputView, CarMaker carMaker, RacingGame racingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carMaker = carMaker;
        this.racingGame = racingGame;
    }

    public void start() {
        String carNames = inputView.requestCarNamesInput();
        int roundNumber = Integer.parseInt(inputView.requestRoundNumberInput());
        List<Car> carList = carMaker.makeCars(carNames);

        FinalResultDto finalResultDto = racingGame.playRacingGame(roundNumber, carList);

        for (int i = 0; i < roundNumber; i++) {
            RoundResultDto roundResultDto = finalResultDto.roundResultList().get(i);
            outputView.printRoundResult(roundResultDto.roundNumber(), roundResultDto.carList());
        }

        outputView.printFinalResult(finalResultDto.winnerList());
    }
}
