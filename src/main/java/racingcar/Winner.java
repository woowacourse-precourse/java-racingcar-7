package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final static int INIT_WINNER_POSITION = 0;
    private final static String DELIMITER = ", ";
    private final static String WINNER = "최종 우승자 : ";

    private final List<String> winners = new ArrayList<>();


    private void judge(List<Car> cars) {
        int max = INIT_WINNER_POSITION;

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

        System.out.println(WINNER + String.join(DELIMITER, winners));
    }

    public List<String> getWinners() {
        return winners;
    }
}
