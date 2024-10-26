package racingcar.domain;

import java.util.List;

public class RacingCar {
    private final String carName;
    private final List<String> advanceResult;

    public RacingCar(String carName, List<String> advanceResult) {
        this.carName = carName;
        this.advanceResult = advanceResult;
    }

    public void createRacingCars(String inputCarsName) {
        String[] carsName = splitCarsName(inputCarsName);
    }

    public String[] splitCarsName(String inputCarsName) {
        String trimmedInput = inputCarsName.trim();
        String[] carsNames = trimmedInput.split(",");
        return carsNames;
    }


}
