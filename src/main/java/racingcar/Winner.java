package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<String> winners = new ArrayList<>();

    private void judge(List<Car> cars) {
        int max = 0;

        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }

        for (Car car : cars) {
            if (max == car.getPosition()) {
                winners.add(car.getName());
            }
        }

    }

    public void result(List<Car> cars) {
        judge(cars);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
