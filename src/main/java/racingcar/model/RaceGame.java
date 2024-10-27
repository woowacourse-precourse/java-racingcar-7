package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static racingcar.model.ModelConstants.*;

public class RaceGame {
    private List<Car> cars;

    public RaceGame(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name, POSITION_INITIALIZE.getValue()));
        }
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(car.createRandomNumber());
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0); // 리스트가 비어 있을 경우 최대 값을 0으로 처리하여 오류 방지

        // 2. 최고 위치와 같은 위치에 있는 자동차를 우승자로 필터링
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
