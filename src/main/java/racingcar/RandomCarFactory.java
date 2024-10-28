package racingcar;


public class RandomCarFactory extends AbstractCarFactory {
    @Override
    public Car create(String name) {
        return Car.of(name, new RandomEngine());
    }
}
