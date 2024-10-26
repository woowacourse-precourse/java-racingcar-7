package racingcar;

public class CarRegisterManager {

    private static final String NAME_DELIMITER = ",";
    private final Cars cars = new Cars();

    public Cars register(String names) {
        for(String name : names.split(NAME_DELIMITER)) {
            cars.add(RacingCar.from(name));
        }

        return cars;
    }

}
