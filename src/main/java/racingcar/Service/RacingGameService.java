package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Entity.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private final List<Car> cars;
    private final int attemptCount;

    public RacingGameService(List<String> carNames, int attemptCount) {// Car 객체 생성, 시도횟수 초기화
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.attemptCount = attemptCount;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void playRound() { // 게임한라운드, 이동
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.setPosition();
            }
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream() // 가장 먼 값 찾기
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream() // 가장 멀리간 차들 추출
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
