package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final static int CAR_MAX_LENGTH = 5;
    private final List<String> carNameList;
    private final int count;
    public RacingCar(String inputCars, int count) {
        this.carNameList = new ArrayList<>();
        this.count = count;
        splitCarNames(inputCars);
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    public int getCount() {
        return count;
    }

    private void splitCarNames(String inputCars){
        for (String carName : inputCars.split(",")) {
            if (isOverFiveChar(carName)) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            carNameList.add(carName.trim());
        }
    }

    private boolean isOverFiveChar(String car){
        return car.length() > CAR_MAX_LENGTH;
    }
}
