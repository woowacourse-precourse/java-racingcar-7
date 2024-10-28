package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;
    private int currentRound;

    public RacingGame(String carNames, int rounds) {
        this.cars = createCars(carNames);
        this.rounds = rounds;
        this.currentRound = 0;
    }

    private List<Car> createCars(String name) {
        String[] carNameArray = name.split(",");

        // 이름 길이 검증
        for (String carName : carNameArray) {
            String trimmedName = carName.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        // 검증 후 car객체 생성
        List<Car> cars = new ArrayList<>();

        for (String carName : carNameArray) {
            cars.add(new Car(carName.trim()));
        }
        return cars;
    }

    public boolean hasNextRound() {
        return currentRound < rounds;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
        currentRound++;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
