package racingcar;

public class CarRegisterManager {

    private static final String NAME_DELIMITER = ",";
    private final RacingCars racingCars = new RacingCars();

    public RacingCars registerRacingCars(String names) {
        for(String name : names.split(NAME_DELIMITER)) {
            racingCars.add(RacingCar.from(name));
        }

        return racingCars;
    }

}
