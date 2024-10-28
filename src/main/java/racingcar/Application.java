package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = InputHandler.getCarNamesFromUser();
        int trials = InputHandler.getTrialCountFromUser();

        Race race = new Race(cars, trials);
        race.start();
        race.printWinners();
    }
}
