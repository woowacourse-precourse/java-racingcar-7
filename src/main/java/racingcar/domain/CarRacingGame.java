package racingcar.domain;

public class CarRacingGame {
    private final Cars cars;
    private final NumberGenerator numberGenerator;
    private int rounds;

    public CarRacingGame(Cars cars, NumberGenerator numberGenerator, int rounds) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
        this.rounds = rounds;
    }

    public Cars start() {
        cars.move(numberGenerator);
        rounds--;
        return cars;
    }

    public boolean canPlay() {
        if (cars.isEmpty()) {
            return false;
        }
        return rounds != 0;
    }
}
