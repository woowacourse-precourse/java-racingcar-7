package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
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

    public void advanceRacingCars() {
        for (RacingCar car : racingCars) {
            if (car.shouldAdvance()) {
                car.addAdvanceResult();
            }
        }
    }

    public List<String[]> getCarNamesAndAdvanceResults() {
        List<String[]> carNameAndAdvanceResultList = new ArrayList<>();
        for (RacingCar car : racingCars) {
            String carName = car.getCarName();
            String advanceResult = convertAdvanceResultsToString(car.getAdvanceResults());
            carNameAndAdvanceResultList.add(new String[]{carName, advanceResult});
        }
        return carNameAndAdvanceResultList;
    }

    public String convertAdvanceResultsToString(List<Character> advanceResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character advanceSymbol : advanceResults) {
            stringBuilder.append(advanceSymbol);
        }
        return stringBuilder.toString();
    }

    public String[] splitCarsName(String inputCarsName) {
        String[] names = inputCarsName.split(SPLIT_SEPARATOR);
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
        return names;
    }

    public void createRacingCarsBySplitCarsName(String[] carsNames) {
        for (String carName : carsNames) {
            carNameValidator.validateCarNameLength(carName);
            carNameValidator.validateCarNameIsEmpty(carName);
            this.racingCars.add(new RacingCar(carName, new ArrayList<>()));
        }
    }

    public String selectCarRacingWinners() {
        int maxAdvanceCount = findMaxAdvanceCount();
        List<String> winners = findWinners(maxAdvanceCount);
        return formatWinners(winners);
    }

    private int findMaxAdvanceCount() {
        int max = 0;
        for (RacingCar car : racingCars) {
            int advanceCount = car.getAdvanceResults().size();
            if (advanceCount > max) {
                max = advanceCount;
            }
        }
        return max;
    }

    private List<String> findWinners(int maxAdvances) {
        List<String> winners = new ArrayList<>();
        for (RacingCar car : racingCars) {
            if (car.getAdvanceResults().size() == maxAdvances) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private String formatWinners(List<String> winners) {
        return String.join(", ", winners);
    }
}
