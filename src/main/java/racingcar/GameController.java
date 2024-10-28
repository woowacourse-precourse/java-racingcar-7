package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView input;
    private final OutputView output;
    private final CarsManager manager;
    private int rounds = 0;

    public GameController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
        this.manager = new CarsManager(input.printStart());
    }

    public void run() {
        rounds = input.printRounds();
        output.showResultMessage();
        playGame();
        List<Car> cars = manager.getCars();
        getWinner(cars);
    }

    private void playGame() {
        for (int i = 0; i < rounds; i++) {
            manager.moveAll();
            roundResult();
        }
    }

    private void getWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int maxRange = 0;

        // 승자 거리 찾기
        for (Car car : cars) {
            maxRange = Math.max(maxRange, car.getDistance());
        }
        // 승자 거리와 일치하는 사람 찾기
        for (Car car : cars) {
            if (maxRange == car.getDistance()) {
                winner.add(car.getCarName());
            }
        }
        String winners = String.join(", ", winner);
        output.printWinners(winners);
    }

    private void roundResult() {
        List<Car> cars = manager.getCars();
        for (Car car : cars) {
            String carName = car.getCarName();
            int distance = car.getDistance();
            output.printRacing(carName, distance);
        }
        System.out.println();
    }
}
