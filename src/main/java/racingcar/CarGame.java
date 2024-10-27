package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    private List<Car> cars;
    private final Input input = new Input();
    private final Output output = new Output();
    private final Move move = new Move();

    public void run() {
        cars = input.carNames();
        int cnt = input.tryCount();

        System.out.println(Message.RUN_RESULT);

        for (int i = 0; i < cnt; i++) {
            oneTry();
        }
    }

    private void oneTry() {
        for (Car car : cars) {
            car.isMove(move.isBoolean());
        }

        output.carsStatus(cars);
        winners();
    }

    private void winners() {
        int maxWin = 0;
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() > maxWin)
                maxWin = car.getLocation();
        }

        for (Car car : cars) {
            if (car.getLocation() == maxWin)
                winnerNames.add(car.getName());
        }

        String result = String.join(", ", winnerNames);
        output.gameResult(result);
    }
}
