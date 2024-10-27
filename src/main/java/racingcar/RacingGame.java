package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int runLimit;

    public RacingGame(List<Car> cars, int runtLimit) {
        this.cars = cars;
        this.runLimit = runtLimit;
    }

    public void run() {
        for (int i = 0; i < runLimit; i++) {
            for (Car car : cars) {
                int number = Randoms.pickNumberInRange(0, 9);
                car.moveForward(number);
            }

            printResult();
        }
    }

    public void printResult() {
        for (Car car : cars) {
            int position = car.getPosition();
            System.out.println(car.getName() + " : " + "-".repeat(position));
        }

        System.out.println();
    }

    public void printWinners() {
        List<String> winners = new ArrayList<>();
        int max = getMaxPosition();

        for (Car car : cars) {

            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }

        return max;
    }
}
