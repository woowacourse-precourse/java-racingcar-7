package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.*;

public class GameService {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final int gameCount;
    private final List<Car> carList;
    private final List<Map<String, Integer>> record;

    public GameService(int gameCount, List<String> carNames) {
        this.gameCount = gameCount;
        this.carList = generateCarList(carNames);
        this.record = new ArrayList<>();
    }

    private static List<Car> generateCarList(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public void runGame() {
        for (int cnt = 0; cnt < gameCount; cnt++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            moveIfConditionMet(car, randomNumber);
        }
        setRecord(carList); // 게임 판마다 진행상황 저장
    }

    private void setRecord(List<Car> cars) {
        Map<String, Integer> carPositionMap = new LinkedHashMap<>(); // 키의 순서 보장을 위한 LinkedHashMap
        for (Car car : cars) {
            carPositionMap.put(car.getName(), car.getPosition());
        }
        record.add(carPositionMap);
    }

    public List<String> getWinners() {
        int maxValue = getMaxPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition() == maxValue) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxValue = 0;
        for (Car car : carList) {
            if (car.getPosition() > maxValue) {
                maxValue = car.getPosition();
            }
        }
        return maxValue;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Map<String, Integer>> getRecord() {
        return record;
    }

    public void moveIfConditionMet(Car car, int num) {
        if (num >= 4) {
            car.moveForward();
        }
    }
}
