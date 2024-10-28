package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarController;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.race.RaceController;

public class Application {
    private static final Input input = new Input();
    private static final CarController carController = new CarController();
    private static final RaceController raceController = new RaceController();
    private static final Output output = new Output();

    public static void main(String[] args) {
        String inputCar = input.readCar();
        List<Car> cars = carController.createCar(inputCar);

        int numberOfMove = input.readNumberOfMove();
        raceResult(numberOfMove, cars);
    }

    public static void raceResult(int numberOfMove, List<Car> cars) {
        output.printResult();

        for (int i = 0; i < numberOfMove; i++) {
            raceController.race(cars);
            output.printCar(cars);
        }

        output.printChampion(raceController.getChampion(cars));
    }
}
