package racingcar.model;

public class RacingGame {
    private final Cars cars;
    private final Integer count;

    public RacingGame(Cars cars, Integer count) {
        this.cars = cars;
        this.count = count;
    }

    public void startGame() {
        for (int i = 0; i < count; i++) {
            cars.moveCars();
            cars.printCarDistance();
            System.out.println();
        }
    }
}
