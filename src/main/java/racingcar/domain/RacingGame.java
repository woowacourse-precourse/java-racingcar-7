package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play(final int attempts) {
        StringBuilder raceResult = new StringBuilder();
        for (int i = 0; i < attempts; i++) {
            race();
            raceResult.append(getRaceStatus()).append("\n");
        }
        System.out.println(raceResult.toString());
    }

    private void race(){
        for (final Car car : cars) {
            car.move();
        }
    }

    private String getRaceStatus() {
        StringBuilder status = new StringBuilder();
        for (Car car : cars) {
            status.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
        }
        return status.toString();
    }
}
