package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.PrintMessage;

public class RacingCarPlay {

    private final PrintMessage message = new PrintMessage();
    private final CarFactory carFactory = new CarFactory();
    private final GameExecutor gameExecutor = new GameExecutor();
    private final WinnerCalculator winnerCalculator = new WinnerCalculator();

    public void play() {
        message.printStartMessage();
        String input = Console.readLine();
        InputValidator.nullValidate(input);
        String[] carNames = input.split(",");
        InputValidator.lenValidate(carNames);
        List<Car> cars = carFactory.createCars(carNames);

        message.printAttemptsMessage();
        int attempts = Integer.parseInt(Console.readLine());
        InputValidator.attemptsValidate(attempts);

        message.printResultMessage();
        for (int i = 0; i < attempts; i++) {
            gameExecutor.currentGamePlay(cars);
        }

        String winners = winnerCalculator.determineWinners(cars);
        message.printEndGameMessage(winners);
    }

}
