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
    }
}
