package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RacingcarModel {

    private final List<Car> cars = new ArrayList<>();

    // 자동차 초기화
    public void initializeCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    // 한 라운드 동안 모든 자동차 시도 이동
    public void raceOneRound() {
        for (Car car : cars) {
            car.attemptMove();
        }
    }

    // 현재 자동차 상태 반환
    public List<Car> getCarStates() {
        return new ArrayList<>(cars);  // 방어적 복사로 외부 변경 차단
    }

    // 우승자 결정
    public String getWinners() {
        int maxDistance = calculateMaxDistance();
        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }

        return winners.toString();
    }


    // 가장 많이 이동한 거리 계산
    private int calculateMaxDistance() {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }
}
