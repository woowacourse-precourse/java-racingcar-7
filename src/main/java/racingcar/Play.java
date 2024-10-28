package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {
    private List<Car> cars;

    public Play(List<Car> cars) {
        this.cars = cars;
    }

    public void play(String tryCountString) {
        try {
            int tryCount = Integer.parseInt(tryCountString);

            System.out.println("실행 결과");
            for (int i = 0; i < tryCount; ++i) {
                moveCars();
                printOneIteration();
                System.out.println();
            }

        } catch (NumberFormatException npe) {
            throw new IllegalArgumentException();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);

            if (randomValue >= 4) {
                car.move();
            }
        }
    }

    private void printOneIteration() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
    }
}
