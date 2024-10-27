package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RacingGame {
    final static String RACING_RESULT_LINE = " : ";
    final static String RACING_RESULT_FORWARD = "-";
    final static Integer MINIMUM_NUMBER_FORWARD = 3;
    final static String REGEX_PATTERN = "^[0-9]*$";

    private String[] cars;
    private String tryNumber;

    final private LinkedHashMap<String, Integer> groupedCars = new LinkedHashMap<>();

    public RacingGame(String[] cars, String tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public LinkedHashMap<String, Integer> getCarNumber() {
        groupCars(cars);
        //Validator.validate(cars);
        printMovingCars();
        return groupedCars;
    }

    public void printMovingCars() {
        for (int i=0; i<changeTryTimesNumber(); i++) {
            isCarMove();
            System.out.println();
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

    public Integer changeTryTimesNumber() {

        if (!Pattern.matches(REGEX_PATTERN,tryNumber)){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(tryNumber);
    }
}
