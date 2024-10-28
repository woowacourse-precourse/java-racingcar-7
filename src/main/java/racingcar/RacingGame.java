package racingcar;

import java.util.List;

class RacingGame {

    private final List<Car> cars;
    private int round = 0;

    public RacingGame(List<String> names) {
        this.cars = names.stream().map(Car::new).toList();
    }

    public void playNextRound() {
        round += 1;
        for (Car car : cars) {
            car.move();
        }
    }

    public RoundStatus getRoundStatus() {
        List<CarStatus> carStatusList = cars.stream()
                .map(it -> new CarStatus(
                        it.getName(),
                        it.getPosition()))
                .toList();
        return new RoundStatus(round, carStatusList);
    }
}
