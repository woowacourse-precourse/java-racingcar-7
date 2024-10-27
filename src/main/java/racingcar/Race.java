package racingcar;

import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void run(int rounds) {
        for (int i = 0; i < rounds; i++){
            playRound();
            Result.printRoundResult(cars);
        }
    }

    private void playRound() {
        cars.forEach(car -> car.move(Utils.isMovable()));
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
