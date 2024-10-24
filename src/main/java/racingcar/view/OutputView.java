package racingcar.view;

import java.util.HashMap;
import racingcar.controller.domain.Car;

public class OutputView {
    private final StringBuilder sb = new StringBuilder();

    public void printRoundOutput(HashMap<Car, Integer> carToRacingProgress) {
        for (Car car : carToRacingProgress.keySet()) {
            sb.append(car.getName()).append(" : ").append(carToRacingProgress.get(car)).append("\n");
        }
        System.out.println(sb);
    }
}
