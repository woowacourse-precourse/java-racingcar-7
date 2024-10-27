package racingcar;

import racingcar.console.ConsoleService;

public class Application {
    public static void main(String[] args) {
        final var consoleService = ConsoleService.init();
        final var racing = consoleService.createRacing();

        consoleService.printStart();
        racing.play(consoleService::printCurrentLapResult);

        consoleService.printWinners(racing.getWinnerPlayerList());
    }
}