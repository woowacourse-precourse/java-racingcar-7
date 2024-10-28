package racingcar;

import racingcar.game.GameRule;
import racingcar.game.RacingGame;
import racingcar.game.RacingGameLogFormatter;
import racingcar.game.RacingGameLogger;
import racingcar.game.car.Car;
import racingcar.game.winner.RacingWinnerFinder;
import racingcar.ui.StringPrinter;
import racingcar.ui.reader.InputReader;

import java.util.List;

public class MyRacingProgram {
    private static final int STARTING_POINT = 0;

    private final InputReader inputReader;
    private final StringPrinter printer;

    public MyRacingProgram(InputReader inputReader, StringPrinter printer) {
        this.inputReader = inputReader;
        this.printer = printer;
    }

    public void start() {
        List<Car> players = createCars(inputReader.readNames());
        int attempts = inputReader.readMovementAttempts();

        RacingGame myGame = new RacingGame(
                new GameRule(new NumberGenerator()),
                new RacingWinnerFinder(),
                new RacingGameLogger(printer, new RacingGameLogFormatter())
        );

        myGame.play(players, attempts);
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                .map(name -> new Car(name, STARTING_POINT))
                .toList();
    }
}
