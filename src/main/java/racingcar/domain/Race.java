package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final int MOVE_THRESHOLD = 4; // 전진할 수 있는 최소 무작위 값
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            raceRound();
        }
    }

    private void raceRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);

            if (randomValue >= MOVE_THRESHOLD) {
                car.moveForward();
            }

            System.out.println(car.toString());

        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

}
