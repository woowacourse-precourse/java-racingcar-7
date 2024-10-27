package racingcar.domain;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * RaceState 클래스는 경주의 상태를 관리하고 라운드별 전진 여부를 결정한다.
 */
public class RaceState {

    private static final int MIN_ADVANCE_CONDITION = 4; // 자동차 전진을 위한 최소 조건값
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;

    private final List<Car> cars = new ArrayList<>();

    public void initGame(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void playRound() {
        for (Car car : cars) {
            if (getRandomNumber() >= MIN_ADVANCE_CONDITION) {
                car.forward();
            }
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return WinnerSelector.selectWinner(cars);
    }

}
