package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.RaceValidator;

import java.util.ArrayList;
import java.util.List;

public record Race(List<Car> cars, int attempts) {
    public Race {
        RaceValidator.validateCars(cars); // 생성자에서 자동차 리스트 검증
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;

        // 최대 위치 찾기
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        // 우승자 찾기
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void startRace() {
        for (Car car : cars) {
            int randomValue = pickRandomValue();
            if (randomValue >= 4) {
                car.moveForward(); // 자동차 전진
            }
        }
    }

    private int pickRandomValue() {
        return Randoms.pickNumberInRange(0, 9); // 랜덤 값 생성
    }
}
