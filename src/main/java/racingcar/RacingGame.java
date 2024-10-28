package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int attempts;

    public RacingGame(String[] carNames, int attempts) {
        for (String name : carNames) {
            if (!name.trim().isEmpty()) {
                cars.add(new Car(name.trim()));
            }
        }
        this.attempts = attempts;
    }

    // 게임 실행
    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            moveAllCars();
            printRaceStatus();
            System.out.println();
        }
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    // 우승자
    public String[] getWinners() {
        int max = findMaxPosition();
        int winnerCount = findCarNumber(max);
        return sendWinners(max, winnerCount);
    }

    private int findCarNumber(int max) {
        int winnerCount = 0;
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winnerCount++;
            }
        }
        return winnerCount;
    }

    private int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    private String[] sendWinners(int max, int winnerCount) {
        String[] winners = new String[winnerCount];
        int i = 0;
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners[i] = car.getName();
                i++;
            }
        }
        return winners;
    }
}
