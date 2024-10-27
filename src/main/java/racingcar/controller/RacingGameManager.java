package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.TryCount;
import racingcar.domain.TryCountDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameManager {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String inputCarNames = inputView.inputCarNames();

        Cars cars = registerCar(inputCarNames);

        String inputTryCount = inputView.inputTryCount();

        TryCount tryCount = registerTryCount(inputTryCount);

        RacingGame racingGame = new RacingGame(cars);

        outputView.printRoundHeader();
        for (int i = 0; i < tryCount.getCount(); i++) {
            racingGame.round();
            outputView.printRoundResult(cars.getCars());
        }

        List<Car> winners = racingGame.checkWinner();
        outputView.printWinner(winners);
    }

    public Cars registerCar(String input) {
        Cars cars = new Cars();

        List<String> names = Arrays.stream(splitInput(input)).toList();

        cars.registerAll(names);

        return cars;
    }

    public TryCount registerTryCount(String input) {
        TryCountDto tryCountDto = new TryCountDto(input);

        int count = Integer.parseInt(tryCountDto.input());

        return TryCount.from(count);
    }


    public String[] splitInput(String input) {
        return input.split(",",-1);
    }

}
