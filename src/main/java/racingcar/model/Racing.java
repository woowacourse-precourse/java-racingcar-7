package racingcar.model;

public class Racing {
    private Car[] cars;
    private int attempts;

    public Racing(String[] cars, int attempts) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        }
        this.attempts = attempts;
    }
}