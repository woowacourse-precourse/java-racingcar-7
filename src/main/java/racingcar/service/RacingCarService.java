package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarService {
    private List<RacingCar> racingCars;

    public RacingCarService() {
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
        return Arrays.stream(inputCarsName.split(","))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public void createRacingCarsBySplitCarsName(String[] carsNames) {
        for (String carName : carsNames) {
            this.racingCars.add(new RacingCar(carName, new ArrayList<>()));
        }
    }
}
