package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RaceCarServiceImpl implements RaceCarService {
    private final List<Car> carNames;
    private final int gameCount;

    private final int START_RANGE = 1;
    private final int END_RANGE = 9;


    public RaceCarServiceImpl(List<Car> carNames, int gameCount) {
        this.carNames = carNames;
        this.gameCount = gameCount;
    }

    @Override
    public void playEachRound() {
        for (int i = 0; i < gameCount; i++) {
            for (Car car : carNames) {
                int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
                car.printMyTrace(randomNumber);
            }
            System.out.println();
        }
    }

    @Override
    public String announceWinner() {
        List<String> winners = new ArrayList<>();
        int max_dist = 0;
        for (Car car : carNames) {
            int car_dist = car.getDist();
            if (car_dist > max_dist) {
                max_dist = car_dist;
            }
        }

        if (max_dist == 0) {
            throw new IllegalArgumentException("[ERROR] 전진 거리가 모두 0이므로 우승자가 없습니다.");
        }

        for (Car car : carNames) {
            if (max_dist == car.getDist()) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }
}
