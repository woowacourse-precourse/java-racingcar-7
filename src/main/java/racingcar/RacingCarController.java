package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    private Output output;
    private List<Car> cars;

    public RacingCarController(Output output, List<Car> cars) {
        this.output = output;
        this.cars = cars;
    }

    public void play(int time) {
        output.printResultString();
        for (int i = 0; i < time; i++) {
            for (Car car : cars) {
                car.randomMove();
            }
            output.printCars(cars);
        }
        List<String> winners = findWinner();
        output.printWinners(winners);
    }

    public List<String> findWinner() {
        List<String> winners = new ArrayList<>();
        int maxLocation = 0;

        for (Car car : cars) {
            if (maxLocation < car.getLocation()) {
                winners.clear();
                winners.add(car.getName());
            } else if (maxLocation == car.getLocation()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
