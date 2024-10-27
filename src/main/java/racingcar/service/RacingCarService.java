package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private final RacingCar racingCar;
    private List<RacingCar> racingCars;

    public RacingCarService(RacingCar racingCar) {
        this.racingCar = racingCar;
    }

    public void createRacingCars(String inputCarsName) {
        String[] carsNames = racingCar.splitCarsName(inputCarsName);
        this.racingCars = racingCar.createRacingCarsBySplitCarsName(carsNames);
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
}
