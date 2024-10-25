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
        Stadium stadium = new Stadium(carRegistry, rounds);
        stadium.runGame();

        view.printExecutionOutput(stadium.getResult());
        view.printWinner(stadium.getWinner());
    }
}
