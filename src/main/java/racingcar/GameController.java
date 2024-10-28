package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public final InputView input;
    public final OutputView output;
    public final CarsManager manager;

    public GameController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
        this.manager = new CarsManager(input.printStart());
    }

    public void run() {
        input.printStart();
        input.printRounds();
        output.showResultMessage();
    }

    public void playGame() {
        int rounds = input.printRounds();
        for (int i = 0; i < rounds; i++) {
            manager.moveAll();
            roundResult();
        }
    }

    public void getWinner(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        int maxRange = 0;
        // 승자 거리 찾기
        for (Car car : cars) {
            maxRange = Math.max(maxRange, car.getDistance());
        }
        // 승자 거리와 일치하는 사람 찾기
        for (Car car : cars) {
            if (maxRange == car.getDistance()) {
                winner.add(car);
            }
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
