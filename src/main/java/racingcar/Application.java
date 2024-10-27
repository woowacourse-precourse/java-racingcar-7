package racingcar;

public class Application {
    public static void main(String[] args) {
        String cars = InputView.readCars();
        int trials = Integer.parseInt(InputView.readTrials());
        Racing racing = new Racing(cars);
        System.out.println(racing.race(trials));
    }
}
