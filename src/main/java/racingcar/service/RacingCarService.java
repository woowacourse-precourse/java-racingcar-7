package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarService {
    private final List<RacingCar> racingCars;
    private final CarNameValidator carNameValidator;

    private static final String SPLIT_SEPARATOR =",";

    public RacingCarService(CarNameValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
        this.racingCars = new ArrayList<>();
    }

    public void createRacingCars(String inputCarsName) {
        String[] carsNames = splitCarsName(inputCarsName);
        createRacingCarsBySplitCarsName(carsNames);
    }

    public void advanceRacingCarByRandomOrZero() {
        for (RacingCar racingCarTemp : racingCars) {
            int randomOrZero = racingCarTemp.getRandomOrZero();
            racingCarTemp.addRandomAdvanceResult(randomOrZero);
        }
    }

    public List<String[]> extractCarNameAndAdvanceResult() {
        List<String[]> carNameAndAdvanceResultList = new ArrayList<>();
        for (RacingCar racingCarTemp : this.racingCars) {
            String carNameTemp = racingCarTemp.getCarName();
            String advanceResultTemp = charListToString(racingCarTemp.getAdvanceResults());
            carNameAndAdvanceResultList.add(new String[]{carNameTemp, advanceResultTemp});
        }
        return carNameAndAdvanceResultList;
    }

    public String charListToString(List<Character> advanceResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character advanceSymbol : advanceResults) {
            stringBuilder.append(advanceSymbol);
        }
        return stringBuilder.toString();
    }

    public String[] splitCarsName(String inputCarsName) {
        return Arrays.stream(inputCarsName.split(SPLIT_SEPARATOR))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public void createRacingCarsBySplitCarsName(String[] carsNames) {
        for (String carName : carsNames) {
            carNameValidator.validateCarNameLength(carName);
            this.racingCars.add(new RacingCar(carName, new ArrayList<>()));
        }
    }
}
