package racingcar;

public class CarMover {

    private final RandomNumberGenerator generator = new RandomNumberGenerator();

    public boolean run(final Car car) {
        int randomNumber = generator.run();
        return car.move(randomNumber);
    }

}
