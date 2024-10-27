package racingcar;

import java.util.List;

public class GameController {
    public final InputView input;
    public final CarsManager manager;

    public GameController(InputView input) {
        this.input = input;
        this.manager = new CarsManager(input.printStart());
    }

    public void playGame() {
        input.printStart();
        int rounds = input.printRounds();
        for (int i = 0; i < rounds; i++) {
            manager.moveAll();
            roundResult();
        }
    }

    public void roundResult() {
        List<Car> cars = manager.getCars();
        for (Car car : cars) {
            String carName = car.getCarName();
            int distance = car.getDistance();
            System.out.print(carName + " : " + "-".repeat(distance));
        }
    }

}
