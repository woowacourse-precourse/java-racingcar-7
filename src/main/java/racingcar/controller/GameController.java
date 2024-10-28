package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import racingcar.config.GameFactory;
import racingcar.dto.RoundSnapshotDto;
import racingcar.dto.WinnersDto;
import racingcar.model.game.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private static final String DELIMITER = ",";
    private final GameInputValidator gameInputValidator;

    public GameController(GameInputValidator gameInputValidator) {
        this.gameInputValidator = gameInputValidator;
    }

    public void executeGame() {
        Game game = createGame();

        List<RoundSnapshotDto> roundSnapshotDtos = playRounds(game);
        OutputView.displayRoundSnapshots(roundSnapshotDtos);

        game.judgeWinners();
        OutputView.displayWinners(new WinnersDto(game));
    }

    private List<RoundSnapshotDto> playRounds(Game game) {
        List<RoundSnapshotDto> roundSnapshotDtos = new ArrayList<>();

        while (game.hasMoreRounds()) {
            game.playNextRound();
            roundSnapshotDtos.add(new RoundSnapshotDto(game.getCarSnapshots()));
        }

        return roundSnapshotDtos;
    }

    private Game createGame() {
        String carNamesInput = InputView.getNameOfCars();
        gameInputValidator.validateNameOfCars(carNamesInput);

        String totalRoundsInput = InputView.getTotalRounds();
        gameInputValidator.validateTotalRounds(totalRoundsInput);

        String[] carNames = Stream.of(carNamesInput.split(DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);

        return GameFactory.create(carNames, Integer.parseInt(totalRoundsInput));
    }
}