package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.ErrorMessage;

public class Race {
    List<Car> cars;
    int trial;

    public Race(List<Car> cars, int trial) {
        validateCars(cars);
        validateTrial(trial);
        this.cars = cars;
        this.trial = trial;
    }
    
    // 시도 횟수가 0 이하의 값일 경우 예외 처리
    private void validateTrial(int trial) {
        if (trial <= 0) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_UNDER_ZERO.getMessage());
        }
    }

    // 레이스에 참여한 자동차의 이름이 종복되었을 경우 예외 처리(set이용)
    private void validateCars(List<Car> cars) {
        int carCount = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet()).size();
                
        if (carCount != cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.getMessage());
        }
    }

    // 레이싱에 참가 중인 자동차들 중 가장 이동 거리가 큰 값을 탐색
    // 찾은 최대 이동 거리와 같은 이동 거리를 가진 자동차 객체들을 탐색하여 반환
    public List<Car> getWinner() {
        int maximumDistance = cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo).orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maximumDistance)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getTrial() {
        return this.trial;
    }
}
