package racingcar;

public class Application {
    public static void main(String[] args) {
        String cars = InputView.readCars();
        int trials = Integer.parseInt(InputView.readTrials());
        GameController gameController = new GameController(new Racing(cars));
        gameController.run(trials);
    }
}
