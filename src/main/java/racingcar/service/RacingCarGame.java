package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarGameResult;
import racingcar.util.generator.RacingCarGenerator;
import racingcar.util.generator.RacingCarGameRandomGenerator;
import racingcar.util.selector.RacingCarGameWinnerSelector;
import racingcar.util.parser.RacingCarNameParser;
import racingcar.util.transporter.RacingCarTransporter;
import racingcar.util.validator.RacingCarGameValidator;

public class RacingCarGame {
    private final RacingCarNameParser racingCarNameParser;
    private final RacingCarGameValidator racingCarGameValidator;
    private final RacingCarGenerator racingCarGenerator;
    private final RacingCarTransporter racingCarTransporter;
    private final RacingCarGameWinnerSelector racingCarGameWinnerSelector;
    private final RacingCarGameRandomGenerator racingCarRandomGenerator;
    private static final String WINNER_NAME_DELIMITER = ", ";

    public RacingCarGame(
            RacingCarNameParser racingCarNameParser,
            RacingCarGameValidator racingCarGameValidator,
            RacingCarGenerator racingCarGenerator,
            RacingCarTransporter racingCarTransporter,
            RacingCarGameWinnerSelector racingCarGameWinnerSelector,
            RacingCarGameRandomGenerator racingCarRandomGenerator
    ) {
        this.racingCarNameParser = racingCarNameParser;
        this.racingCarGameValidator = racingCarGameValidator;
        this.racingCarGenerator = racingCarGenerator;
        this.racingCarTransporter = racingCarTransporter;
        this.racingCarGameWinnerSelector = racingCarGameWinnerSelector;
        this.racingCarRandomGenerator = racingCarRandomGenerator;
    }

    public RacingCarGameResult playRacingGame(String carNames, int moveCount) {
        List<String> racingCarNames = racingCarNameParser.parseNamesStringToList(carNames);
        racingCarGameValidator.validateCarNames(racingCarNames);
        racingCarGameValidator.validateMoveCount(moveCount);
        List<RacingCar> racingCars = racingCarGenerator.generateCar(racingCarNames);
        String gameResult = startRacingGame(racingCars, moveCount);

        List<RacingCar> gameWinners = racingCarGameWinnerSelector.generateWinner(racingCars);
        String gameWinnerNames = getGameWinnersToWinnerNames(gameWinners);

        return new RacingCarGameResult(gameResult, gameWinnerNames);
    }

    private String getGameWinnersToWinnerNames(List<RacingCar> gameWinners) {
        return gameWinners.stream()
                .map(winner -> winner.getName())
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));
    }

    private String startRacingGame(List<RacingCar> racingCars, int moveCount) {
        StringBuilder gameState = new StringBuilder();

        for (int i = 0; i < moveCount; i++) {
            List<Integer> randomNumbers = racingCarRandomGenerator.generateRandomNumbers(racingCars.size());
            racingCarTransporter.transportRacingCar(racingCars, randomNumbers);
            gameState.append(recordRacingCarState(racingCars)).append("\n");
        }

        return gameState.toString();
    }

    private String recordRacingCarState(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(racingCar -> racingCar.getState())
                .collect(Collectors.joining("\n"));
    }
}
