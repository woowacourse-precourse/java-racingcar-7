package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class RacingGameController {

    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String carNames = inputView.inputCarNames();

        Cars cars = new Cars();

        List<String> names = Arrays.stream(splitInput(carNames)).toList();

        cars.registerAll(names);

        System.out.println(cars);

        String inputTryCount = inputView.inputTryCount();

        TryCountDto tryCountDto = new TryCountDto(inputTryCount);

        int count = Integer.parseInt(tryCountDto.input());

        TryCount tryCount = TryCount.from(count);

        System.out.println(tryCount);

        RacingGame racingGame = new RacingGame(cars, tryCount);
        racingGame.play();
    }


    public String[] splitInput(String input) {
        return input.split(",",-1);
    }

}
