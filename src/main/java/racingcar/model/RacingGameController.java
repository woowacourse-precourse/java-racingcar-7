package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String inputCarNames = inputView.inputCarNames();

        Players players = registerCar(inputCarNames);

        String inputTryCount = inputView.inputTryCount();

        TryCount tryCount = registerTryCount(inputTryCount);

        RacingGame racingGame = new RacingGame(players);

        outputView.printRoundHeader();
        for (int i = 0; i < tryCount.getCount(); i++) {
            racingGame.round();
            outputView.printRoundResult(players.getPlayers());
        }

        List<Car> winners = racingGame.checkWinner();
        outputView.printWinner(winners);
    }

    public Players registerCar(String input) {
        Players players = new Players();

        List<String> names = Arrays.stream(splitInput(input)).toList();

        players.registerAll(names);

        return players;
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
