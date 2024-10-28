package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 레이싱 게임 관리 클래스
public class RacingGame {

    private final List<Car> cars = new ArrayList<>();

    // 자동차 추가 메소드
    public void initCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }

    // 라운드 진행 메소드
    public void play() {
        for (Car car : cars) {
            car.move();
        }
    }

    // getter
    public List<Car> getCars() {
        return cars;
    }

    // 우승자를 찾는 메소드
    public List<String> findWinners() {
        // 최대값(위치) 찾기
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0); // 자동차 리스트가 비어있는 경우 0 반환

        // 최대값에 도달한 자동차 필터링
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
