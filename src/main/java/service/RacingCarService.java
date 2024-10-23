package service;

import input.ValidatedInputData;
import policy.RacingPolicy;
import repository.Repository;
import vehicle.Car;

public class RacingCarService implements RacingService {
    private final ValidatedInputData validatedInputData;
    private final RacingPolicy racingPolicy;
    private final Repository repository;

    public RacingCarService(ValidatedInputData validatedInputData, RacingPolicy racingPolicy,
                            Repository repository) {
        this.validatedInputData = validatedInputData;
        this.racingPolicy = racingPolicy;
        this.repository = repository;
    }

    @Override
    public String racingStart() {
        String[] splitNames = validatedInputData.name().split(racingPolicy.getNameSeparator());
        return null;
    }

    public void createCar(String[] splitNames) {
        for (String name:splitNames) {
            Car car = new Car(name, racingPolicy);
        }
    }
}
