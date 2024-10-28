package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private static final int CAR_MAX_LENGTH = 5;
    private static final int STANDARD = 4;
    private final List<String> carNameList;
    public final int[] results;

    public RacingCar(String inputCars) {
        this.carNameList = new ArrayList<>();
        splitCarNames(inputCars);
        this.results = new int[carNameList.size()];
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    private void splitCarNames(String inputCars) {
        for (String carName : inputCars.split(",")) {
            if (isOverFiveChar(carName.trim())) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            carNameList.add(carName.trim());
        }
    }

    public int[] racing() {
        for (int i = 0; i < carNameList.size(); i++) {
            if (RandomNumber.createRandomNums() >= STANDARD) {
                results[i]++;
            }
        }
        return results;
    }

    public List<String> getWinners() {
        int maxDistance = 0;
        for (int distance : results) {
            maxDistance = Math.max(maxDistance, distance);
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < results.length; i++) {
            if (results[i] == maxDistance) {
                winners.add(carNameList.get(i));
            }
        }
        return winners;
    }

    private boolean isOverFiveChar(String car) {
        return car.length() > CAR_MAX_LENGTH;
    }
}
