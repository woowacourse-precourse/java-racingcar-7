package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingGame {
    final static String RACING_RESULT_LINE = " : ";
    final static String RACING_RESULT_FORWARD = "-";
    final static Integer MINIMUM_NUMBER_FORWARD = 3;
    private String[] carNames;

    CarNameValidator carNameValidator;
    final private LinkedHashMap<String, Integer> groupedCars = new LinkedHashMap<>();

    public RacingGame(CarNameValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
    }

    public LinkedHashMap<String, Integer> getCarNumber() {
        String[] cars = carNameValidator.separateCarNames();

        groupCars(cars);
        carNameValidator.validate(cars);
        printMovingCars();
        return groupedCars;
    }

    public void printMovingCars() {
        int tryNumbers = carNameValidator.changeTryTimesNumber();
        for (int i=0; i<tryNumbers; i++) {
            isCarMove();
            System.out.println("");
        }
    }

    public void groupCars(String[] cars) {
        for (String car : cars) {
            groupedCars.put(car, 0);
        }
    }

    private void isCarMove() {
        for (Map.Entry<String, Integer> entry : groupedCars.entrySet()) {
            if (RandomNumbersPicker.pickRandomNumbers() > MINIMUM_NUMBER_FORWARD ) {
                groupedCars.put(entry.getKey(), entry.getValue()+1);
            }
            System.out.println(entry.getKey()+ RACING_RESULT_LINE + RACING_RESULT_FORWARD.repeat(entry.getValue()));
        }
    }
}
