package racingcar;


public class RandomCarFactory extends AbstractCarFactory {
    @Override
    public Car create(String name) {
        return new Car(name, new RandomEngine());
    }
}
