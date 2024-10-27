package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final String carName;
    private final List<String> advanceResults;

    public RacingCar(String carName, List<String> advanceResult) {
        this.carName = carName;
        this.advanceResults = advanceResult;
    }

    public String[] splitCarsName(String inputCarsName) {
        String trimmedInput = inputCarsName.trim();
        String[] carsNames = trimmedInput.split(",");
        return carsNames;
    }

    public List<RacingCar> createRacingCarsBySplitCarsName(String[] carsNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carsNames) {
            racingCars.add(new RacingCar(carName, new ArrayList<>()));
        }
        return racingCars;
    }
}