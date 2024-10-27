package racingcar;

public class Race {
    private Car[] cars;
    private int rounds;
    
    public Race(String[] carNames, int rounds) {
        this.cars = createCars(carNames);
        this.rounds = rounds;
    }

    private Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for(int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

}
