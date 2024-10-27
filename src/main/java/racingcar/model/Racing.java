package racingcar.model;

import java.util.List;

import static racingcar.model.RandomNumberGenerator.randomNumber;
import static racingcar.view.OutputView.printRoundResults;

public class Racing {
    private final List<Car> cars;
    private final int rounds;

    public Racing(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public boolean interpretCommand(){
        if(randomNumber() >= 4){
            return true;
        }
        return false;
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.moveForward(interpretCommand());
            }
            printRoundResults(cars); // 라운드 결과 기록
        }
    }

    public List<Car> getWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getCurrentPosition() == maxDistance)
                .toList();
    }
}
