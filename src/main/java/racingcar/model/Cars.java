package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Cars {
    public static final int RANDOM_MIN_NUMBER = 0;
    public static final int RANDOM_MAX_NUMBER = 9;
    public static final int SAME_POSITION = 0;
    public static final String WINNER_SEPARATION_COMMA = ", ";
    public static final int START_INDEX = 0;
    public static final int TRIM_END_INDEX = 2;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    } // Cars

    public void move() {
        for (Car car : cars) {
            car.move(getPower());
        } // end for
    } // move

    public int getPower() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
    } // getPower

    public void descendingByPosition() {
        Collections.sort(cars);
    } // sortCars

    public Cars judgeWinnerCars() {
        Car maxPositionCar = cars.getFirst();
        cars.removeIf(car -> car.compareTo(maxPositionCar) != SAME_POSITION);
        return new Cars(cars);
    } // judgeWinnerCars

    public String getWinnersName() {
        StringBuilder winnersName = new StringBuilder();
        for (Car car : cars) {
            winnersName.append(car.getName()).append(WINNER_SEPARATION_COMMA);
        } // end for
        return removeLastComma(winnersName.toString());
    } // getWinnersName

    private String removeLastComma(String input) {
        return input.substring(START_INDEX, input.length() - TRIM_END_INDEX);
    } // applyWinnerPrintForm

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    } // getCars
} // class