package racingcar;

import java.util.List;
import java.util.ArrayList;
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

    public void printWinner() {
        List<String> winner = new ArrayList<>();
        int max = 0;

        for (Car car : cars) {
            int distance = car.getDistance();

            if (distance > max) {
                max = distance;
                winner.clear();
                winner.add(car.getName());
            } else if (distance == max) {
                winner.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
