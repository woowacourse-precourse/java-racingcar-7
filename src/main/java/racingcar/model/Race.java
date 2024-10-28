package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Race {
    private final Map<String, Car> cars = new HashMap<>();

    public Race(List<String> carNames) {
        for (String name : carNames) {
            cars.put(name, new Car(name));
        }
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    private List<Car> getMovableCars(CarMovement carMovement) {
        return cars.values().stream()
                .filter(car -> car.canMove(carMovement)) // canMove 메서드로 이동 가능 여부 확인
                .collect(Collectors.toList());
    }

    public void moveCars(CarMovement carMovement) {
        List<Car> movableCars = getMovableCars(carMovement); // 이동할 수 있는 자동차 리스트 가져오기

        // 이동할 자동차에 메서드 호출해서 위치 업데이트
        for (Car car : movableCars) {
            car.move();
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.values().stream()    // 최대 이동 거리 계산
                .mapToInt(car -> car.getPosition().length())
                .max()
                .orElse(0);

        return cars.values().stream()   // 최대 이동 거리와 동일한 자동차 필터링(우승자 여러명인지 체크)
                .filter(car -> car.getPosition().length() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
