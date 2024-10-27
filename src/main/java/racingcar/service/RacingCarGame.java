package racingcar.service;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarGameResult;
import racingcar.util.generator.RacingCarGenerator;
import racingcar.util.generator.RacingCarGameRandomGenerator;
import racingcar.util.generator.RacingCarWinnerGenerator;
import racingcar.util.parser.RacingCarNameParser;
import racingcar.util.transporter.RacingCarTransporter;
import racingcar.util.validator.RacingCarGameValidator;

public class RacingCarGame {
    private final RacingCarNameParser racingCarNameParser;
    private final RacingCarGameValidator racingCarGameValidator;
    private final RacingCarGenerator racingCarGenerator;
    private final RacingCarTransporter racingCarTransporter;
    private final RacingCarWinnerGenerator racingCarWinnerGenerator;
    private final RacingCarGameRandomGenerator racingCarRandomGenerator;
    private static final String WINNER_NAME_DELIMITER = ", ";

    public RacingCarGame(
            RacingCarNameParser racingCarNameParser,
            RacingCarGameValidator racingCarGameValidator,
            RacingCarGenerator racingCarGenerator,
            RacingCarTransporter racingCarTransporter,
            RacingCarWinnerGenerator racingCarWinnerGenerator,
            RacingCarGameRandomGenerator racingCarRandomGenerator
    ) {
        this.racingCarNameParser = racingCarNameParser;
        this.racingCarGameValidator = racingCarGameValidator;
        this.racingCarGenerator = racingCarGenerator;
        this.racingCarTransporter = racingCarTransporter;
        this.racingCarWinnerGenerator = racingCarWinnerGenerator;
        this.racingCarRandomGenerator = racingCarRandomGenerator;
    }

    public RacingCarGameResult playRacingGame(String carNames, int moveCount) {
        List<String> racingCarNames = racingCarNameParser.parseNamesStringToList(carNames);
        racingCarGameValidator.validateCarNames(racingCarNames);
        racingCarGameValidator.validateMoveCount(moveCount);
        List<RacingCar> racingCars = racingCarGenerator.generateCar(racingCarNames);
        String gameResult = startRacingGame(racingCars, moveCount);

        List<RacingCar> gameWinners = racingCarWinnerGenerator.generateWinner(racingCars);
        String gameWinnerNames = getGameWinnersToWinnerNames(gameWinners);

        return new RacingCarGameResult(gameResult, gameWinnerNames);
    }

    private String getGameWinnersToWinnerNames(List<RacingCar> gameWinners) {
        String[] winners = gameWinners.stream()
                .map(winner -> winner.getName())
                .toArray(String[]::new);
        return String.join(WINNER_NAME_DELIMITER, winners);
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
        StringBuilder racingCarState = new StringBuilder();

        for (RacingCar racingCar : racingCars) {
            racingCarState.append(racingCar.getState()).append("\n");
        }

        return racingCarState.toString();
    }
}
