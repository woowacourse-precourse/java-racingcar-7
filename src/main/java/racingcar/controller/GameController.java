package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import racingcar.model.car.Cars;
import racingcar.dto.RoundSnapshot;
import racingcar.dto.WinnersDto;
import racingcar.model.game.Game;
import racingcar.model.game.NumberPicker;
import racingcar.model.game.RandomNumberPicker;
import racingcar.model.game.TotalRounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private static final String DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private final GameInputValidator gameInputValidator;

    public GameController(InputView inputView, OutputView outputView, GameInputValidator gameInputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameInputValidator = gameInputValidator;
    }

    public void start() {
        Game game = makeGame();

        List<RoundSnapshot> roundSnapshots = new ArrayList<>();

        while (game.isPlaying()) {
            game.playNextRound();

            roundSnapshots.add(new RoundSnapshot(game.getCarSnapshots()));
        }
        outputView.displayRoundSnapshots(roundSnapshots);

        game.judgeWinners();
        outputView.displayWinners(new WinnersDto(game));
    }

    private Game makeGame() {
        String carNamesInput = inputView.getNameOfCars();
        gameInputValidator.validateNameOfCars(carNamesInput);

        String totalRoundsInput = inputView.getTotalRounds();
        gameInputValidator.validateTotalRounds(totalRoundsInput);

        String[] carNames = Stream.of(carNamesInput.split(DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);

        Cars cars = new Cars(carNames);
        TotalRounds totalRounds = new TotalRounds(Integer.parseInt(totalRoundsInput));
        NumberPicker numberPicker = new RandomNumberPicker();

        return new Game(cars, totalRounds, numberPicker);
    }
}