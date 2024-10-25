package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarData {
    private final List<Car> cars = new ArrayList<>();

    // Car 객체 리스트를 생성하여 저장하는 메서드
    public void addCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    // 최대 위치 값 반환
    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    // 최대 위치에 있는 자동차들의 이름 반환
    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    // 모든 자동차 객체 반환 (외부 조작 불가하게 보호)
    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
