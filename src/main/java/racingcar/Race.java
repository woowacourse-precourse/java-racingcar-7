package racingcar;

public class Race {
    private Car[] cars;
    private int rounds;
    
    public Race(String[] carNames, int rounds) {
        this.cars = createCars(carNames);
        this.rounds = rounds;
    }

    private Car[] createCars(String[] carNames) {
    }
}
