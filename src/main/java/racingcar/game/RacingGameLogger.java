package racingcar.game;

import racingcar.game.car.Car;
import racingcar.game.winner.Winner;
import racingcar.ui.StringPrinter;

import java.util.List;

public class RacingGameLogger {
    private static final String EMPTY_STRING = "";
    private static final String GAME_START_MESSAGE = "실행 결과";

    private final StringPrinter printer;
    private final RacingGameLogFormatter logFormatter;

    public RacingGameLogger(StringPrinter printer, RacingGameLogFormatter logFormatter) {
        this.printer = printer;
        this.logFormatter = logFormatter;
    }

    public void logProgress(List<Car> playerCars) {
        for (Car playerCar : playerCars) {
            log(logFormatter.formatCar(playerCar));
        }
        logEmptyLine();
    }

    public void logWinner(Winner winner) {
        log(logFormatter.formatWinner(winner));
    }

    public void logStartMessage() {
        log(GAME_START_MESSAGE);
    }

    private void logEmptyLine() {
        log(EMPTY_STRING);
    }

    private void log(String message) {
        printer.print(message);
    }
}
