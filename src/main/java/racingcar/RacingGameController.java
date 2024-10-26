package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class RacingGameController {

    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String inputCarNames = inputView.inputCarNames();

        Cars cars = registerCar(inputCarNames);

        String inputTryCount = inputView.inputTryCount();

        TryCount tryCount = registerTryCount(inputTryCount);

        RacingGame racingGame = new RacingGame(cars);

        for (int i = 0; i < tryCount.getCount(); i++) {
            racingGame.round();
        }

        racingGame.checkWinner();
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
