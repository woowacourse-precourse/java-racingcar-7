package racingcar;

import racingcar.io.Input;
import racingcar.io.View;

public class Application {
    public static void main(String[] args) {
        View view = View.getInstance();
        Input input = Input.getInstance();

        view.printCarNamesGuide();
        String carNames = input.carNames();

        view.printRoundsGuide();
        Integer rounds = Integer.parseInt(input.rounds());

        CarRegistry carRegistry = new CarRegistry(carNames);
        RaceResult result = new RaceResult(new StringBuilder(), carRegistry);
        Stadium stadium = new Stadium(carRegistry, result);

        stadium.runGame(rounds);

        view.printExecutionOutput(result.toString());
        view.printWinner(result.winnersToString());
    }
}
