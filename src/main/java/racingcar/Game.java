package racingcar;

public class Game {

    private final Cars cars;
    private final int rounds;

    public Game(Cars cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void race() {
        for (int i = 0; i < this.rounds; i++) {
            cars.go();
        }
    }
}
