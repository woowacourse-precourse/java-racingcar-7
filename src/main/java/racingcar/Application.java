package racingcar;

import racingcar.car.CarRegistry;
import racingcar.io.Input;
import racingcar.io.View;

public class Application {
    private final Stadium stadium;
    private final RaceResult raceResult;

    private Application(String input) {
        CarRegistry carRegistry = new CarRegistry(input);
        this.raceResult = new RaceResult(new StringBuilder(), carRegistry);
        this.stadium = new Stadium(carRegistry, raceResult);
    }

    public static void main(String[] args) {
        View view = View.getInstance();
        Input input = Input.getInstance();

        view.printCarNamesGuide();
        String carNames = input.carNames();

        view.printRoundsGuide();
        Integer rounds = Integer.parseInt(input.rounds());
        input.closeConsole();

        Application application = new Application(carNames);
        application.run(view, rounds);
    }

    private void run(View view, Integer rounds) {
        stadium.runGame(rounds);

        view.printExecutionOutput(raceResult.toString());
        view.printWinner(raceResult.winnersToString());
    }
}
